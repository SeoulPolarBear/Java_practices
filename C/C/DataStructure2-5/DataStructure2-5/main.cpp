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
			printf("�� ���� �����ϴ�.");
			return 0;
		}
		printf("�� ���� �Ÿ�: %.3f\n", distance(p1, p2));
		printf("�� ���� ���� �׸��� ����: %d\n", area(p1, p2));

		printf("�̵��� �Ÿ�: ");
		input(&vec);
		printf("p1 �̵�: "); output(p1); printf(" -> ");
		move(&p1, vec); output(p1);

		printf("\np2 �̵�: "); output(p2); printf(" -> ");
		move(&p2, vec); output(p2);
		printf("\n");
	}
}

void input(Point* p) {// ��ǥ �Է� �Լ�
	scanf("%d", &p->x);
	scanf("%d", &p->y);
}

int equals(Point p, Point s) {// ��ǥ �� �Լ�
	if (p.x == s.x && p.y == s.y)
		return 1;// ��ǥ�� ������ ������ 1 ��ȯ
	else
		return 0;//��ǥ�� �ٸ��� 0 ��ȯ
}

double distance(Point p, Point s) {//�Ÿ��� ���ϴ� �Լ�
	double D = sqrt((p.x - s.x) * (p.x - s.x) + (p.y - s.y) * (p.y - s.y));
	return D;
}

int area(Point p, Point s) {//�� ��ǥ�� �̿��� �簢�� ���� ���ϴ� �Լ�
	int square;
	if (p.x == s.x || p.y == s.y)// x��ǥ�� ���ų� y��ǥ�� ������ ���� 0 ��ȯ
		square = 0;
	else
		square = abs((p.x - s.x) * (p.y - s.y));
	return square;
	/* ���̸� ���� ��
	������ ����(square) ��ȯ*/
}

void output(Point p) { // ��ǥ ���
	printf("(%d, %d)", p.x, p.y);
}
Point move(Point* p, Point s) {// ��ǥ�� �� �̵� �Լ�
	p->x = p->x + s.x;
	p->y = p->y + s.y;

	return *p; // ����Ʈ(��ǥ)�� �����Ͱ� ����Ű�� �� ��ȯ
}

