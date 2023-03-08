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
	//1.�ٽ� �Ҵ��� �κ� ����� 2��� �ؼ�
	int* pNew = (int*)malloc(_pArr->iMaxsize* sizeof(int) * 2);
	//2.�迭�� �ִ� ���� ����
	for (int i = 0; i < _pArr->iCount; ++i) {
		pNew[i] = _pArr->pInt[i];
	}
	//3.������ �ִ� �迭 �ּ� ����
	free(_pArr->pInt);
	//4. ���Ҵ� ���� �κ����� �ּ� ����
	_pArr->pInt = pNew;
	//5. �ִ� ũ�� 2�� ����
	_pArr->iMaxsize *= 2;
}

void pushBack(tArr* _pArr, int _iData)
{
	//1. ���� �� �ִ� ������ ���� ���� ���
	// 	���Ҵ��� �� maxsize�� �ø��� �ִ´�.
	if (_pArr->iMaxsize <= _pArr->iCount) {
		Reallocate(_pArr);
	}
	//2. ���� �� �ִ� ������ �������� ���
	//		�׳� �ִ´�.
	_pArr->pInt[_pArr->iCount++] = _iData;
}

void BubbleSort(tArr* _pArr) {
	int temp, i, j;
	//�����Ͱ� 1�� ���ϸ� ������ �ʿ䰡 ����.
	if (_pArr->iCount <= 1) {
		return;
	}
	//�������� ����
	//1.�迭�� �������� ���� ��
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
	//2.���ų� ������ �״�� ����
	//3.ũ�� ������ ���� ��ȯ
	//4.�̸� �� index 0~iMaxsize���� ����

}

void ReleaseArr(tArr* _pArr)
{
	free(_pArr->pInt);
	_pArr->iCount = 0;
	_pArr->iMaxsize = 0;
}
