#include <iostream>
#include <map>
#include <set>
#include <string>
#include "CBST.h"

using std::map;
using std::make_pair;

using std::set;
using std::wcout;
using std::endl;
using std::wstring;

#define MAN		1
#define WOMAN	2

struct tStdInfo {
	wchar_t szName[20];
	unsigned char age;
	unsigned char gender;


	tStdInfo()
		:szName{}
		, age(0)
		, gender(0)
	{

	}

	tStdInfo(const wchar_t* _pName, unsigned char _age, unsigned char _gender)
		:szName{}
		, age(_age)
		, gender(_gender)
	{
		wcscpy(szName, _pName);//(des, source)
	}
};


struct pair
{
	const wchar_t* first;
	tStdInfo		second;
};
//������
//������ ���� ���������� ���� ���̳���.
enum MY_TYPE
{
	TYPE_1,//0
	TYPE_2,//1
	TYPE_3,//2
	TYPE_4,//3
	TYPE_5 = 100,
	TYPE_6,//101
};

enum OTHER_TYPE
{
	TYPE_1,
};

int main()
{
	int a = TYPE_1;// ������ ���� TYPE_1�� ���� ���� �𸣴� ��찡 �߻��� �� �����Ƿ�
}

//������ ���� enum Ŭ������ ����� �Ǿ���.
enum class MY_TYPE
{
	TYPE_1,//0
	TYPE_2,//1
	TYPE_3,//2
	TYPE_4,//3
	TYPE_5 = 100,
	TYPE_6,//101
};

enum class OTHER_TYPE
{
	TYPE_1,
};

int main()
{
	int a = (int)MY_TYPE::TYPE_1;// ������ ���� TYPE_1�� ���� ���� Ȯ���� �� �ְ� �ݵ�� �տ� Ŭ���� ���� �ٿ��� �Ѵ�.
								//�׸��� �ڷ����̱� ������ �ݵ�� ****ĳ����*****�� ����� �Ѵ�.
	OTHER_TYPE::TYPE_1;

}







class Myclass
{
	int a;
public:
	// �Լ� �ڿ� const�� ������ ������ ��ü ���� ���� ���� �Ұ�.
	//const �Լ��� ȣ�� �����ϰ� �ϱ� ���ؼ� �Դϴ�.
	//�̷��� ����� ������ �־� getter�� bool ��ȯ������ ���� ���Ǹ� �̷� ���� �Լ� ������ ���� ������ ���� �� �� �ִ�.
	bool operator < (const Myclass& _other) const
	{
		if (a < _other.a) {
			return true;
		}
		else return false;
	}
	bool operator > (const Myclass& _other) const
	{
		if (a < _other.a) {
			return false;
		}
		else return true;
	}
};






