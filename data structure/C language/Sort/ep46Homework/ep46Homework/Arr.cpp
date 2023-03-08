#include<iostream>
#include <stdio.h>
#include "Arr.h"


void initArr(tArr* _pArr)
{
	_pArr->pInt = (int*)malloc(sizeof(int) * 2);
	_pArr->iCount = 0;
	_pArr->iMaxsize = 2;
}

void Reallocate(tArr* _pArr) {
	//1.다시 할당할 부분 만들기 2배로 해서
	int* pNew = (int*)malloc(_pArr->iMaxsize* sizeof(int) * 2);
	//2.배열에 있는 값들 복사
	for (int i = 0; i < _pArr->iCount; ++i) {
		pNew[i] = _pArr->pInt[i];
	}
	//3.기존에 있는 배열 주소 해제
	free(_pArr->pInt);
	//4. 재할당 받은 부분으로 주소 이전
	_pArr->pInt = pNew;
	//5. 최대 크기 2배 증가
	_pArr->iMaxsize *= 2;
}

void pushBack(tArr* _pArr, int _iData)
{
	//1. 넣을 수 있는 공간이 꽉차 있을 경우
	// 	재할당한 후 maxsize를 늘리고 넣는다.
	if (_pArr->iMaxsize <= _pArr->iCount) {
		Reallocate(_pArr);
	}
	//2. 넣을 수 있는 공간이 여유러울 경우
	//		그냥 넣는다.
	_pArr->pInt[_pArr->iCount++] = _iData;
}

void BubbleSort(tArr* _pArr) {
	int temp, i, j;
	//데이터가 1개 이하면 정렬할 필요가 없다.
	if (_pArr->iCount <= 1) {
		return;
	}
	//오름차순 정렬
	//1.배열의 오른쪽의 수와 비교
	int iLoop = _pArr->iCount - 1;
	for (i = iLoop; i > 0; --i) {
		for (j = 0; j < i; ++j) {
			if (_pArr->pInt[j] > _pArr->pInt[j + 1]) {
				temp = _pArr->pInt[j];
				_pArr->pInt[j] = _pArr->pInt[j+1];
				_pArr->pInt[j + 1] = temp;
			}
		}
	}
	//2.같거나 작으면 그대로 유지
	//3.크면 오른쪽 수와 교환
	//4.이를 맨 index 0~iMaxsize까지 실행

}

void ReleaseArr(tArr* _pArr)
{
	free(_pArr->pInt);
	_pArr->iCount = 0;
	_pArr->iMaxsize = 0;
}
