#include<stdio.h>
int main(){
  //AMANDA JULIA FERREIRA 12211BSI225
  int i, troca,j;
  float a[20]={3.0,14.0,27.0,32.0,6.0,5.0,8.0,9.0,41.0,18.0,12.0,13.0,49.0,37.80,16.0,69.0,130.0,71.0,92.0,36.0};

  printf("\n");
  printf("Vetor antes da ordenacao: \n");
  for(i=0;i<20;i++){
     printf("%.2f - ",a[i]);
  }
  printf("\n");
  for(i=0;i<20;i++){
    for(j=i+1;j<20;j++){
       if(a[i]>a[j]){
        troca=a[i];
        a[i]=a[j];
        a[j]=troca;
        }
    }
   }


  printf("Vetor ordenado: \n");

  for(i=0;i<20;i++){
     printf("%.2f - ",a[i]);
  }


    return 0;
}
