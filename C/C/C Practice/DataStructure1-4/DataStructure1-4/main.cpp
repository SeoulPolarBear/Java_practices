#include<stdio.h>

int main() {
	int n;
	int sum = 0;
	scanf("%d", &n);

	sum = (n + 1) * n / 2;//등차 함수 공식 이용

	printf("%d", sum);

	return 0;
}