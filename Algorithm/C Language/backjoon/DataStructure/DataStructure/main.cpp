#include<stdio.h>

double power(double x, int n);
void indent(int t);
int tab = 0;

int main() {
	double x;
	int n;
	while (1) {
		printf("\n>> ");
		scanf_s("%lf %d", &x, &n);// x ���� n �� �Է�
		if (x == 0 && n == 0)
			break;//0 0 �Է½� ���α׷� ����
		printf("%lf ^ %d = %lf", x, n, power(x, n));//���� ��� �� ���

	}


}
double power(double x, int n) {
	double result = 0;// ���� ���� ���� �� �ʱ�ȭ
	indent(tab);//�鿩����
	printf("power(%lf, %d)\n", x, n);// power �� ���
	++tab;
	if (n == 0)
	{
		return 1;

	}
	else if ((n % 2) == 0)
	{
		result = power(x * x, n / 2);// ¦�� �϶� �ŵ� ���� �׷��� ����
	}
	else {
		result = x * power(x * x, (n - 1) / 2);//Ȧ�� �϶��� n-1�Ͽ� ¦���� ���� �� �ŵ� ���� ���� 
	}

	--tab;
	indent(tab);
	printf("power(%lf, %d) = %lf\n", x, n, result);// power ��� �Ϸ��� ��� �� ���
	return result;
}
void indent(int t) {
	int i;
	for (i = 0; i < t; i++)
	{
		printf("	");// �鿩���� �ݺ� 
	}
}

