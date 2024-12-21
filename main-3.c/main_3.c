#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main(){
     //AMANDA JULIA FERREIRA 12211BSI225
    int i,qtd_n;
    float s=0.0;
    printf("Quantos valores serao lidos? \n");
    scanf("%d",&qtd_n);
    printf("Digite %d valores: \n",qtd_n);

    int v[qtd_n];

    for(i=0;i<qtd_n;i++){
        scanf("%d",&v[i]);
    }

    for(i=1;i<=qtd_n;i++){
        s= s + (v[i-1]/i*i);
    }
    printf("O resultado de s eh: %f",cbrt(s));
    return 0;
}
