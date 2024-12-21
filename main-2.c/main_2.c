#include<stdio.h>
int main(){
    //AMANDA JULIA FERREIRA 12211BSI225
    int vet[10],i,j;
    printf("Entre 10 numeros inteiros: \n");
    for(i=0;i<10;i++){
        scanf("%d",&vet[i]);
        for(j=0;j<i;j++){
         if(vet[i]==vet[j]){
            printf("Numero repetido! Tente novamente! \n");

            scanf("%d",&vet[i]);


         }
        }

    }

    printf("\n");
    printf("Vetor digitado: \n");
    for(i=0;i<10;i++){
        printf("- %d",vet[i]);
    }

    return 0;
}
