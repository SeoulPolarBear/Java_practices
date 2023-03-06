#include<stdio.h>
#include<math.h>

typedef struct {
	int x;
	int y;
}Point;

void input(Point* p);
int equals(Point p, Point s);
double distance(Point p, Point s);
int area(Point p, Point s);
void output(Point p);
Point move(Point* p, Point s);
int main() {
	while (1) {
		Point p1, p2, vec;
		printf(">> "); input(&p1);
		printf(">> "); input(&p2);
		if (equals(p1, p2)) {
			printf("두 점이 같습니다.");
			return 0;
		}
		printf("두 점의 거리: %.3f\n", distance(p1, p2));
		printf("두 점에 의한 네모의 면적: %d\n", area(p1, p2));

		printf("이동할 거리: ");
		input(&vec);
		printf("p1 이동: "); output(p1); printf(" -> ");
		move(&p1, vec); output(p1);

		printf("\np2 이동: "); output(p2); printf(" -> ");
		move(&p2, vec); output(p2);
		printf("\n");
	}
}

void input(Point* p) {// 좌표 입력 함수
	scanf("%d", &p->x);
	scanf("%d", &p->y);
}

int equals(Point p, Point s) {// 좌표 비교 함수
	if (p.x == s.x && p.y == s.y)
		return 1;// 좌표가 같으면 같으면 1 반환
	else
		return 0;//좌표가 다르면 0 반환
}

double distance(Point p, Point s) {//거리를 구하는 함수
	double D = sqrt((p.x - s.x) * (p.x - s.x) + (p.y - s.y) * (p.y - s.y));
	return D;
}

int area(Point p, Point s) {//두 좌표를 이용한 사각형 넓이 구하는 함수
	int square;
	if (p.x == s.x || p.y == s.y)// x좌표가 같거나 y좌표가 같으면 넓이 0 반환
		square = 0;
	else
		square = abs((p.x - s.x) * (p.y - s.y));
	return square;
	/* 넓이를 구할 수
	있으면 넓이(square) 반환*/
}

void output(Point p) { // 좌표 출력
	printf("(%d, %d)", p.x, p.y);
}
Point move(Point* p, Point s) {// 좌표의 값 이동 함수
	p->x = p->x + s.x;
	p->y = p->y + s.y;

	return *p; // 포인트(좌표)의 포인터가 가리키는 값 반환
}

