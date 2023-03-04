#include<stdio.h>

double power(double x, int n);
void indent(int t);
int tab = 0;

int main() {
	double x;
	int n;
	while (1) {
		printf("\n>> ");
		scanf_s("%lf %d", &x, &n);// x 값과 n 값 입력
		if (x == 0 && n == 0)
			break;//0 0 입력시 프로그램 종료
		printf("%lf ^ %d = %lf", x, n, power(x, n));//최종 결과 값 출력

	}


}
double power(double x, int n) {
	double result = 0;// 전역 변수 선언 및 초기화
	indent(tab);//들여쓰기
	printf("power(%lf, %d)\n", x, n);// power 값 출력
	++tab;
	if (n == 0)
	{
		return 1;

	}
	else if ((n % 2) == 0)
	{
		result = power(x * x, n / 2);// 짝수 일때 거듭 제곱 그래로 실행
	}
	else {
		result = x * power(x * x, (n - 1) / 2);//홀수 일때는 n-1하여 짝수로 만든 후 거듭 제곱 실행 
	}

	--tab;
	indent(tab);
	printf("power(%lf, %d) = %lf\n", x, n, result);// power 출력 완료후 결과 값 출력
	return result;
}
void indent(int t) {
	int i;
	for (i = 0; i < t; i++)
	{
		printf("	");// 들여쓰기 반복 
	}
}

