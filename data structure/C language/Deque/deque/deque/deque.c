#include "deque.h"
// 오류 함수
void error(char* message)
{
	fprintf(stderr, "%s\n", message);
	exit(1);
}

// 초기화 
void init_deque(DequeType* q)
{
	q->front = q->rear = 0;
}

// 공백 상태 검출 함수
int is_empty(DequeType* q)
{
	return (q->front == q->rear);
}

// 포화 상태 검출 함수
int is_full(DequeType* q)
{
	return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

// 원형큐 출력 함수
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
	char* inout[] = { "추가", "꺼냄" };
	printf("  %s[%d]\n", inout[cmd / 3], e);
	//1,2면(1 or 2/3=0) 추가이고 3,4(3 or 4/3 = 1)면 꺼내는걸로 바꿨다.
}
//queue와 같은 함수들
// 삽입 함수  : enq
void add_rear(DequeType* q, element item)
{
	if (is_full(q))
		error("큐가 포화상태입니다");
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;
}

// 삭제 함수   : deq
element delete_front(DequeType* q)
{
	if (is_empty(q))
		error("큐가 공백상태입니다");
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->data[q->front];
}

// 피크 함수  : peek
element get_front(DequeType* q)
{
	if (is_empty(q))
		error("큐가 공백상태입니다");
	return q->data[(q->front + 1) % MAX_QUEUE_SIZE];
}
//queue에는 없던 함수들
// 앞으로 추가
void add_front(DequeType* q, element val)
{
	if (is_full(q))
		error("큐가 포화상태입니다");
	q->data[q->front] = val;  // 값을 넣고 나서 front 증가
	q->front = (q->front - 1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
}
// 뒤로 삭제
element delete_rear(DequeType* q)
{
	//int prev = q->rear;
	element val;
	if (is_empty(q))
		error("큐가 공백상태입니다");
	val = q->data[q->rear];   // 꺼내고 나서 rear 감소
	q->rear = (q->rear - 1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
	return val;
}
// 뒤를 미리보기
element get_rear(DequeType* q)
{
	if (is_empty(q))
		error("큐가 공백상태입니다");
	return q->data[q->rear];
}