#include<stdio.h>
#include<stdlib.h>
#define INS 8

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

void ENQUEUE(Queue* Q, element Data) {
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
element DEQUEUE(Queue* Q) {
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



//DEQUEUE(Queue* Q)
//SIZE(Queue* Q)
//FRONT(Queue* Q)
//BACK(Queue* Q)


int main() {
    element num;//ins 명령어 num 정수 X, NUM 명령어 개수
    int NUM;
    char ins[6];
    Queue q;
    init_queue(&q);

    scanf("%d\n", &NUM);

    while (NUM--) {
        scanf("%s", ins);
        if (!strcmp(ins, "push")) {
            scanf("%d", &num);
            ENQUEUE(&q, num);
        }

        else if (!strcmp(ins, "pop")) printf("%d\n", DEQUEUE(&q));

        else if (!strcmp(ins, "size")) printf("%d\n", SIZE(&q));

        else if (!strcmp(ins, "empty")) printf("%d\n", EMPTY(&q));

        else if (!strcmp(ins, "front")) printf("%d\n", FRONT(&q));

        else if (!strcmp(ins, "back")) printf("%d\n", BACK(&q));
    }

    //for (int i = 0; i < NUM; i++) {
    //    scanf("%s\n", ins);
    //    if (ins[0] == "p" && ins[1] == "u" && ins[2] == "s" && ins[3] == "h") {
    //        num = atoi(ins[5]);
    //        ENQUEUE(&q, num);
    //        //printf("-1");
    //    }
    //    else if (ins[0] == "p" && ins[1] == "o" && ins[2] == "p") {
    //        //element deq = DEQUEUE(&q);
    //        //printf("%d", deq);
    //        printf("%d\n", DEQUEUE(&q));
    //    }
    //    else if (ins[0] == "s" && ins[1] == "i" && ins[2] == "z" && ins[3] == "e") {
    //        printf("%d\n", SIZE(&q));
    //    }
    //    else if (ins[0] == "e" && ins[1] == "m" && ins[2] == "p" && ins[3] == "t" && ins[4] == "y"){
    //        printf("%d\n", EMPTY(&q));
    //    }
    //    else if (ins[0] == "f" && ins[1] == "r" && ins[2] == "o" && ins[3] == "n" && ins[4] == "t") {
    //        printf("%d\n", FRONT(&q));
    //    }
    //    else if (ins[0] == "b" && ins[1] == "a" && ins[2] == "c" && ins[3] == "k") {
    //        printf("%d\n", BACK(&q));
    //    }
    //    else printf("잘못된 입력입니다.\n");
    //}
    return 0;
}