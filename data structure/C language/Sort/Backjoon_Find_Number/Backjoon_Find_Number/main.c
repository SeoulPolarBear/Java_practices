#include<stdio.h>
#define MAX_SIZE 1000
//typedef struct Arr {
//	int data;
//	struct Arr* next;
//}Arr;

void push(int* A, int N) {
	int k;
	for (int i = 0; i < N; i++) {
		scanf("%d", &k);
		A[i] = k;
	}
		
}
void Quick_Sort(int* A, int L, int R) {
	int left = L, right = R;
	int pivot = A[(L + R) / 2];
	int temp;
	do {
		while (A[left] < pivot)
			left++;
		while (A[right] > pivot)
			right--;

		if (left <= right) {
			temp = A[left];
			A[left] = A[right];
			A[right] = temp;
			left++; right--;
		}
	}
	while (left <= right);//�� �κ��� �ϸ� left�� right�� ��ĭ ���̰� �� �� �ۿ� ����
	//�ֳ��ϸ� ����, �������� pivot�� ���� �� �� ���µ� left�� right�� ��ĭ���� �����ϹǷ� left�� right�� �߿����� ���� left = right+ 1�ΰ�� �ۿ� �������� �����Ƿ�(��, ��ĭ���̷� �߿� �� �� �ۿ� ����, ��ĭ���� ����������
	//�׸��� left�� right�� �����̴� ���ڰ� �ƴ� �׳� index ���� �� �����̴� ���� A�� �ִ� �迭 �����̴�.
	//��ĭ ���̹ۿ� ���� �ʴ´�.

	if (L < right) {
		Quick_Sort(A, L, right);
	}
	if (left < R) {
		Quick_Sort(A, left, R);
	}
}

int Find(int* A,int min, int num, int max) {//num �ִ��� Ȯ���ϴ� ��ȣ, MIN, MAX�� ã�� �κ��� �迭 A�� �ε���
	int pivot = (min + max) / 2;
	if (num == A[pivot]) return 1;
	if (min == num) return 1;
	if (max == num) return 1;
	if (min == max) return 0;
	if (num < A[pivot]) Find(A, min, num, pivot - 1);
	else if (num > A[pivot]) Find(A, pivot + 1, num, max);
	//else if ()
}

int main() {
	int N, NUM;
	scanf("%d\n", &N);//��ü �ε��� ��
	int ARR[MAX_SIZE];//��ü �迭
	int arr[MAX_SIZE];//ã�ƺ��� ���� ���� �迭
	push(ARR, N);//��ü �迭�� ���� �߰�
	Quick_sort(ARR, 0, N - 1);// ��ü �迭 ����
	printf("\n");
	scanf("%d\n", &NUM);//ã�ƺ��� ���� ���� ����
	push(arr, NUM);//ã�ƺ��� ���� ���� �迭�� ���� �߰�
	for(int i = 0; i< NUM; i++){ 
		prinf("%d\n", Find(ARR, 0, arr[i], N-1));
	}
	
}