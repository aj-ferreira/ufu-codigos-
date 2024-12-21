import spacy

nlp = spacy.load('pt_core_news_lg')

def lematizar_documento(texto):
    """
    Lematiza um documento de texto, removendo stopwords, pontuação e espaços.
    Args:
        texto (str): O texto a ser lematizado.
    Returns:
        list: Uma lista de termos lematizados e ordenados em letras minúsculas.
    """
    # Converter para minúsculas e processar o documento com spaCy
    doc = nlp(texto.lower())  
    termos_processados = []
    
    # Iterar pelos tokens, removendo stopwords, pontuação e espaços
    for token in doc:
        if not token.is_stop and not token.is_punct and not token.is_space and " " not in token.lemma_:
            # Adicionar o lema em minúsculas
            termos_processados.append(token.lemma_.lower())
    
    # Retornar a lista de termos lematizados e ordenados
    return sorted(termos_processados)


def lematizar_consulta(consulta):
    """
    Lematiza os termos de uma consulta.

    Args:
        consulta (str): A string contendo a consulta a ser lematizada.

    Returns:
        list: Uma lista de termos lematizados da consulta.
    """
    if "!" in consulta:
        consulta = consulta.replace("!", "! ")
    doc_consulta = nlp(consulta.lower())
    termos_da_consulta_lematizados = []
    for token in doc_consulta:
        termos_da_consulta_lematizados.append(token.lemma_)
    return termos_da_consulta_lematizados

def gerar_indice_invertido(base_documentos):
    """
    Gera um índice invertido a partir de uma base de documentos.
    Args:
        base_documentos (list): Lista de caminhos para os documentos.
    Returns:
        dict: Um dicionário onde as chaves são termos lematizados e os valores são
              dicionários contendo o ID do documento e a frequência do termo nesse documento.
    """
    indice_invertido = {} 

    for idx, caminho_doc in enumerate(base_documentos):
        with open(caminho_doc, 'r', encoding='utf-8') as arquivo:
            texto = arquivo.read()
            termos = lematizar_documento(texto)
            
            for termo in termos:
                if termo not in indice_invertido:
                    indice_invertido[termo] = {}  # Inicializa o termo se não existir
                
                if (idx + 1) not in indice_invertido[termo]:
                    indice_invertido[termo][idx + 1] = 0  # Inicializa o contador de frequência

                indice_invertido[termo][idx + 1] += 1  # Incrementa o contador

    return indice_invertido

def pega_documentos_do_termo(termo, indice_invertido):
    """
    Retorna os documentos associados a um termo específico no índice invertido.

    Args:
        termo (str): O termo a ser buscado no índice invertido.
        indice_invertido (dict): O índice invertido onde os termos e documentos estão armazenados.

    Returns:
        dict_keys: Os documentos associadas ao termo no índice invertido.
    """
    return indice_invertido.get(termo, {}).keys()

def faz_shunting_yard(consulta):
    """
    Converte uma expressão lógica infixa em uma expressão pós-fixa (notação polonesa reversa) 
    usando o algoritmo Shunting Yard.
    Parâmetros:
    consulta (list): Lista de tokens representando a expressão lógica original.
    Retorna:
    list: Lista de tokens representando a expressão lógica em notação pós-fixa.
    """
    # Definir a precedência e associatividade dos operadores
    precedencia = {'!': 3, '&': 2, '|': 1}
    associatividade = {'!': 'direita', '&': 'esquerda', '|': 'esquerda'}

    saida = []  
    operadores = [] 
    
    tokens = consulta
    
    for token in tokens:
        if token not in precedencia:
            saida.append(token)
        else:
            while (operadores and
                   (precedencia[operadores[-1]] > precedencia[token] or
                    (precedencia[operadores[-1]] == precedencia[token] and associatividade[token] == 'esquerda'))):
                saida.append(operadores.pop())
            operadores.append(token)
    
    # Desempilhar operadores restantes
    while operadores:
        saida.append(operadores.pop())
    
    return saida

def aplicar_operador(operando1, operando2, operador):
    """
    Aplica um operador binário ('&' ou '|') entre dois operandos.

    Args:
        operando1 (set): O primeiro operando.
        operando2 (set): O segundo operando.
        operador (str): O operador binário ('&' para AND, '|' para OR).

    Returns:
        set: O resultado da operação binária entre os operandos.
    """
    if operador == '&':
        return operando1 & operando2
    elif operador == '|':
        return operando1 | operando2

def aplicar_operador_unario(operando, operador, tamanho_base):
    """
    Aplica um operador unário a um conjunto de documentos.

    Args:
        operando (set): Conjunto de documentos a serem operados.
        operador (str): Operador unário a ser aplicado ('!' para negação).
        tamanho_base (int): Número total de documentos na base.

    Returns:
        set: Conjunto de documentos resultante após a aplicação do operador.
    """
    # Inicialmente conterá todos os documentos, depois remove os negados
    documentos = set(range(1, tamanho_base + 1))
    if operador == '!':
        documentos -= operando
    return documentos

