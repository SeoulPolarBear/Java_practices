#include<stdio.h>

int fibonacci(int N) {
	if (N == 0) {
		return 1;
	}
	else if (1 <= N && N <= 12) {
		return N*fibonacci(N-1);
	}
	else {
		printf("잘못 입력하셨습니다.");
		return 0;
	}
}
	int main(){
		int k;
		scanf("%d", &k);
		int n=fibonacci(k);
		printf("%d", n);
		return 0;
	}