//#include "CArr.h"
//#include <assert.h>
////�� �Լ� Ȱ���� ���� s1.push_back;
//void CArr::push_back(int _Data)//this�� ���� ������ ����, this�� ������ �Ͱ�
////�������� ���� �κ��� ���鼭 ����غ���
//{
//	if (this->m_iMaxCount <= this->m_iCount) {
//		//���Ҵ�
//		resize(m_iMaxCount*2);// �迭�� �� ã�� ��쿡�� 2�踸 Ȯ��
//	}
//	//������ �߰�
//	m_pData[m_iCount++] = _Data;
//}
////�������� ���� Ȯ�尡��, 
////�̸� ���ؼ� ���� �̸� ũ�⸦ �����ؼ� push_back���� �Լ��� ������ �ҷ����� ���� ����(�ð����� ������) �ϱ� ���� ����Լ��̴�.
//void CArr::resize(/*���⵵ this ����*/int _iResizeCount)
//{
//	// ���� �ִ� ���뷮 ���� �� ���� ��ġ�� Ȯ���Ϸ��� ���
//	//�� _iDataCount�� 5, m_iMaxCount 10�� ��� ������ �ִ� data�� 7���� ���� ���
//	// 2���� data �ս��� �߻� �� �� �����Ƿ� ������ �߻��� �� �ִ�.
//	//�̷��� �Ǹ� ������ �ս��� �߻��ϹǷ� nullptr�� ���ؼ� ������ ���ٴ°� ������ش�.
//	if (this->m_iMaxCount >= _iResizeCount) {
//		assert(nullptr);
//	}
//
//	//1.��������
//	int* pNew = new int[_iResizeCount];//malloc(_iResizeCount)����ؼ� ���
//	//2. ���� ������ �ִ� �����͵��� ���� �Ҵ��� �������� �����Ų��.
//	for (int i = 0; i < m_iCount; ++i) {
//		pNew[i] = this->m_pData[i];//���⼭�� this ���� ����
//	}
//	//3. ���� ������ �޸� ����
//	delete[] m_pData;
//	//4. �迭�� ���� �Ҵ�� ������ ����Ű�� �Ѵ�.
//	m_pData = pNew;
//	//5. MaxCount ������ ����
//	this->m_iMaxCount = _iResizeCount;
//}
//
//int& CArr::operator[](int idx)
//{
//	return m_pData[idx];
//}
//
//CArr::CArr()//������ �Լ�
////Header ���Ͽ����� �Լ��� ���� �� �����Ƿ� Header���� ������ �Լ� ���⼭ cpp���� ����� ����Ѵ�.
////CArrŬ���� �ȿ� �ִ� CArr()�Լ���� ��Ȯ�� ��ø�  ����� �Ѵ�.
//:m_pData(nullptr)
//, m_iCount(0)
//, m_iMaxCount(2)
//{//�̴ϼȶ�����, �޸� �ʱ�ȭ �Ҷ��� ���������� ��� ������ �ʱ�ȭ ���ִ°� ����.
//	m_pData = new int[2];//malloc(sizeof(int)*2)�� ���� ���̴�.
//
//}
//CArr::~CArr()//�Ҹ��� �Լ�
//{
//	delete[] m_pData;//���� �ڷ�������(�迭)���� ���� �̷��� �����ش�.
//	//int* p =new int[10];�� ��쿡�� delete[] p;
//	//int* p = new int;�� ��쿡�� delete p;�� �����Ѵ�.
//}