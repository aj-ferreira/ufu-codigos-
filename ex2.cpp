
#include <bits/stdc++.h>

using namespace std;
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