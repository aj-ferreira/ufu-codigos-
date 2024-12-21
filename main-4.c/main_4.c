#include<stdio.h>
#include<stdlib.h>


int main(){
     //AMANDA JULIA FERREIRA 12211BSI225
    int i;
    int qtd_n = 0;
    float media=0;
    float d = 0.0;

    printf("Quantos valores serao lidos? \n");
    scanf("%d",&qtd_n);
    printf("Digite %d valores: \n",qtd_n);

    float V[qtd_n];

    for(i=0;i<qtd_n;i++){
        scanf("%f",&V[i]);
    }
    //calculo da media
    for(i=0;i<qtd_n;i++){
        media= media + V[i];
    }
    media=media/qtd_n;
    printf("A media da amostra eh: %.2f \n",media);

    //calculo da variancia
    for(i=0;i<qtd_n;i++){

       d +=  (V[i]-media)*( V[i]-media)/(qtd_n-1);
    }
    printf("A variancia da amostra eh: %f",d);


    return 0;
}
