#include<iostream>
#include"CArr.h"
#include "CList.h"
#include<vector>
#include<list>


namespace MYSPACE {
	int g_int;//���������� �ȴ�. �Լ� �ȿ� ���� �Ѱ��� �ƴϹǷ�
}
namespace OTHERSPACE {
	int g_int;
}

void MyEndL()//endl�� �Լ�
{
	wprintf(L"\n");
}

//using namespace std;//�̷��� �����ϸ� namespace�� MYSPACE::�� �κ��� �� �ʿ䰡 ��������.
//������ �̷��� �Ǹ� namespace�� ���������� ����� ������. �ߺ��� ������ ���ϹǷ�

using std::cout;//������ ���� Ư�� ��ɸ� std::cout �̷��� �� �ʿ� ���� cout�� �ٷ� �� �� �ְ� ���ش�.
using std::endl;//�� ��ø���� ���� ������ ����ϸ� �����ϴ�.
using std::vector;
using std::list;

class CTest {
public:
	int m_i;

public://�ڵ����� ����� ���� ��
	CTest& operator =(const CTest& _other)
	{
		m_i = _other.m_i;
		return *this;
	}
public:
	CTest()
		:m_i(0)
	{

	}


	//�ڵ����� ����� ���� ��, �ٵ� ���� ������� ������ �����ε�
	//=> �׷��� �Ǹ� �����Ϸ��� �ڵ����� �⺻ �����ڸ� ��������� �ʴ´�.
	//���迡 ���� ������ ����!~!!!!!!!!!!!!!!!
	CTest(const CTest& _other)
		:m_i(_other.m_i)
	{

	}
	//��ü ���� ȣ�� ����
	static void MemberFunc() {

	}
};

class CMyOStream {
public:
	CMyOStream& operator << (int _data) //extern ostream cout; �� �ܺ� cout�� ��ü�̴�. 
	{// cout << "�ȳ�" << (10 << endl �̺κ��� this������ ������ ������ ���� ���) 
	//�̱� ������ ��ȯ Ÿ���� �ڱ� �ڽ����� �ؾ��Ѵ�.
		wprintf(L"%d", _data);

		return *this;
	}

	CMyOStream& operator << (const wchar_t* _pString) {
		wprintf(L"%s", _pString);
		return *this;
	}

	CMyOStream& operator >> (int& _idata) {//�����ǿ��� �ϹǷ� �ּ� ���� �� const x
		scanf_s("%d", &_idata);// �� ����� �����δ� istream�� Ŭ������ ����� ���ִ�.
		return *this;
	}

	CMyOStream& operator << (void (*_pFunc)(void)) //endl�� ����
	{
		_pFunc();
		return *this;
	}

};
CMyOStream mycout;



template<typename T>//�������� ���� �� ����Ѵ�. T�� ġȯ���̶� ���̴�.
T Add(T a, T b) {
	return a + b;
}


