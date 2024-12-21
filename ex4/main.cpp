#include <bits/stdc++.h>
using namespace std;
/*
4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

SP – R$67.836,43
RJ – R$36.678,66
MG – R$29.229,88
ES – R$27.165,48
Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.
*/
struct faturamento {
    string estado;
    double valor;
};
int main() {
    vector<faturamento> data = {{"SP",67836.43},{"RJ",36678.66},{"MG",29229.88},{"ES",27165.48},{"Outros",19849.53}};
    double totalMensal = 0;
    for(int i = 0; i < data.size() ; i++)
    {
        totalMensal+=data[i].valor; //calcula o total
    }
    //calcula o percentual
    for(int i = 0; i < data.size() ; i++)
    {

        cout<<data[i].estado<<" = " << fixed << setprecision(2)<<100 * data[i].valor/totalMensal<< "% do total de "<<totalMensal<<endl;
    }

    return 0;
}
