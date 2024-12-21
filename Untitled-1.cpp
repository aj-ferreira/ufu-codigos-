#include <bits/stdc++.h>
using namespace std;
struct led{
    int n;
    led *next;
};

struct led *head = NULL;

void insert(int n)
{
    struct led *novo = new led;
    novo->n = n;
    novo->next = head; //insere na lista no inicio
    head = novo; //nova cabeça da lista
}

void insert_end(int n)
{
    struct led *novo = new led;
    novo->n = n;
    novo->next = NULL;

    if(head == NULL) //se a lista estiver vazia
    {
        head = novo;
        return;
    }
    
    struct led *temp = head;
    while(temp->next != NULL)
    {
        temp = temp->next; //andar o ponteiro até o final
    }
    
    temp->next = novo;
}
void display()
{
    struct led *temp = head;
    while(temp != NULL)
    {
        cout<< temp->n << " ";
        temp = temp->next; //andar o ponteiro
    }
    cout << endl;
}
void display_reverse()
{
    struct led *temp = head;
    vector<int> valores;
    while(temp != NULL)
    {
        valores.push_back(temp->n);
        temp = temp->next; //andar o ponteiro
    }
    reverse(valores.begin(), valores.end());
    for(auto i: valores)
    {
        cout << i << " ";
    }
    cout << endl;
}

int conta_nodes()
{
    struct led *temp = head;
    int cont = 0;
    while(temp != NULL)
    {
        cont++;
        temp = temp->next; //andar o ponteiro
    }
    return cont;
}

void middle_element()
{
    int tam = conta_nodes();
    struct led *temp = head;
    for(int i = 0; i < tam/2 ; i++)
    {
        temp = temp->next;
    }
    cout << "Elemento do meio: " << temp->n << endl;
    //em caso de lista com tamanho par, ele retorna o elemento do meio da direita
}

void insert_middle(int n)
{
    struct led *novo = new led;
    novo->n = n;
    novo->next = NULL;
    int tam = conta_nodes();

    if(tam == 0) //se a lista estiver vazia
    {
        head = novo;
        return;
    }

    struct led *temp = head;
    for(int i = 0; i < tam/2 ; i++)
    {
        temp = temp->next; //anda até o meio
    }
    novo->next = temp->next; //novo aponta pra frente do meio
    temp->next = novo; //meio aponta pro novo
}

void get_nth(int n)
{
    int tam = conta_nodes();
    if(n > tam)
    {
        cout << "Posicao invalida" << endl;
        return;
    }

    struct led *temp = head;
    for(int i = 0; i < n ; i++)
    {
        temp = temp->next; //anda até a posição desejada
    }

    cout << "Elemento na posicao " << n << ": " << temp->n << endl;

        
}

void insert_at(int p, int n) 
{
    int tam = conta_nodes();
    if(p > tam)
    {
        cout << "Posicao invalida" << endl;
        return;
    }   

    struct led *novo = new led;
    novo->n = n;
    novo->next = NULL;

    struct led *temp = head;
    for(int i = 0; i < p-1 ; i++)
    {
        temp = temp->next; //anda até a posição desejada - 1
    }
    novo->next = temp->next;
    temp->next = novo;
}
void delete_first()
{
    if(head != NULL){struct led *temp = head;
    head = head->next;
    free(temp);}
}
void delete_middle()
{
    int tam = conta_nodes();
    struct led *temp = head;
    for(int i = 0; i < tam/2 ; i++)
    {
        temp = temp->next; //anda até o meio
    }
    struct led *temp2 = temp->next;
    temp->next = temp2->next;
    free(temp2);
}
void delete_end()
{
    struct led *temp = head;
    while(temp->next->next != NULL)
    {
        temp = temp->next; //andar o ponteiro até o penultimo
    }
    struct led *temp2 = temp->next; //temp2 aponta pro ultimo
    temp->next = NULL; //penultimo aponta pra NULL
    free(temp2);
}
void delete_at(int p)
{
    int tam = conta_nodes();
    if(p > tam)
    {
        cout << "Posicao invalida" << endl;
        return;
    }   

    struct led *temp = head;
    for(int i = 0; i < p-1 ; i++)
    {
        temp = temp->next; //anda até a posição desejada - 1
    }
    struct led *temp2 = temp->next;
    temp->next = temp2->next;
    free(temp2);
}
int find_nth(int n)
{
    //Write a C++ program to find the kth node of a linked list by
    // starting at the middle and moving towards the head
    int tam = conta_nodes();
    if(n > tam/2)
    {
        cout << "Posicao invalida" << endl;
        return NULL;
    }
    struct led *temp = head;
    vector<int> valores;
    for(int i = 0 ; i < tam/2 ; i++)
    {
        valores.push_back(temp->n);
        temp = temp->next; //anda até o meio
    }//terminar aqui!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    

    return NULL;
}
int main()
{
    insert(1); //5->4->3->2->1
    insert(2);
    insert(3);
    insert(4);
    insert(5);
    display();
    display_reverse();
    cout << "Total de nodes: " << conta_nodes() << endl;
    insert_end(6); //5->4->3->2->1->6
    display();
    cout << "Elemento do meio: " << endl;
    middle_element();
    insert_middle(7); //5->4->3->2->7->1->6
    display();
    get_nth(3); 
    insert_at(3,8);
    display();
    delete_first();
    display();
    delete_middle();
    display();
    delete_end();
    display();
    cout << "posicao 2:" <<find_nth(2) << endl;
    display();
    return 0;
}