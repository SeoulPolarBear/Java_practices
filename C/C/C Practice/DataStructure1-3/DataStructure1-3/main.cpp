#include<stdio.h>
int main() {
	int N;
	int M;//N-i�� ��
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		M = N - i;
		printf("%d\n", M);
	}
	return(0);
}
