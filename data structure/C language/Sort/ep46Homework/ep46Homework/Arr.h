#pragma once

typedef struct arrTs {
	//1. data가 저장 되어 있는 주소
	int* pInt;
	//2. 들어간 data 개수
	int iCount;
	//3. 들어갈 수 있는 maxsize
	int iMaxsize;
}tArr;
// 
void initArr(tArr* _pArr);
void pushBack(tArr* _pArr, int _iData);
void BubbleSort(tArr* _pArr);
void ReleaseArr(tArr* _pArr);
