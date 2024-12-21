#include <stdio.h>
#include <stdlib.h>

// Estrutura para representar um pedido de disco
struct Request {
    int cilindro;
    int direcao;
};

// Função para comparar dois pedidos com base em seus cilindros
int compareRequests(const void *a, const void *b) {
    struct Request *req1 = (struct Request *)a;
    struct Request *req2 = (struct Request *)b;

    return req1->cilindro - req2->cilindro;
}

// Função para executar o algoritmo SSTF
void sstf(struct Request *requests, int num_requests) {
    // Inicializa o cabeçote do disco na posição 0
    int head = 0;

    // Ordena os pedidos com base em seus cilindros
    qsort(requests, num_requests, sizeof(struct Request), compareRequests);

    // Percorre os pedidos
    for (int i = 0; i < num_requests; i++) {
        // Calcula a distância entre o cabeçote do disco e o cilindro do pedido atual
        int distance = abs(head - requests[i].cilindro);

        // Move o cabeçote do disco para o cilindro do pedido atual
        head = requests[i].cilindro;

        // Imprime o número do cilindro e a distância percorrida
        printf("Movendo para o cilindro %d (distancia: %d)\n", head, distance);
    }
}

// Função principal
int main() {
    // Cria um conjunto de pedidos de disco
    struct Request requests[] = {
        {176, 1},
        {79, 1},
        {190, 1},
        {92, 1},
        {160, 1},
        {8, 1},
        {48, 1},
        {94, 1},
        {205, 1},
    };

    // Obtém o número de pedidos
    int num_requests = sizeof(requests) / sizeof(struct Request);

    // Executa o algoritmo SSTF
    sstf(requests, num_requests);

    return 0;
}
