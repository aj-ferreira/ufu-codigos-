#include <bits/stdc++.h>

using namespace std;
/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
*/
struct faturamento {
    int dia;
    double valor;
};

int main() {
    vector<faturamento> data = {
        {1, 22174.1664},
        {2, 24537.6698},
        {3, 26139.6134},
        {4, 0.0},
        {5, 0.0},
        {6, 26742.6612},
        {7, 0.0},
        {8, 42889.2258},
        {9, 46251.174},
        {10, 11191.4722},
        {11, 0.0},
        {12, 0.0},
        {13, 3847.4823},
        {14, 373.7838},
        {15, 2659.7563},
        {16, 48924.2448},
        {17, 18419.2614},
        {18, 0.0},
        {19, 0.0},
        {20, 35240.1826},
        {21, 43829.1667},
        {22, 18235.6852},
        {23, 4355.0662},
        {24, 13327.1025},
        {25, 0.0},
        {26, 0.0},
        {27, 25681.8318},
        {28, 1718.1221},
        {29, 13220.495},
        {30, 8414.61}
    };

    double avg=0, menor = data[0].valor, maior = data[0].valor;
    int contaZeros = 0, contaMaiores = 0;

    for(int i = 0; i < data.size(); i++)
    {
        if(data[i].valor == 0)
            contaZeros++; //conta os dias que o faturamento foi 0

        avg += data[i].valor; //soma faturamentos pra fazer a media

        if(data[i].valor > maior ) //encontra maior
            maior = data[i].valor;

        if(data[i].valor < menor ) //encontra menor
            menor = data[i].valor;
    }
    avg = (avg / (30 - contaZeros)); // calcula media

    for(int i = 0; i < data.size(); i++)
    {
        if(data[i].valor > avg)
            contaMaiores++; //conta os dias no mês em que o valor de faturamento diário foi superior à média mensal
    }

    cout<<"Menor faturamento = "<<menor<<endl;
    cout<<"Maior faturamento = "<<maior<<endl;
    cout<<"Quantidade de dias com faturamento superior à média mensal(RS"<<avg<<") = "<<contaMaiores<<endl;

    return 0;
}
