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
	while (left <= right);//윗 부분을 하면 left와 right는 한칸 차이가 날 수 밖에 없다
	//왜냐하면 왼쪽, 오른쪽은 pivot을 벗어 날 수 없는데 left와 right는 한칸씩만 증가하므로 left가 right를 추월했을 때는 left = right+ 1인경우 밖에 존재하지 않으므로(즉, 한칸차이로 추월 할 수 밖에 없다, 한칸씩만 움직임으로
	//그리고 left와 right는 움직이는 숫자가 아닌 그냥 index 값일 뿐 움직이는 것은 A에 있는 배열 값들이다.
	//한칸 차이밖에 나지 않는다.

	if (L < right) {
		Quick_Sort(A, L, right);
	}
	if (left < R) {
		Quick_Sort(A, left, R);
	}
}

int Find(int* A,int min, int num, int max) {//num 있는지 확인하는 번호, MIN, MAX는 찾을 부분의 배열 A의 인덱스
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
	scanf("%d\n", &N);//전체 인덱스 값
	int ARR[MAX_SIZE];//전체 배열
	int arr[MAX_SIZE];//찾아보고 싶은 것의 배열
	push(ARR, N);//전체 배열에 값을 추가
	Quick_sort(ARR, 0, N - 1);// 전체 배열 정렬
	printf("\n");
	scanf("%d\n", &NUM);//찾아보고 싶은 수의 개수
	push(arr, NUM);//찾아보고 싶은 수의 배열에 값을 추가
	for(int i = 0; i< NUM; i++){ 
		prinf("%d\n", Find(ARR, 0, arr[i], N-1));
	}
	
}