int main()
{//����Ž��- ������ ���ݾ� �ٿ����鼭 ã�� ���
//1. (����)���ĵǾ��ִ� �����Ϳ� ���밡��



 //���� Ž�� Ʈ���ʹ� �ٸ� �����̴�.
//����Ž��Ʈ��
//1. ����Ž���� ��� �� �� �ְ� ��ȵ� ����Ʈ��
//2. ������ �Է� �� Olog(N) ȿ��
//3. Ž�� ȿ����  Olog(N) ȿ��

//4. Ʈ���� ����� �뷱���� �������� ������ ����� �� Ž���� ȿ���� ������ �ʴ´�.
// -�ڰ����� ��� �ʿ�(AVL, Red/Black)

	set<int> setInt;//int�� ������ �� �ִ� Red/Black Ʈ����� �����ϸ� �ȴ�.
	setInt.insert(100);//�� �޸𸮷� �����Ҵ����� �����Ѵ�.
	//ó�� ����� ������ root�� ����ǰ� �츮�� root�� ����ϸ� �ȴ�. (��ġ list ó��)

	//map<int, float> mapData;//ù��° Ÿ���� ���� Ÿ�� �ڿ� Ÿ���� ����� ���� �����ϰ� ���� data ��// ��, �񱳸� �Ҷ��� �տ� Ÿ���� ������ �Ѵ�.
	//���� ����� ���ڿ�(�л��� �̸�), ��¥ �����ϰ� ���� data�� �л��� ����(struct)`

	const wchar_t* pStr = L"���ڿ�";


	//***********������ �̷��� ã���� �ּҸ� ���ؼ� ã�� ������ ������ �߻��� �� �ִ�. ��,  string�� �̿��ؼ� ã�ƾ� �Ѵ�.***************
	map<const wchar_t*, tStdInfo> mapData;
	tStdInfo info(L"ȫ�浿", 18, MAN);
	tStdInfo info2(L"������", 25, WOMAN);

	mapData.insert(make_pair(L"ȫ�浿", info));// ��, �տ� �ִ� �� �� ����� �� �Ű� �ڿ� �ִ°� ������ data
	mapData.insert(make_pair(L"������", info2));

	map<const wchar_t*, tStdInfo>::iterator mapiter;

	mapiter = mapData.find(L"ȫ�浿");//�̷��� �ϸ� ã�ԵǴ°� pair�� ã������. ex) return ���� (L"ȫ�浿", info)�� ����Ű�� iterator�̴�.
	mapiter = mapData.find(L"���浿");//�������� �ʴ� ���� ã�� �� ����� ���� �ʰ� end iterator�� ��ȯ �����ش�.(�� ã�Ҵٴ� �ǹ̷�)


	_wsetlocale(LC_ALL, L"korean");//�ѱۻ��� �� ���
	//ã�� ���ߴ�.
	if (mapiter == mapData.end())
	{
		wcout << L"�����͸� ã�� �� ����." << endl;
	}
	else
	{
		wcout << L"�̸� : " << mapiter->second.szName << endl;
		wcout << L"���� : " << mapiter->second.age << endl;
		wcout << L"���� : ";
		if (MAN == mapiter->second.gender)
		{
			wcout << L"����" << endl;
		}
		else if (WOMAN == mapiter->second.gender)
		{
			wcout << L"����" << endl;
		}
		else {
			wcout << L"�� �� ����" << endl;
		}
	}



	mapiter->first;//���� pair �κ��� ���� ó�� �Ǿ� �ִ�.
	mapiter->second;

	map<wstring, tStdInfo> mapStdInfo;
	wstring str;//�����迭(vector<wchar_t>�� �ſ� ������ ����� �Ѵ�.
	str = L"adbcef";//�ּҸ� ������ �ִ°� �ƴϰ� data�� �����ؼ� ������ �ִ´�. wstring Ŭ���� ������ operator�� ���� �Ǿ� ����.
	str += L"hijk";// �ڿ� ������ opeator�� ����
	str += L"lmnop";// �̸��� �����Ҵ����� �޸𸮸� �����ϰ� �ִٴ� ���� �� �� �ִ�.
	str[1] = L'c';//��ü���� �� �޸𸮸� �ٲٴϱ�


	//�쿭�� ���� �� �ְ� wstring���� operator�� �����Ǿ� �ִ�.
	//if (str == str2)// ���� map�� ������ �� ���ڸ� ���� �� ������ ���� �ȴ�.
		//if (str < str2)// ���� map�� ������ �� ���ڸ� ���� �� ������ ���� �ȴ�.
			//if (str > str2)// ���� map�� ������ �� ���ڸ� ���� �� ������ ���� �ȴ�.


	CBST<int,int> bstint;
	bstint.insert(make_bstpair(100, 0));//           100
	bstint.insert(make_bstpair(150, 0));//        50     150
	bstint.insert(make_bstpair(50, 0));//       25 75  125 175    
	bstint.insert(make_bstpair(25, 0));
	bstint.insert(make_bstpair(75, 0));
	bstint.insert(make_bstpair(125, 0));
	bstint.insert(make_bstpair(175, 0));


	CBST<int, int>::iterator Iter = bstint.begin();
	Iter = bstint.find(150);

	tPair<int, int> pair;

	tPair<int, int>* pPair = &pair;

	pPair->first;//����� pPair->->first �̷��� �Ǿ�� �Ѵ�. 
	//�� �ּҸ� ���� �ʰ� �Ǹ� pPair->�� pair�̰� �׸��� pair�ȿ� first�� ����Ű�� �Ǵ� ���̴�.
	pPair->second;


	for (Iter = bstint.begin(); Iter != bstint.end(); ++Iter)
	{
		wcout << Iter->first << Iter->second << endl;
		
	}



	map<int, int> mapInt;
	mapInt.insert(make_pair(100, 100));

	map<int, int>::iterator iter = mapInt.find(100);
	if (iter == mapInt.end())
	{

	}


	return 0;
}
