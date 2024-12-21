#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAXX 4
#define MAXY 4

//trabalho da monitoria

struct Data
{
    int dia;
    int mes;
    int ano;
    
};

struct infoQuadrante {
    struct Data data;  
    int intensidade;
    int caiuRaio;
    char tempo[15];
};


int main(){
    int w = 1;
    int op;
    int contaRaios = 0;
    int py,px;
    char aux2[5]="----";

    struct infoQuadrante arr[MAXX][MAXY];

    //inicia os valores inteiros com 0
    for (int i = 0; i < MAXX; i++) {
        for (int j = 0; j < MAXY; j++) {
             (*(arr + i)+j)->intensidade = 0;
             (*(arr + i)+j)->caiuRaio = 0;
             (*(arr + i)+j)->data.dia = 0;
             (*(arr + i)+j)->data.ano = 0;
             (*(arr + i)+j)->data.mes = 0;
             strcpy((*(arr + i)+j)->tempo,aux2);
        }
    }

    while (w) {
        printf("Escolha uma opcao:\n");
        printf("[1] Marcar raio\n");
        printf("[2] Ver quantos raios cairam\n");
        printf("[3] Ver quantas areas nao cairam raios\n");
        printf("[4] Ver matriz\n");
        printf("[5] Sair\n");
        scanf("%d", &op);

        switch (op) {
            case 1:
            {
                printf("De 0 a %d, em qual posicao do eixo X caiu o raio?\n", (MAXX-1));
                scanf("%d", &px);
                while( px > MAXX || px < 0)
                {
                    printf("Necessario digitar valores validos (entre 0 e %d). Tente novamente!\n",(MAXX-1));
                    scanf("%d",&px);
                }

                
                printf("De 0 a %d, em qual posicao do eixo Y caiu o raio?\n", (MAXY-1));
                scanf("%d", &py);
                 while( py > MAXY || py < 0)
                {
                    printf("Necessario digitar valores validos (entre 0 e %d). Tente novamente!\n",(MAXY-1));
                    scanf("%d",&py);
                }
                
                //checa se ja tem registro de raio nessa coordenada
                if((*(arr+px)+py)->caiuRaio > 0){
                    printf("Regiao ja registrada. Encerrando...\n");
                    break;
                }else{

                printf("Que dia caiu o raio?\n");  //se nao segue para o registro
                setbuf(stdin,NULL); //limpa buffer
                scanf("%d",&(*(arr+px)+py)->data.dia );
                //chaeca se data eh valida
                while((*(arr+px)+py)->data.dia < 1 || (*(arr+px)+py)->data.dia > 31 ){ 
                    printf("Data invalida, tente novamente! Valores entre 1 e 31\n");
                    setbuf(stdin,NULL); //limpa buffer
                    scanf("%d",&(*(arr+px)+py)->data.dia );
                    
                }
                
                printf("Que mes caiu o raio?\n");
                scanf("%d",&(*(arr+px)+py)->data.mes );
                //checa se data eh valida
                while((*(arr+px)+py)->data.mes < 1 || (*(arr+px)+py)->data.mes > 12 ){
                    printf("Data invalida, tente novamente! Valores entre 1 e 12\n");
                    setbuf(stdin,NULL); //limpa buffer
                    scanf("%d",&(*(arr+px)+py)->data.mes );
                }
                
                printf("Que ano caiu o raio?\n");
                scanf("%d",&(*(arr+px)+py)->data.ano );
                //checa se data eh valida
                while((*(arr+px)+py)->data.ano < 0 || (*(arr+px)+py)->data.ano > 2023 ){
                    printf("Data invalida, tente novamente! Valores entre 0 e 2023\n");
                    setbuf(stdin,NULL); //limpa buffer
                    scanf("%d",&(*(arr+px)+py)->data.ano );
                    
                }
                
                printf("Como estava o tempo?\n");
                setbuf(stdin,NULL);
                fgets((*(arr+px)+py)->tempo,15,stdin);

                printf("Qual era a intensidade do raio?\n");
                scanf("%d",&(*(arr+px)+py)->intensidade);

                (*(arr+px)+py)->caiuRaio = 1;
                break;
                }
            }
            case 2:
            {
                contaRaios = 0;     
                for (int i = 0; i < MAXX; i++) {
                    for (int j = 0; j < MAXY; j++) {

                        if ( (*(arr + i)+j)->caiuRaio != 0) 
                        {    
                            contaRaios ++;
                        }
                    }
                }

                printf("\n Cairam %d raios\n", contaRaios);
                break;
            }
            case 3:
            {
                int contaOndeNaoCaiu =  (MAXX*MAXY) - contaRaios;
                printf("Nao cairam raios em %d regioes\n", contaOndeNaoCaiu);
                break;
            }
            case 4:
            {
                printf("Matriz [%d][%d]:\n",MAXX,MAXY);
                for (int i = 0; i < MAXX; i++) {      //printa as regioes
                    
                    for (int j = 0; j < MAXY; j++) {

                        printf("| ");
                        if( (*(arr + i)+j)->caiuRaio != 0){
                            printf("X");
                        }else{
                            printf(" ");
                        }
                        printf("|");
                        

                    }
                    printf("\n");
                }
                break;
            }
            case 5: //sai do menu
            {
                printf("Saindo...\n");
                w = 0;
                break;
            }
            default:
                printf("Opcao invalida\n");
                break;
        }
    }

    return 0;
}
