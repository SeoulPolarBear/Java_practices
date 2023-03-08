#include "deque.h"
// ���� �Լ�
void error(char* message)
{
	fprintf(stderr, "%s\n", message);
	exit(1);
}

// �ʱ�ȭ 
void init_deque(DequeType* q)
{
	q->front = q->rear = 0;
}

// ���� ���� ���� �Լ�
int is_empty(DequeType* q)
{
	return (q->front == q->rear);
}

// ��ȭ ���� ���� �Լ�
int is_full(DequeType* q)
{
	return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

// ����ť ��� �Լ�
void print_queue(DequeType* q, int cmd, element e)
{
	printf("\t");
	for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
		if (i == (q->front + 1) % MAX_QUEUE_SIZE) printf("<");
		else printf(" ");
		if (i <= q->front && q->front < q->rear)
			printf("_");  //  i <<  --
		else if (q->front < i && i <= q->rear)
			printf("%d", q->data[i]);  // << i --
		else if (i <= q->rear && q->rear < q->front)
			printf("%d", q->data[i]);  //  i -- ___ <<
		else if (i > q->front && q->rear < q->front)
			printf("%d", q->data[i]);  //  -- ___ << i
		else
			printf("_");  //  i <<  --
		if (i == q->rear) printf("-");
		else
			printf(" ");
	}
	char* inout[] = { "�߰�", "����" };
	printf("  %s[%d]\n", inout[cmd / 3], e);
	//1,2��(1 or 2/3=0) �߰��̰� 3,4(3 or 4/3 = 1)�� �����°ɷ� �ٲ��.
}
//queue�� ���� �Լ���
// ���� �Լ�  : enq
void add_rear(DequeType* q, element item)
{
	if (is_full(q))
		error("ť�� ��ȭ�����Դϴ�");
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;
}

// ���� �Լ�   : deq
element delete_front(DequeType* q)
{
	if (is_empty(q))
		error("ť�� ��������Դϴ�");
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->data[q->front];
}

// ��ũ �Լ�  : peek
element get_front(DequeType* q)
{
	if (is_empty(q))
		error("ť�� ��������Դϴ�");
	return q->data[(q->front + 1) % MAX_QUEUE_SIZE];
}
//queue���� ���� �Լ���
// ������ �߰�
void add_front(DequeType* q, element val)
{
	if (is_full(q))
		error("ť�� ��ȭ�����Դϴ�");
	q->data[q->front] = val;  // ���� �ְ� ���� front ����
	q->front = (q->front - 1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
}
// �ڷ� ����
element delete_rear(DequeType* q)
{
	//int prev = q->rear;
	element val;
	if (is_empty(q))
		error("ť�� ��������Դϴ�");
	val = q->data[q->rear];   // ������ ���� rear ����
	q->rear = (q->rear - 1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
	return val;
}
// �ڸ� �̸�����
element get_rear(DequeType* q)
{
	if (is_empty(q))
		error("ť�� ��������Դϴ�");
	return q->data[q->rear];
}