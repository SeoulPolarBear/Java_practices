#pragma once

typedef struct arrTs {
	//1. data�� ���� �Ǿ� �ִ� �ּ�
	int* pInt;
	//2. �� data ����
	int iCount;
	//3. �� �� �ִ� maxsize
	int iMaxsize;
}tArr;
// 
void initArr(tArr* _pArr);
void pushBack(tArr* _pArr, int _iData);
void BubbleSort(tArr* _pArr);
void ReleaseArr(tArr* _pArr);
