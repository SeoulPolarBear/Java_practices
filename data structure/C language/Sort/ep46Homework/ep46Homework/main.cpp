#include "Arr.h"
#include<iostream>
#include<time.h>

int main() {
	tArr s1 = {};
	initArr(&s1);

	//����(����)
	srand(time(nullptr));
	

	//1~100�� ���� �ϰ� �ο�
	for (int i = 0; i < 10; ++i) {
		int iRand = rand()%100 + 1;
		pushBack(&s1, iRand);
	}
	BubbleSort(&s1);
	for (int i = 0; i < 10; ++i) {
	printf("%d\n", s1.pInt[i]);
	}
	ReleaseArr(&s1);
	return 0;
}