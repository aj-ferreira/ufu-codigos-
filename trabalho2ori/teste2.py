from collections import defaultdict
import math
import sys
import spacy

nlp = spacy.load('pt_core_news_lg')
termo_freq = defaultdict(lambda: defaultdict(int))
doc_quant = defaultdict(int)
quant_total_docs = 0

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

def calcula_tfidf(index_file='indice.txt'):
    """
    Calcula os pesos TF-IDF para cada termo em cada documento baseado no arquivo de índice.
    """
    tfidf = defaultdict(dict)
    termo_freq = defaultdict(lambda: defaultdict(int))
    doc_quant = defaultdict(int)
    quant_total_docs = 0

    # Lê o arquivo de índice
    with open(index_file, 'r', encoding='utf-8') as f:
        for line in f:
            # Verifica se a linha contém o formato esperado (termo: documentos)
            if ': ' in line:
                termo, docs = line.strip().split(': ')
                docs = docs.split(' ')  # Divide pelos pares doc,freq separados por espaço
                for doc_freq in docs:
                    if ',' in doc_freq:
                        doc, freq = doc_freq.split(',')
                        freq = int(freq)
                        termo_freq[termo][doc] = freq
                        doc_quant[termo] += 1
                        quant_total_docs = max(quant_total_docs, int(doc))

    # Calcula TF-IDF
    for termo, docs in termo_freq.items():
        for doc, freq in docs.items():
            tf = 1 + math.log10(freq)
            idf = math.log10(quant_total_docs / doc_quant[termo])
            tfidf[doc][termo] = tf * idf

    return tfidf

def round_up(value, decimals):
    """
    Arredonda um número decimal para cima com a quantidade de casas decimais especificada.
    """
    factor = 10 ** decimals
    return math.ceil(value * factor) / factor

def salva_pesos(tfidf, output_file='pesos.txt'):
    """
    Gera o arquivo de pesos contendo os valores TF-IDF de cada termo por documento.
    Os valores são arredondados para 4 casas decimais, com arredondamento para cima.
    """
    with open(output_file, 'w', encoding='utf-8') as f:
        for doc, terms in tfidf.items():
            weights = [f'{term}, {round_up(weight, 17):.17f}' for term, weight in terms.items() if weight > 0]
            if weights:
                f.write(f'{doc}: {" ".join(weights)}\n')

def main(caminho_base):
    global quant_total_docs

    with open(caminho_base, 'r', encoding='utf-8') as base:
        base_documentos = [linha.strip() for linha in base.readlines()]
    quant_total_docs = len(base_documentos)
    
    #Gerar o índice invertido com os documentos da base
    indice_invertido = gerar_indice_invertido(base_documentos)
    print("gerou o indice invertido")

    tfidf = calcula_tfidf()

    # Salvar o índice no arquivo indice.txt
    salvar_indice(indice_invertido)
    salva_pesos(tfidf)

    
if __name__ == '__main__':
    docs_base = sys.argv[1]
    main(docs_base)