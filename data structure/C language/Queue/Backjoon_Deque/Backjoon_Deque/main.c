#include<stdio.h>
#include<stdlib.h>

typedef int element;
typedef struct Node {
    element data;
    struct Node* next;
} Node;

typedef struct Queue {
    Node* front;
    Node* rear;
    int size;
} Queue;

void init_queue(Queue* Q) {
    Q->front = NULL;
    Q->rear = NULL;
    Q->size = 0;
}

int EMPTY(Queue* Q) {
    if (Q->size == 0) return 1;
    else return 0;
}

void ENDEQUE_FRONT(Queue* Q, element Data) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->data = Data;
    if (EMPTY(Q)) {
        new_node->next = NULL;
        Q->front = new_node;
        Q->rear = new_node;
    }
    else {
        new_node->next = Q->front;
        Q->front = new_node;
    }
    Q->size++;
}

void ENDEQUE_BACK(Queue* Q, element Data) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->data = Data;
    new_node->next = NULL;
    if (EMPTY(Q)) {
        Q->front = new_node;
        Q->rear = new_node;
    }
    else {
        Q->rear->next = new_node;
        Q->rear = Q->rear->next;
    }
    Q->size++;
}

element DEDEQUE_FRONT(Queue* Q) {
    element pop;

    if (Q->size == 0) pop = -1;
    else {
        Node* temp = (Node*)malloc(sizeof(Node));
        pop = Q->front->data;
        temp = Q->front->next;
        free(Q->front);
        Q->front = temp;
        temp = NULL;
        free(temp);
        Q->size--;
    }
    return pop;
}
int SIZE(Queue* Q) {
    return Q->size;
}

element DEDEQUE_BACK(Queue* Q) {
    element pop;

    if (Q->size == 0) pop = -1;
    else {
        Node* temp = (Node*)malloc(sizeof(Node));
        pop = Q->rear->data;
        temp = Q->front;
        while(temp->next == Q->rear) {
            temp = temp->next;
        }
        free(Q->rear);
        Q->rear = temp;
        temp = NULL;//왜 이렇게 했을까? 정답은 temp를 NULL로 하지 않고 free 하면 Q->rear 부분도 같이 free 된다.
        free(temp);
        Q->size--;
    }
    return pop;
}

element FRONT(Queue* Q) {
    element Front;
    if (EMPTY(Q)) Front = -1;
    else Front = Q->front->data;
    return Front;
}
element BACK(Queue* Q) {
    element Back;
    if (EMPTY(Q)) Back = -1;
    else Back = Q->rear->data;
    return Back;
}


int main() {
    element num;//ins 명령어 num 정수 X, NUM 명령어 개수
    int NUM;
    char ins[12];
    Queue q;
    init_queue(&q);

    scanf("%d\n", &NUM);

    while (NUM--) {
        scanf("%s", ins);
        if (!strcmp(ins, "push_front")) {
            scanf("%d", &num);
            ENDEQUE_FRONT(&q, num);
        }

        else if (!strcmp(ins, "push_back")) {
            scanf("%d", &num);
            ENDEQUE_BACK(&q, num);
        }

        else if(!strcmp(ins, "pop_front")) printf("%d\n", DEDEQUE_FRONT(&q));
        
        else if(!strcmp(ins, "pop_back")) printf("%d\n", DEDEQUE_BACK(&q));

        else if(!strcmp(ins, "size")) printf("%d\n", SIZE(&q));

        else if(!strcmp(ins, "empty")) printf("%d\n", EMPTY(&q));
        
        else if(!strcmp(ins, "front")) printf("%d\n", FRONT(&q));
        
        else if(!strcmp(ins, "back")) printf("%d\n", BACK(&q));
    }
    return 0;
}