int main() {
	//����ü-->Ŭ����

	/*��ü���� ��� Ư¡
		1.ĸ��ȭ
		����� �����ϱ� ���� �ʿ��� ��� ����, ����, ���м�
		��� �Լ���

		2.���

		3. ������

		4. �߻�ȭ
		����ü ���� �����迭 -->Ŭ���� ����
		c++ �����Ҵ� new, delete*/

		/* c������ ����
		tArr arr = {};
		InitArr(&arr);

		PushBack(&arr, 10);
		PushBack(&arr, 10);
		PushBack(&arr, 10);PushBack(&arr, 10);
		ReleaseArr(&arr);*/

		//C++���� ����
	CArr<int> carr;
	//���⼭ �ٷ� CArr<float> carr; �ϸ� float���� data ����
	carr.push_back(10);
	carr.push_back(20);
	carr.push_back(30);
	/*carr.push_back(3.14f);
	carr.push_back(6.28f);
	carr.push_back(30.444f);
	float fData = carr[1];
	*/
	//release �κ��� �Ҹ��ڿ��� �����Ű�Ƿ� ���� �ʿ䰡 ����.

	carr[1] = 40;//�̰� �ǰ� �ϰ� �;���.
		//54. ���۷��� �ΰ����� �׸� ����
		//�ᱹ ���۷����� ����Ű�� ���� �� ���� ������ �ִ� �������̶� ��ġ�ϹǷ�
		// �̷��� ���ȴ�.
	//int p = carr[1];
	// int CArr::operator[](int idx)
	/*{
		return m_pInt[idx];
	}*/
	//*carr[1] = 100;//���� �̰� �Ƿ��� ����Լ���
	/*int* CArr::operator[](int idx)
	{
		return &m_pInt[idx] or m_pint+idx;
	}
	�ֳ��ϸ� ���� carr[1]�� ���ϰ��� �ᱹ int���̱� ������ ������Ʈ�� �ӽ÷�
	����Ǿ� �ִ� ���̱� ������ ������ �Ұ��� �ϴ�
	���� ������ �����ϰ� �ϱ����ؼ��� �ּҸ� �����;��ϱ⶧���� ������ �߻��Ѵ�.
	*/

	int i = Add<int>(10, 20);//�̷��� �ϸ� int ������ ���ø��� �����.
	//��, �������� ���� �Լ��̴�.
	int s = Add(10, 20);//1. �̷� ��쿡�� ���ø��� int�� �ν��� �ؼ�
	//(�޴� ������ int�� parameter ���� int Ÿ���̹Ƿ�) �ڵ����� �Լ��� ����Ѵ�.
	//2. ���� Add�Լ��� ������ ������ �Լ��� ���ٰ� �����ϸ� �ȴ�.
	//3. �׸��� Add �� Add<int>�ʹ� �ٸ� ���̴�. �ֳ��ϸ� �Լ� ���ø��� �Լ��� �ٸ��⶧��







///* c������ ����
//tArr arr = {};
//InitArr(&arr);

//PushBack(&arr, 10);
//PushBack(&arr, 10);
//PushBack(&arr, 10);PushBack(&arr, 10);
//ReleaseArr(&arr);*/
//
////C++���� ����
//CArr carr;
//carr.push_back(10);
//carr.push_back(20);
//carr.push_back(30);
////release �κ��� �Ҹ��ڿ��� �����Ű�Ƿ� ���� �ʿ䰡 ����.

//carr[1] = 40;//�̰� �ǰ� �ϰ� �;���.
//	//54. ���۷��� �ΰ����� �׸� ����
//	//�ᱹ ���۷����� ����Ű�� ���� �� ���� ������ �ִ� �������̶� ��ġ�ϹǷ�
//	// �̷��� ���ȴ�.
////int p = carr[1];
//// int CArr::operator[](int idx)
///*{
//	return m_pInt[idx];
//}*/
////*carr[1] = 100;//���� �̰� �Ƿ��� ����Լ���
///*int* CArr::operator[](int idx)
//{
//	return &m_pInt[idx] or m_pint+idx;
//}
//�ֳ��ϸ� ���� carr[1]�� ���ϰ��� �ᱹ int���̱� ������ ������Ʈ�� �ӽ÷�
//����Ǿ� �ִ� ���̱� ������ ������ �Ұ��� �ϴ�
//���� ������ �����ϰ� �ϱ����ؼ��� �ּҸ� �����;��ϱ⶧���� ������ �߻��Ѵ�.
//*/

//int i = Add<int>(10, 20);//�̷��� �ϸ� int ������ ���ø��� �����.
////��, �������� ���� �Լ��̴�.
//int s = Add(10, 20);//1. �̷� ��쿡�� ���ø��� int�� �ν��� �ؼ�
////(�޴� ������ int�� parameter ���� int Ÿ���̹Ƿ�) �ڵ����� �Լ��� ����Ѵ�.
////2. ���� Add�Լ��� ������ ������ �Լ��� ���ٰ� �����ϸ� �ȴ�.
////3. �׸��� Add �� Add<int>�ʹ� �ٸ� ���̴�. �ֳ��ϸ� �Լ� ���ø��� �Լ��� �ٸ��⶧��
//

	CList<int> list1;

	for (int i = 0; i < 4; ++i) {
		list1.push_back(i);
	}
	//printf("adwgasdg %d 10", 10)//""�ȿ� �ִ� ���� ���� , %d�� ���Ѱ� ���� 10

		//c printf
		//cout << "�ȳ�" << 10 << endl;//������ �����ε�
		//std::wcout << L"�ȳ�" << 10 << endl;//2byte ���ڿ�
		////c scanf
		//int input = 0;

	setlocale(LC_ALL, "korean");//�ѱ��� ��� ����
	_wsetlocale(LC_ALL, L"korean");//���� ����

	mycout << 10 << 20 << 30;// ��µǸ� 10, 20 ,30 �̷��� ���´�.
	mycout << L"�ȳ�";



	//std::cin >> input;//std�� namespace�� ������ �Ȱ���.
	//std�ȿ� cout�� cin�̶�� ������ ���� �ȿ� ����ֱ� ������ ���
	//�� �׷� std�ȿ� C++���� �����ϴ� ��ɵ��� ����ֳ� �ϸ�
	//�̷��� namespace�ȿ� ������ ���� ���� cout��� ������ �����ؼ� ���� ������
	//�ߺ� ���� �ʰ� �Ϸ��� namespace�ȿ� �ִ� ���̴�.
	//��, namespace(�̸�����)�� �ٸ��� ���� �̸��� ������ ������ ������ �ʴ´�.
	int a = 0;
	mycout >> a;


	//���պ�
	int k = 0;

	mycout >> k << 100 << L" " << 20 << L" " << L"���ڿ�" << MyEndL;


	MYSPACE::g_int = 0;//namespace�ȿ� �ֱ� ������ MYSPACE:: ���
	OTHERSPACE::g_int = 0;//namespace�� �ٸ��� ������ �����̸� �� ���Ƶ� ���� x
	CTest::MemberFunc();//static�����Լ��̹Ƿ� ��ü ���� ȣ�� ����

	vector<int> vecInt;
	vecInt.push_back(10);
	vecInt.push_back(20);//push_front�� �������� �ʴ´�.
	vecInt.data();//���Ͱ��� ������ ��ҵ��� �����ϴ� �� ���������� ����ϴ� �޸� �迭(���� �迭)�� ���� ���� ������(direct pointer)�� ��ȯ�մϴ�. 
	vecInt.size();//��� �ִ� �Լ� ����
	vecInt.capacity();//������ �� ���� �� �ִ� ��� �뷮

	for (size_t i = 0; i < vecInt.size(); ++i)//size_t�� ������ vector�� ��ȯ Ÿ���� size_t�̱� �����̴�.
		//size_t�� __int64 �� ������ unsigned long long�� ����.
	{
		cout << vecInt[i] << endl;
	}


	vecInt[0] = 100;
	vecInt.at(1);
	vecInt[1];//���� ���� ���̴�.

	list<int> listInt;
	listInt.push_back(10);
	listInt.push_front(100);
	listInt.size();//capacity�� �ʿ䰡 ����.

	//����Ʈ���� ���� �ε����� �̿��� �����ϴ� ����� ���� literator ���

	// iterator(inner class)Ŭ���� �ȿ� ������ Ŭ���� list�� Ŭ����
	//iterator�� Ŭ����
	//iterator�� ����� Ŭ���� �̹Ƿ� � �ڷᱸ���� �ᵵ �ݺ��ڴ� �����Ѵٴ� �� �� �� �ִ�.
	//��, ���ε����� �ٸ����� �������̽����� ���� ����� ���ٴ� �������� �����Ѵ�. ��, ���� ��� ���� ����
	vector<int>::iterator veciter = vecInt.begin();

	for (int i = 0; i < 10; ++i) {
		vecInt.push_back(i);
	}
	//�̷���� �����迭�� ���Ҵ� �ޱ� ������ vecInt.begin();�� ����Ű�� �ּҴ� ���� ����Ű�� �ִ� �ּҸ� ����Ű�� �ȴ�


	*veciter = 100;//vector ���� ó�� �ּ��� ���� ������
	++veciter;//���� �迭 ���� ����Ų��.

	vecInt.erase(veciter);//iterator�� ����Ű�� �κ��� ������ �ּ����� ��




	list<int>::iterator iter = listInt.begin();//�ݺ���(iterator) 
	//�ش� �ڷᱸ���ȿ� �ִ� data�� ����Ű�� ��ħ�ϴ� ����� �Ѵ�.
	//iterator ��ü ���� �׸��� �� ��ü�� ����Ʈ�� ó�� �����ϴ� ��带 �����Ѷ� ��� ���̴�.
	int iData = *iter;//��ġ pointer���� ����� �ַ��� ����� �����̴�.
	//������ �����δ�*iter�ϸ� ó�� ��� ���� ��(data, ���� �ּҰ�)�߿��� data ����
	//�����ͼ� �����ִ� ����� �Ѵ�.
	++iter;//���� ��带 ����Ų��.

	for (iter = listInt.begin(); iter != listInt.end(); ++iter) {
		//end()�� ������ ���� data�� ��Ī�ϴ� iterator�̴�. �ֳ��ϸ� ����� �׷��� �Ʊ� ������ (���Ǽ��� ���ؼ�)
		//end iterator��� �Ѵ�.
		cout << *iter << endl;
	}
	//vector<float>::iterator;//3�� ���δ� �ٸ� Ŭ���� �̴�.
	//vector<short>::iterator;
	//vector<int>::iterator;

	CArr<int> myvector;
	myvector.push_back(1);
	myvector.push_back(2);
	myvector.push_back(3);

	CArr<int>::iterator myiter = myvector.begin();

	//*myiter;
	//++(����, ����),--,==,!=
	//

	for (; myiter != (myvector.end()); ++myiter) {
		cout << *myiter << endl;
	}


	int iData = *(++myiter);
	int iData = *(myiter++);//���� �����ڰ� ���� �ߵ������� ī�Ǻ��� �༭ ���������ڸ� �ϼ� ���״�.
	//���� for (; myiter != (myvector.end()); ++myiter) �̷� �κп���
	//������ ���� ������ ������ ���� ���� ���� ��ü ���� ���� ����� �߻��ϹǷ� ī�Ǻ��� ��������.
	//���� ���� �����ڸ� ���� �� ����.

	//CTest t1, t2;//�̷��� �ڵ��� �ϸ� �⺻�����ڸ� �޾ƿ��µ�
	//���� �����ε��� �߱� ������ �⺻ �����ڰ� ��� ������ �߻� �ϴ� ���̴�.
	//���� �⺻ �����ڵ� ������ �Ѵ�.

	CTest t1;
	t1.m_i = 100;
	/*��������� Ȱ��
	t2 = t1; ������ ���� ����� ���� ���ٷ� ������.*/

	CTest t2(t1);//���� ������ ȣ��

	CTest t3 = t1;// t3�� ������ �Ŀ� t1�� �����ϴ� �� ��, ���縦 �ϰڴٴ� ���̴�.
	//��, �� ���� ���� ���� �����ڸ� ȣ���Ѵٴ� �Ŷ�� �˰� �־�� �Ѵ�.
	//�����Ϸ��� CTest t3(t1);���� ��ȯ�ؼ� ó���Ѵ�.



	//vector::erase
	//vector<int> vecInt;

	vecInt.push_back(100);
	vecInt.push_back(200);
	vecInt.push_back(300);
	vecInt.push_back(400);

	vector<int> vecInt2;
	vecInt2.push_back(1000);

	vector<int>::iterator veciter = vecInt.begin();//������ 100�� ��� �ִ¹迭�� ����Ű�� �ִ�.
	//vecInt.erase(veciter);//100�� ����ִ� iterator�� �����ϰ� ������ ����(200)�� ���� ���� ��ȯ ���ش�.
	//���� ��ȯŸ���� ���� iterator�̹Ƿ� veciter������ �ٽ� �־���� ������ �� �ִ�.

	//int i = *veciter;//�̷��� �Ǹ� 100d�� ����Ű�� �ִ� �����̹Ƿ�(begin������) �����Ͽ����� �߻��Ѵ�.

	//���� 
	veciter = vecInt.erase(veciter);//�̷��� �޾�����Ѵ�.

	//��, erase(veciter)���� veciter�� ��ȿ���� false���ǰ� 
	//veciter = vecInt.erase(veciter); �� ��� return iterator(this, m_pData, _iter.m_iIdx); 
	//��, �����ڸ� �̿��ϱ⶧���� �����ڿ����� ��ȿ���� true�� ���°� �ȴ�.�⺻ ������ �ƴ�
	//���� erase�� ���ؼ� ������ �ִ� �� ������ ���� �����ڸ� return�ؼ� ��ȿ���� true�� �ٲ۴�.

	//���� ������ ���� iterator�� vecInt2�� ����Ű�µ� 
	//erase�� ������ ���� vecInt���� ����ϴ� ��찡 �߻��� �� �ִ�.
	//vector<int>::iterator veciter = vecInt2.begin();
	//veciter= vecInt.erase(veciter);

	vecInt.clear();//vector�� �ִ� ��� data�� �����Ѵ�.

	//1~10�� ���Ϳ� �Է�
	for (int i = 0; i < 11; ++i) {
		vecInt.push_back(i + 1);
	}

	//¦���� ����
	veciter = vecInt.begin();
	for (; veciter != vecInt.end(); ++veciter) {//i < 10�϶� erase�� ������ �� ������ vecInt
		//erase�� �� �Ŀ� ������ ����Ű�µ� 10�� erase�ϸ� veciter�� end()�� ����Ű�Եǰ� �׷��� �ǰ�
		//for���� ����Ǽ� ++veciter�� �Ǽ� end()�� ���� �޸𸮸� ����Ű�� ������ ������ �߻��Ѵ�.
		if (*veciter % 2 == 0) {
			//¦���� ���� ������ Ȧ���� �˻����� �ʾҴ�. ��? erase�� ���� ����� ���� ���� ����Ű�� �����̴�.
			veciter = vecInt.erase(veciter);
		}
	}

	for (; veciter != vecInt.end();) {//���⼭ ���� ++veciter;�� for�� �������� ������
		//1~5���̿��� erase�� �Ͼ�� ���� ������ ����Ű�� �״������� ���� �ǹǷ�
		//1���� 2����Ű�� �ٷ� 3�����Ѽ� for ���� �� 3���� 4����Ű�� �ٷ� 5�Ѿ�� for����
		//�̷��� �Ǳ⶧���� 2�� 4�� ���Ű� ���� �ʰ� �Ѿ�Եȴ�.
		//���� ������ ���� ���� ���� ������ ��Ű�� ������ �ݺ������� ���ظ� �� �� �ִ�.
		//�ɽ�ġ �ʰ� �������� ���´�
		if (1 <= *veciter && *veciter <= 5) {
			//����
			veciter = vecInt.erase(veciter);
		}
		else
		{
			++veciter;
		}
	}

	for (int i = 0; i < vecInt.size(); ++i) {
		cout << vecInt[i] << endl;
	}

	list<int> intlist;
	intlist.push_back(100);
	intlist.push_back(300);
	intlist.push_back(400);

	list<int>::iterator it = intlist.begin();
	it = intlist.insert(++it, 200);
	//insert��ȯ���� iterator�� �ְ� ���� �� ��, 200�� ������ �ִ� ��带 ����Ų��.
	//insert(++(�ְ� �����κ��� ���� �� ��, 100�� �ִ°�), �ְ� ���� ��)



	//====================================
	//			list iterator
	//====================================

	CList<int> mylist;

	mylist.push_back(100);
	mylist.push_back(200);
	mylist.push_back(300);

	CList<int>::iterator listiter = mylist.begin();
	int l = *listiter;
	*listiter = 150;

	//++,--, ==

	cout << "===================" << endl;
	cout << "list iterator test" << endl;
	cout << "===================" << endl;

	for (listiter = mylist.begin(); listiter != mylist.end(); ++listiter)
	{
		cout << *listiter << endl;
	}

	return 0;
}