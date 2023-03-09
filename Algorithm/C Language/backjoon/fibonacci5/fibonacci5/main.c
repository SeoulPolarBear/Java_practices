#include<stdio.h>

int Fn(int n) {
	if (n == 0) {
		return 0;
	}
	else if (n == 1) {
		return 1;
	}
	else if (2 <= n && n <= 20) {
		return Fn(n - 1) + Fn(n - 2);
	}
	else {
		return 0;
	}
}

int main() {
	int n;
	scanf("%d",&n);
	printf("%d", Fn(n));
}