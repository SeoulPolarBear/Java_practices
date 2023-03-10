#include "pizza.h"
// 오류 함수
void error(char* message)
{
	fprintf(stderr, "%s\n", message);//error 메시지
	exit(1);//그리고 강제 종료
}

// 공백 상태 검출 함수
void init_queue(QueueType* q)//초기화 시켜주는 함수
{
	q->front = q->rear = 0;/*선형큐에서는 -1로 하지만 원형 큐에서는 0부터 시작
							한칸 차이로 초기화를 시켜주기 위해*/
}

// 공백 상태 검출 함수
int is_empty(QueueType* q)
{
	return (q->front == q->rear);
}

// 포화 상태 검출 함수
int is_full(QueueType* q)//rear가 한칸 더 가면 front 이다.
{
	return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

// 삽입 함수
void enqueue(QueueType* q, element item)
{
	if (is_full(q))
		error("큐가 포화상태입니다");
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;//q->앞에 ++는 선증가 위처럼 %를 이용한게 원형큐이다.
}

// 삭제 함수
element dequeue(QueueType* q)
{
	if (is_empty(q))
		error("큐가 공백상태입니다");
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->data[q->front];/*방금 나간것을 가리킨다: 선증가,
	따라서 하나 증가시키고 그 다음 대입*/
}

// 삭제 함수
element peek(QueueType* q)
{
	if (is_empty(q))
		error("큐가 공백상태입니다");
	return q->data[(q->front + 1) % MAX_QUEUE_SIZE];/*나갈 값을 가리키므로
													앞으로 나갈 값인 front 다음 값을
													보여주기 위해서 1을 더한다.*/
}

// 원형큐 출력 함수
/*void print_queue(QueueType* q, int b_enq, element e)//deq면 true, enq이면 false
{//앞에 명령문이 들어간다. 그다음 그에 따라 print 실행
	printf("\t");
	for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
		if (i == (q->front + 1) % MAX_QUEUE_SIZE) printf("<");//front는 <
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
		if (i == q->rear) printf("-");//rear는 -
		else
			printf(" ");
	}
	printf("  %s[%d]\n", b_enq ? "꺼냄" : "추가", e);//b_enq는 true, false는 여기서 사용
}*/