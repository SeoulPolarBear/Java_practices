#include<stdio.h>

int main() {
	int T, A, B;
	int sum = 0;
	scanf("%d", &T);
	for (int i = 1; i <= T; i++)
	{
		scanf("%d %d", &A, &B);//A�� B �Է�
		sum = A + B;// A�� B ��
		printf("Case #%d: %d\n", i, sum);// Case ���� ���
	}

	return 0;
}