#include<stdio.h>
//�ϳ��� ž ����ռ�
void hanoi(int n, int a, int b) {
	int c = 6 - a - b;
	if (n <= 1) {
		printf("%d %d\n",a,b);
		return;
	}
	else if (2 <= n && n <= 20) {
		hanoi(n-1,a,c);
		printf("%d %d\n",a,b);
		hanoi(n-1,c,b);
	}
	else {
		printf("�߸��� �Է� �� �Դϴ�.");
	}
}
//n�� num���� ���� �� ���� �Լ�
int power(int n, int num) {
	if (num == 0) {
		return 1;
	}
	else{
		return n*power(n,num-1);
	}
}

int main() {
	int N;
	scanf("%d", &N);
	int count = power(2, N);
	/*for (int i = 0; i < N; i++) {
		count *= 2;
	}*/
	
	printf("%d\n", count -1);
	hanoi(N, 1, 3);
	return 0;
}