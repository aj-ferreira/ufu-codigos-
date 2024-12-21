#include <bits/stdc++.h>
using namespace std;
struct Data {
    int dia;
    double valor;
};

int main() {
    std::vector<Data> data = {
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
    int conta0 = 0;
    
    for(int i = 0; i < data.size(); i++)
    {
        if(data[i].valor == 0)
            conta0++; //conta os dias que o faturamento foi 0
        
        avg += data[i].valor; //soma faturamentos pra fazer a media

        if(data[i].valor > maior ) //encontra maior
            maior = data[i].valor;

        if(data[i].valor < menor ) //encontra menor
            menor = data[i].valor;   
    }
    avg = (avg / (30 - conta0)); // calcula media


    /*for (const auto& d : data) {
        std::cout << "Dia: " << d.dia << ", Valor: " << d.valor << std::endl;
    }*/
    cout<<"Menor faturamento"<<menor<<endl;
    cout<<"Maior faturamento"<<maior<<endl;

    return 0;
}