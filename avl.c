#include <stdio.h>
#include <stdlib.h>

/**
 * Estrutura de dados para representar um nó de uma árvore AVL.
 *
 * @param lchild Ponteiro para o filho esquerdo do nó.
 * @param data Valor armazenado no nó.
 * @param h Altura do nó.
 * @param rchild Ponteiro para o filho direito do nó.
 */
struct node
{
    struct node *lchild;
    int data;
    int h; // altura
    struct node *rchild;
} *root = NULL;

/**
 * Calcula a altura de um nó em uma árvore AVL.
 *
 * @param p O ponteiro para o nó cuja altura será calculada.
 * @return A altura do nó.
 */
int alturaNode(struct node *p)
{
    int hLeftSubTree, hRightSubTree;
    // p é válido e tem subárvore para a esquerda? se sim, hLeftSubTree recebe a altura de p->lchild, senão recebe 0
    hLeftSubTree = p && p->lchild ? p->lchild->h : 0;
    // p é válido e tem subárvore para a direita? se sim, hRightSubTree recebe a altura de p->rchild, senão recebe 0
    hRightSubTree = p && p->rchild ? p->rchild->h : 0;
    // hLeftSubTree é maior que hRightSubTree? se sim, retorna hLeftSubTree+1, senão retorna hRightSubTree+1
    return hLeftSubTree > hRightSubTree ? hLeftSubTree + 1 : hRightSubTree + 1; // retorna o maior +1
}

/**
 * Calcula o fator de balanceamento de um nó da árvore AVL.
 *
 * O fator de balanceamento é calculado subtraindo a altura da subárvore esquerda
 * pela altura da subárvore direita.
 *
 * @param p O ponteiro para o nó da árvore AVL.
 * @return O fator de balanceamento do nó.
 */
int balanceFactor(struct node *p)
{
    // balance factor = altura da subárvore da esquerda - altura da subárvore da direita
    int hLeftSubTree, hRightSubTree;
    hLeftSubTree = p && p->lchild ? p->lchild->h : 0; // altura de hleftchild é altura da subárvore da esquerda ou 0
    hRightSubTree = p && p->rchild ? p->rchild->h : 0;
    return hLeftSubTree - hRightSubTree;
}

/**
 * Realiza uma rotação simples à esquerda (LL rotation) em uma árvore AVL.
 *
 * @param p O nó raiz da subárvore a ser rotacionada.
 * @return O novo nó raiz da subárvore após a rotação.
 */
struct node *LLrotation(struct node *p)
{
    struct node *pl = p->lchild;
    struct node *plr = pl->rchild;

    pl->rchild = p;
    p->lchild = plr;
    p->h = alturaNode(p);
    pl->h = alturaNode(pl);

    if (root == p)
        root = pl;
    return pl;
}

/**
 * Realiza uma rotação à esquerda (LR rotation) em uma árvore AVL.
 *
 * @param p O nó raiz da subárvore onde a rotação será realizada.
 * @return O novo nó raiz da subárvore após a rotação.
 */
struct node *LRrotation(struct node *p)
{
    struct node *pl = p->lchild;
    struct node *plr = pl->rchild;

    pl->rchild = plr->lchild;
    p->lchild = plr->rchild;
    plr->lchild = pl;
    plr->rchild = p;

    p->h = alturaNode(p);
    pl->h = alturaNode(pl);
    plr->h = alturaNode(plr);

    if (root == p)
        root = plr;
    return plr;
}

/**
 * Realiza uma rotação simples à direita (RR) em uma árvore AVL.
 *
 * @param p O nó a ser rotacionado.
 * @return O novo nó raiz após a rotação.
 */
struct node *RRrotation(struct node *p)
{
    struct node *pr = p->rchild;
    struct node *prl = pr->lchild;

    pr->lchild = p;
    p->rchild = prl;

    p->h = alturaNode(p);
    pr->h = alturaNode(pr);

    if (root == p)
        root = pr;

    return pr;
}

/**
 * Realiza uma rotação RL em uma árvore AVL.
 *
 * @param p O nó em que a rotação RL será realizada.
 * @return O novo nó raiz após a rotação RL.
 */
struct node *RLrotation(struct node *p)
{
    struct node *pr = p->rchild;
    struct node *prl = pr->lchild;

    pr->lchild = prl->rchild;
    p->rchild = prl->lchild;
    prl->rchild = pr;
    prl->lchild = p;

    p->h = alturaNode(p);
    pr->h = alturaNode(pr);
    prl->h = alturaNode(prl);

    if (root == p)
        root = prl;
    return prl;
}


/**
 * Insere um novo nó recursivamente em uma árvore AVL.
 *
 * @param p O ponteiro para a raiz da árvore.
 * @param key O valor a ser inserido.
 * @return O ponteiro para a raiz da árvore após a inserção.
 */
struct node *rInsertion(struct node *p, int key)
{
    struct node *t = NULL;
    if (p == NULL) // chegou na folha, cria novo nó
    {
        t = (struct node *)malloc(sizeof(struct node));
        if (t == NULL)
        {
            printf("erro na alocação \n");
        }
        t->data = key;
        t->h = 1;
        t->lchild = t->rchild = NULL;
        return t;
    }
    if (key < p->data) // insere para a esquerda
    {
        p->lchild = rInsertion(p->lchild, key);
    }
    else if (key > p->data) // insere para a direita
    {
        p->rchild = rInsertion(p->rchild, key);
    }
    // depois de inserir, atualiza altura
    p->h = alturaNode(p);
    // começar rotação
    if (balanceFactor(p) == 2 && balanceFactor(p->lchild) == 1) // desbalanceamento para a esquerda, esquerda
    {
        return LLrotation(p);
    }
    else if (balanceFactor(p) == 2 && balanceFactor(p->lchild) == -1) // desbalanceamento para a esquerda, direita
    {
        return LRrotation(p);
    }
    else if (balanceFactor(p) == -2 && balanceFactor(p->rchild) == -1) // desbalanceamento para a direita, direita
    {
        return RRrotation(p);
    }
    else if (balanceFactor(p) == -2 && balanceFactor(p->rchild) == 1) // desbalanceamento para a direita, esquerda
    {
        return RLrotation(p);
    }

    return p;
}

struct node *delete(struct node *p, int key)
{
    // TODO: Implement delete function
}

/**
 * Função responsável por exibir a árvore AVL.
 * 
 * @param p O ponteiro para o nó raiz da árvore.
 * @param space O espaço a ser adicionado entre os níveis da árvore.
 */
void displayTree(struct node *p, int space)
{
    if (p == NULL)
        return;

    // Increase distance between levels
    space += 10;

    // Process right child first
    displayTree(p->rchild, space);

    // Print current node after space
    // Count (number of spaces)
    printf("\n");
    for (int i = 10; i < space; i++)
        printf(" ");
    printf("%d\n", p->data);

    // Process left child
    displayTree(p->lchild, space);
}

int main()
{
    root = rInsertion(root, 10);
    rInsertion(root, 20);
    rInsertion(root, 12);
    rInsertion(root, 5);
    displayTree(root, 0);

    return 0;
}