def resolver_posfixa(expressao, tamanho_base):
    """
    Resolve uma expressão booleana em notação pós-fixa.
    Args:
        expressao (list): Lista de tokens representando a expressão booleana em notação pós-fixa.
        tamanho_base (int): Tamanho da base para operações unárias.
    Retorna:
        resultado: Resultado da avaliação da expressão booleana.
    A função utiliza uma pilha para avaliar a expressão:
    - Se o token é um operando, ele é empilhado.
    - Se o token é um operador unário ('!'), aplica o operador ao topo da pilha.
    - Se o token é um operador binário ('&', '|'), aplica o operador aos dois elementos do topo da pilha.
    """
    pilha = []
    operadores = ['&', '|', '!']
    
    tokens = expressao
    
    for token in tokens:
        if token not in operadores:  
            pilha.append(token)
        elif token == '!':
            operando = pilha.pop()
            pilha.append(aplicar_operador_unario(operando, token, tamanho_base))
        elif token in ('&', '|'):
            operando2 = pilha.pop()
            operando1 = pilha.pop()
            pilha.append(aplicar_operador(operando1, operando2, token))
    
    resultado = pilha.pop()
    return resultado

def salvar_indice(indice_invertido, nome_arquivo='indice.txt'):
    """
    Salva o índice invertido em um arquivo de texto.

    Args:
        indice_invertido (dict): Índice invertido no formato {termo: {doc_id: freq}}.
        nome_arquivo (str, opcional): Nome do arquivo onde o índice será salvo. Padrão é 'indice.txt'.

    Funcionalidade:
        - Abre um arquivo para escrita com o nome especificado.
        - Para cada termo no índice invertido, escreve o termo seguido das ocorrências (doc_id, freq).
        - Exibe uma mensagem indicando que o índice foi salvo com sucesso.
    """
    with open(nome_arquivo, 'w', encoding='utf-8') as arquivo:
        for termo, documentos in sorted(indice_invertido.items()):
            ocorrencias = " ".join([f"{doc_id},{freq}" for doc_id, freq in sorted(documentos.items())])
            arquivo.write(f"{termo}: {ocorrencias}\n")
    print(f"Índice invertido salvo no arquivo {nome_arquivo}")

def salvar_resposta(documentos_validos, base_documentos, nome_arquivo='resposta.txt'):
    """
    Salva a resposta em um arquivo de texto.

    Args:
        documentos_validos (list): Lista de IDs dos documentos válidos.
        base_documentos (list): Lista com os nomes dos documentos.
        nome_arquivo (str, opcional): Nome do arquivo onde a resposta será salva. Padrão é 'resposta.txt'.

    Funcionalidade:
        - Abre um arquivo para escrita com o nome especificado.
        - Escreve o número de documentos válidos na primeira linha.
        - Para cada ID de documento válido, escreve o nome correspondente do documento no arquivo.
        - Exibe uma mensagem indicando que a resposta foi salva com sucesso.
    """
    with open(nome_arquivo, 'w', encoding='utf-8') as arquivo:
        arquivo.write(f"{len(documentos_validos)}\n")  # Número de documentos
        for doc_id in sorted(documentos_validos):
            arquivo.write(f"{base_documentos[doc_id - 1]}\n")  # Nome dos documentos
    print(f"Resposta salva no arquivo {nome_arquivo}")


def processar_consulta(consulta,indice_invertido, base_documentos):
    """
        Processa uma consulta booleana em uma base de documentos.
        Args:
            consulta (str): A consulta booleana a ser processada.
            indice_invertido (dict): O índice invertido contendo os termos e os documentos correspondentes.
            base_documentos (list): A lista de documentos na base.
        Returns:
            list: Uma lista de documentos que satisfazem a consulta booleana.
    """
    docs_pos_fixo = faz_shunting_yard(lematizar_consulta(consulta))

    for i, d in enumerate(docs_pos_fixo):
        if d not in {"&", "|", "!"}:
            docs_pos_fixo[i] = pega_documentos_do_termo(d,indice_invertido) 
    
    docs_pos_fixo = resolver_posfixa(docs_pos_fixo, len(base_documentos))

    return docs_pos_fixo

def main(caminho_base, caminho_consulta):
    with open(caminho_base, 'r', encoding='utf-8') as base:
        base_documentos = [linha.strip() for linha in base.readlines()]
    
    #Gerar o índice invertido com os documentos da base
    indice_invertido = gerar_indice_invertido(base_documentos)
    print("gerou o indice invertido")

    # Salvar o índice no arquivo indice.txt
    salvar_indice(indice_invertido)

    # Processar a consulta
    with open(caminho_consulta, 'r', encoding='utf-8') as arquivo_consulta:
        consulta = arquivo_consulta.read().strip()
        print('consulta:', consulta)

    documentos_validos = processar_consulta(consulta, indice_invertido, base_documentos)
    
    # Salvar o resultado no arquivo resposta.txt
    salvar_resposta(documentos_validos, base_documentos)

if __name__ == '__main__':
    main('base_samba.txt', 'consulta_samba2.txt')
    
    #comando do teste
    #ao rodar o teste, a base e consulta desejada deve constar na chamada da função main e também na linha de comando
    #python waxm_corretor_modelo_booleano.pyc base.txt consulta4.txt modelo_booleano.py
    #python waxm_corretor_modelo_booleano.pyc base_samba.txt consulta_samba.txt modelo_booleano.py
