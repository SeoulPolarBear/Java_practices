#include <stdio.h>



typedef int element;

//void swap(element* a, element* b) {
//	element temp = *a;
//	*a = *b;
//	*b = temp;
//}
void Insert_sort(element* A, int NUMBER) {//NUMBER는 배열 A 내용의 개수
	int j, i;// 이렇게 꺼내 놓지 않으면 j 부분에서 끝나고 A[j + 1] = key; 이부분이 제대로 작동 하지 않는다.
	element key;
	for (i = 0; i < NUMBER; i++) {
		key = A[i];//비교 대상이 되는 인덱스
		for (j = i-1 ; 0 <= j&& A[j]>key; j--) {
			A[j + 1] = A[j];//만약 key 값이 A[j] 보다 큰 경우가 발생하면 앞 부분 보다 크므로 정렬을 끝낸다.
			//if (j == 0) continue;
			//if (A[j] < A[j - 1]) swap(&A[j], &A[j - 1]);//이건 버블 정렬
		}
		A[j + 1] = key;// j가 한칸 내려가므로(j-- 때문에) 따라서 j+1부분이 key값이 들어갈 부분이다.
	}
}