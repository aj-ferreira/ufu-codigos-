import sys #para aceitar argumentos de linha de comando
import math #para cálculos de log 
import spacy
from collections import defaultdict

nlp = spacy.load("pt_core_news_lg")

# Variáveis globais necessárias
termo_freq = defaultdict(lambda: defaultdict(int)) #para armazenar a frequência de termos em cada documento
doc_quant = defaultdict(int) #para armazenar a quantidade de documentos que contém cada termo
quant_total_docs = 0 #para armazenar a quantidade total de documentos

def lematizador(texto):
    """
    Lematiza o texto fornecido, removendo stopwords, pontuações, espaços e os lemas que contenham espaços.
    Args:
        text (str): O texto a ser lematizado.
    Returns:
        list: Uma lista de termos lematizados em minúsculas, em ordem alfabética.
    """

    doc = nlp(texto.lower())
    termos_processados = []
    for token in doc:
        if not token.is_stop and not token.is_punct and not token.is_space and " " not in token.lemma_:
            termos_processados.append(token.lemma_.lower())
    
    return sorted(termos_processados)

def add_doc_ao_indice_invertido(doc, tokens):
    """
    Adiciona um documento ao índice invertido, atualizando a frequência de termos e a quantidade de documentos.
    Args:
        doc_file (str): O caminho do arquivo do documento a ser adicionado.
        tokens (list): Uma lista de tokens (palavras) extraídos do documento.
    Returns:
        None
    """
    
    for token in tokens:
        termo_freq[token][doc] += 1
    for token in set(tokens):
        doc_quant[token] += 1

def calcula_tfidf():
    """
    Calcula o índice tf-idf de um conjunto de documentos.
    Args:
        None
    Returns:
        dict: Um dicionário onde as chaves são os nomes identificadores dos documentos e os valores são dicionários contendo os termos e seus pesos tf-idf.
    """
    
    tfidf = defaultdict(dict)
    for termo, docs in termo_freq.items():
        for doc, freq in docs.items():
            tf = 1 + math.log10(freq)
            idf = math.log10(quant_total_docs / doc_quant[termo])
            tfidf[doc][termo] = tf * idf
    print('Cálculo TF-IDF finalizado!')
    #print(tfidf)
    #print(termo_freq)
    return tfidf

def salva_indice(term_freq, doc_map=None,nome_arquivo='indice.txt'):
    """
        Salva o índice invertido em um arquivo de texto.
        Args:
            term_freq (dict): Um dicionário onde as chaves são termos e os valores são dicionários
                com a frequência dos termos em cada documento.
            doc_map (dict, opcional): Um dicionário de mapeamento de documentos. As chaves são
                identificadores de documentos e os valores são nomes de arquivos ou caminhos.
            nome_arquivo (str, opcional): O nome do arquivo onde o índice será salvo.
        Returns:
            None
    """    
    
    if doc_map is None:
        doc_map = {}

    with open(nome_arquivo, 'w', encoding='utf-8') as arquivo:
        for termo, docs in term_freq.items():
            # Gerar as ocorrências no formato doc_id,freq
            ocorrencias = " ".join([f"{doc_map[doc]},{freq}" for doc, freq in docs.items()])
            arquivo.write(f"{termo}: {ocorrencias}\n")
    print(f"Índice salvo em {nome_arquivo}")

def salva_pesos(tfidf, output_file='pesos.txt'):
    """
    Salva os pesos calculados em um arquivo de texto.
    Args:
        tfidf (dict): Um dicionário onde as chaves são ids dos documentos e os valores são dicionários de termos com seus respectivos pesos .
        output_file (str, opcional): O caminho do arquivo onde os pesos serão salvos.
    O arquivo de saída terá o formato:
    doc_id: termo1, peso1 termo2, peso2 ...
    Notas:
        - Apenas termos com peso maior que 0 serão incluídos no arquivo.
        - Os pesos são arredondados para cima com 17 casas decimais.
    """
    with open(output_file, 'w', encoding='utf-8') as f:
        for doc, termos in tfidf.items():
            pesos = [f'{termo}, {round(peso, 17):.17f}' for termo, peso in termos.items() if peso > 0]
            if pesos:
                f.write(f'{doc}: {" ".join(pesos)}\n')

def processa_documentos(base_docs):
        """
        Processa uma lista de documentos, lendo o conteúdo de cada arquivo,
        lematizando o texto e adicionando os tokens ao índice invertido.
        Args:
            docs_base (list): Lista de caminhos para os arquivos de documentos a serem processados.
        Returns:
            None
        """
        
        for doc in base_docs:
            with open(doc, 'r', encoding='utf-8') as arquivo:
                texto = arquivo.read()
                tokens = lematizador(texto)
                #print('Texto ',texto, 'Tokens ',tokens)
                add_doc_ao_indice_invertido(doc, tokens)

def main(caminho_base):

    global quant_total_docs

    # 1 - ler os caminhos dos arquivos de documentos, e pegar o total de documentos
    with open(caminho_base, 'r', encoding='utf-8') as arquivo:
        base_docs = [linha.strip() for linha in arquivo.readlines()]
    quant_total_docs = len(base_docs)

    # 2 - processar os documentos, lematizando e contando as frequências 
    processa_documentos(base_docs)

    # 3 - calcular tf-idf
    tfidf = calcula_tfidf()

    #4- cria map auxiliar para mapear os documentos aos seus respectivos ids
    doc_map = {doc: i + 1 for i, doc in enumerate(base_docs)}
    
    # 5 - gerar os arquivos de saída
    salva_indice(termo_freq,doc_map)
    salva_pesos(tfidf)

if __name__ == '__main__':
    
    #Exemplo py tfidf.py base.txt
    base_docs = sys.argv[1]
    main(base_docs)
