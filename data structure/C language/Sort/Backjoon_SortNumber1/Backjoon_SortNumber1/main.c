#include <stdio.h>



typedef int element;

//void swap(element* a, element* b) {
//	element temp = *a;
//	*a = *b;
//	*b = temp;
//}
void Insert_sort(element* A, int NUMBER) {//NUMBER�� �迭 A ������ ����
	int j, i;// �̷��� ���� ���� ������ j �κп��� ������ A[j + 1] = key; �̺κ��� ����� �۵� ���� �ʴ´�.
	element key;
	for (i = 0; i < NUMBER; i++) {
		key = A[i];//�� ����� �Ǵ� �ε���
		for (j = i-1 ; 0 <= j&& A[j]>key; j--) {
			A[j + 1] = A[j];//���� key ���� A[j] ���� ū ��찡 �߻��ϸ� �� �κ� ���� ũ�Ƿ� ������ ������.
			//if (j == 0) continue;
			//if (A[j] < A[j - 1]) swap(&A[j], &A[j - 1]);//�̰� ���� ����
		}
		A[j + 1] = key;// j�� ��ĭ �������Ƿ�(j-- ������) ���� j+1�κ��� key���� �� �κ��̴�.
	}
}