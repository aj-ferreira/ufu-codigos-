import sys
import math
import spacy
from collections import defaultdict

class TextProcessor:
    def __init__(self):
        # Carregar modelo do Spacy para lematização e remoção de stopwords
        self.nlp = spacy.load("pt_core_news_lg")
        self.stop_words = spacy.lang.pt.stop_words.STOP_WORDS

    def preprocess_text(self, text):
        """
        Processa o texto, removendo stopwords e pontuação, e realizando lematização.
        """
        doc = self.nlp(text)
        return [token.lemma_ for token in doc if not token.is_stop and not token.is_punct and not token.is_space and " " not in token.lemma_]


class TfidfCalculator:
    def __init__(self):
        self.term_freq = defaultdict(lambda: defaultdict(int))
        self.doc_count = defaultdict(int)
        self.total_docs = 0

    def add_document(self, doc_file, tokens):
        """
        Atualiza as frequências de termos e o número de documentos contendo cada termo.
        """
        for token in tokens:
            self.term_freq[token][doc_file] += 1
        for token in set(tokens):
            self.doc_count[token] += 1

    def compute_tfidf(self):
        """
        Calcula os pesos TF-IDF para cada termo em cada documento.
        """
        tfidf = defaultdict(dict)
        for term, docs in self.term_freq.items():
            for doc, freq in docs.items():
                tf = 1 + math.log10(freq)
                idf = math.log10(self.total_docs / self.doc_count[term])
                tfidf[doc][term] = tf * idf
        return tfidf


class OutputGenerator:
    @staticmethod
    def write_index(term_freq, output_file='indice.txt'):
        """
        Gera o arquivo de índice contendo os termos e os documentos em que aparecem.
        """
        with open(output_file, 'w',encoding='utf-8') as f:
            for term, docs in term_freq.items():
                f.write(f'{term}: {", ".join(docs.keys())}\n')

    @staticmethod
    def round_up(value, decimals):
        """
        Arredonda um número decimal para cima com a quantidade de casas decimais especificada.
        """
        factor = 10 ** decimals
        return math.ceil(value * factor) / factor

    @staticmethod
    def write_tfidf(tfidf, output_file='pesos.txt'):
        """
        Gera o arquivo de pesos contendo os valores TF-IDF de cada termo por documento.
        Os valores são arredondados para 4 casas decimais, com arredondamento para cima.
        """
        with open(output_file, 'w',encoding='utf-8') as f:
            for doc, terms in tfidf.items():
                weights = [f'{term}, {OutputGenerator.round_up(weight, 17):.17f}' for term, weight in terms.items() if weight > 0]
                if weights:
                    f.write(f'{doc}: {" ".join(weights)}\n')


class TfidfProgram:
    def __init__(self, base_file):
        self.base_file = base_file
        self.text_processor = TextProcessor()
        self.tfidf_calculator = TfidfCalculator()

    def run(self):
        """
        Executa o programa principal: processa os documentos, calcula TF-IDF e gera os arquivos de saída.
        """
        # Lê os caminhos dos arquivos de documentos
        doc_files = self._read_base_file()
        self.tfidf_calculator.total_docs = len(doc_files)

        # Processa cada documento
        for doc_file in doc_files:
            with open(doc_file, 'r', encoding='utf-8') as f:
                text = f.read()
                tokens = self.text_processor.preprocess_text(text)
                self.tfidf_calculator.add_document(doc_file, tokens)

        # Calcula TF-IDF
        tfidf = self.tfidf_calculator.compute_tfidf()

        # Gera os arquivos de saída
        OutputGenerator.write_index(self.tfidf_calculator.term_freq)
        OutputGenerator.write_tfidf(tfidf)

    def _read_base_file(self):
        """
        Lê o arquivo base.txt que contém os caminhos dos documentos da base.
        """
        with open(self.base_file, 'r',encoding='utf-8') as f:
            return [line.strip() for line in f.readlines()]


if __name__ == '__main__':
    if len(sys.argv) != 2:
        print("Uso: python3 tfidf.py base.txt")
        sys.exit(1)
    
    # Executa o programa principal com o arquivo base fornecido
    base_file = sys.argv[1]
    program = TfidfProgram(base_file)
    program.run()
