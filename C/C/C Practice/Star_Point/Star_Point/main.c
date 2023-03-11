#include<stdio.h>

void Check_star(int n, int i, int j) {

	if ((i / n) % 3 == 1 && (j / n) % 3 == 1) {
		printf(" ");
	}
	else {
		if (n / 3 == 0) printf("*");
		else Check_star(n / 3, i, j);
	}
}

	void Point(int n){
		int m = n;
		if (3 <= n && n < 6561) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Check_star(n, i, j);
				}
				printf("\n");
			}
		}
		else { printf("값을 초과해서 입력하셨습니다."); }
	}

	int main() {
		int k;
		scanf("%d", &k);
		if (k % 3 == 0) {
			Point(k);
		}
		else { printf("잘못된 입력입니다."); }

		return 0;
	}