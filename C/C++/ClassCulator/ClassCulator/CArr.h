#pragma once
#include <assert.h>

template<typename T>
//Ŭ���� ���ø� �� ��� �Լ�(���� �κ�)�� ������ ������Ͽ� �־�� �Ѵ�.
//���� Ŭ���� ���ø��� cpp������ ���� �ʿ䰡 ����.
class CArr
{
private:
	T* m_pData;//m_pInt���� ���� ���� data�� ���������� �ؾ��ϱ� ������ �̰͸� T�� ����
	int  m_iCount;
	int  m_iMaxCount;

public:
	void push_back(const T& _Data);// ���� ���������� ���� �޾ƿ��� ���� ũ�⿡���� ��� ������ 
	//�����ϴµ� ��ȿ�� ���̱� ������ ���������� �������� �ּҸ� ���� �� �ִ� ��, ������ �޴� ���۷����� ����ϴ°� ����.(54.���۷��� �ΰ����� ����)
	//���������� ������ ȸ�� �ϸ� �� �Ǳ� ������ const
	void resize(int _iResizeCount);//���� �迭 ����
public:
	T& operator[](int idx);
public://header���� �̹Ƿ� �Լ��� �������� �ʴ´�. 
	CArr();
	~CArr();
};

template<typename T>
CArr<T>::CArr()//������ �Լ�
//Header ���Ͽ����� �Լ��� ���� �� �����Ƿ� Header���� ������ �Լ� ���⼭ cpp���� ����� ����Ѵ�.
//CArrŬ���� �ȿ� �ִ� CArr()�Լ���� ��Ȯ�� ��ø�  ����� �Ѵ�.
	:m_pData(nullptr)
	, m_iCount(0)
	, m_iMaxCount(2)
{
	//�̴ϼȶ�����, �޸� �ʱ�ȭ �Ҷ��� ���������� ��� ������ �ʱ�ȭ ���ִ°� ����.
	m_pData = new T[2];//malloc(sizeof(int)*2)�� ���� ���̴�.

}
template<typename T>
CArr<T>::~CArr()//�Ҹ��� �Լ�
{
	delete[] m_pData;//���� �ڷ�������(�迭)���� ���� �̷��� �����ش�.
	//int* p =new int[10];�� ��쿡�� delete[] p;
	//int* p = new int;�� ��쿡�� delete p;�� �����Ѵ�.
}
//�� �Լ� Ȱ���� ���� s1.push_back;
template<typename T>
void CArr<T>::push_back(const T& _Data)//this�� ���� ������ ����, this�� ������ �Ͱ�
//�������� ���� �κ��� ���鼭 ����غ���
{
	if (this->m_iMaxCount <= this->m_iCount) {
		//���Ҵ�
		resize(m_iMaxCount * 2);// �迭�� �� ã�� ��쿡�� 2�踸 Ȯ��
	}
	//������ �߰�
	m_pData[m_iCount++] = _Data;
}
//�������� ���� Ȯ�尡��, 
//�̸� ���ؼ� ���� �̸� ũ�⸦ �����ؼ� push_back���� �Լ��� ������ �ҷ����� ���� ����(�ð����� ������) �ϱ� ���� ����Լ��̴�.
template<typename T>
void CArr<T>::resize(/*���⵵ this ����*/int _iResizeCount)
{
	// ���� �ִ� ���뷮 ���� �� ���� ��ġ�� Ȯ���Ϸ��� ���
	//�� _iDataCount�� 5, m_iMaxCount 10�� ��� ������ �ִ� data�� 7���� ���� ���
	// 2���� data �ս��� �߻� �� �� �����Ƿ� ������ �߻��� �� �ִ�.
	//�̷��� �Ǹ� ������ �ս��� �߻��ϹǷ� nullptr�� ���ؼ� ������ ���ٴ°� ������ش�.
	if (this->m_iMaxCount >= _iResizeCount) {
		assert(nullptr);
	}

	//1.��������
	T* pNew = new int[_iResizeCount];//malloc(_iResizeCount)����ؼ� ���
	//2. ���� ������ �ִ� �����͵��� ���� �Ҵ��� �������� �����Ų��.
	for (int i = 0; i < m_iCount; ++i) {
		pNew[i] = this->m_pData[i];//���⼭�� this ���� ����
	}
	//3. ���� ������ �޸� ����
	delete[] m_pData;
	//4. �迭�� ���� �Ҵ�� ������ ����Ű�� �Ѵ�.
	m_pData = pNew;
	//5. MaxCount ������ ����
	this->m_iMaxCount = _iResizeCount;
}
template<typename T>
T& CArr<T>::operator[](int idx)
{
	return m_pData[idx];
}












//class CArr
//{
//private://�⺻������ �ƹ��͵� �Է����� ������ ��������� private�� �ν� �Ѵ�.
//	int* m_pInt;
//	int  m_iCount;
//	int  m_iMaxCount;
//
//public:
//	void push_back(int _Data);//tArr* _pArr�� ��ü�� ���� ���� ��, this
//	//�̹Ƿ� ������ ����� �ʿ䰡 ����.
//	void resize(int _iResizeCount);//public�̶� ���� Reallocate�� �޸� �������� 
//	//�ø� �� �ְ� ������ ���̴�.
//public:
//	int& operator[](int idx);//��, operator�� �ش� ��ü�� ��Ī�Ѵ�. carr[1]�� ���� �й�
//
//public://header���� �̹Ƿ� �Լ��� �������� �ʴ´�. 
//	CArr();
//	~CArr();
//};

