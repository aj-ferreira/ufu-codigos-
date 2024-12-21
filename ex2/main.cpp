
#include <bits/stdc++.h>

using namespace std;
/*
2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE:
Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
*/
int main()
{

    int n;
    int f1=0, f2=1, f3=0;
    cout<<"Entre um numero:"<<endl;
    cin>>n;
    if(n < 0)
    {
     cout<<"ERRO! Apenas numeros naturais."<<endl;
     main();
    }

    if(n == 0)
        cout<<"n ="<<n<< "pertence à sequencia"<<endl;
    else
    {
        cout<<"0 - 1";
        while(f3 < n)
        {
            f3 = f1 + f2;      //obtem termo atual a partir do 3º
            cout<<" - "<<f3;   //printa termo atual
            f1 = f2;
            f2 = f3;
        }

        if(f3 == n)
            cout<<endl<<"n ="<<n<< " pertence à sequencia"<<endl;
        else
            cout<<endl<<"n  ="<<n<< " não pertence à sequencia"<<endl;
    }

    return 0;
}
