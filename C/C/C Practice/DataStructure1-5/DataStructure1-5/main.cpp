#include<stdio.h>

int main() {
	int T, A, B;
	int sum = 0;
	scanf("%d", &T);
	for (int i = 1; i <= T; i++)
	{
		scanf("%d %d", &A, &B);//A와 B 입력
		sum = A + B;// A와 B 합
		printf("Case #%d: %d\n", i, sum);// Case 별로 출력
	}

	return 0;
}