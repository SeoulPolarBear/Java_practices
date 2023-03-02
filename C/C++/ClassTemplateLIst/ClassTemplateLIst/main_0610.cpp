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
//열거형
//다음과 같이 순차적으로 값이 늘이난다.
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
	int a = TYPE_1;// 다음과 같이 TYPE_1이 누구 건지 모르는 경우가 발생할 수 있으므로
}

//다음과 같이 enum 클래스를 만들게 되었다.
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
	int a = (int)MY_TYPE::TYPE_1;// 다음과 같이 TYPE_1이 누구 건지 확인할 수 있게 반드시 앞에 클래스 명을 붙여야 한다.
								//그리고 자료형이기 때문에 반드시 ****캐스팅*****을 해줘야 한다.
	OTHER_TYPE::TYPE_1;

}







class Myclass
{
	int a;
public:
	// 함수 뒤에 const를 붙히는 이유는 객체 내부 변수 변경 불가.
	//const 함수만 호출 가능하게 하기 위해서 입니다.
	//이러한 기능을 가지고 있어 getter나 bool 반환값에서 많이 사용되며 이로 인해 함수 내부의 변수 변경을 방지 할 수 있다.
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
{//이진탐색- 문제를 절반씩 줄여가면서 찾는 방법
//1. (전제)정렬되어있는 데이터에 적용가능



 //이진 탐색 트리와는 다른 개념이다.
//이진탐색트리
//1. 이진탐색을 사용 할 수 있게 고안된 이진트리
//2. 데이터 입력 시 Olog(N) 효율
//3. 탐색 효율은  Olog(N) 효율

//4. 트리의 모양이 밸런스가 유지되지 않으면 제대로 된 탐새개 효율이 나오지 않는다.
// -자가균형 기능 필요(AVL, Red/Black)

	set<int> setInt;//int를 저장할 수 있는 Red/Black 트리라고 생각하면 된다.
	setInt.insert(100);//힙 메모리로 동적할당으로 관리한다.
	//처음 만들어 질때는 root에 저장되고 우리는 root를 기억하면 된다. (마치 list 처럼)

	//map<int, float> mapData;//첫번째 타입은 비교의 타입 뒤에 타입은 실재로 내가 저장하고 싶은 data 값// 즉, 비교를 할때는 앞에 타입을 가지고 한다.
	//비교의 대상은 문자열(학생의 이름), 진짜 저장하고 싶은 data는 학생의 정보(struct)`

	const wchar_t* pStr = L"문자열";


	//***********하지만 이렇게 찾으면 주소를 비교해서 찾기 때문에 오류가 발생할 수 있다. 즉,  string을 이용해서 찾아야 한다.***************
	map<const wchar_t*, tStdInfo> mapData;
	tStdInfo info(L"홍길동", 18, MAN);
	tStdInfo info2(L"이지혜", 25, WOMAN);

	mapData.insert(make_pair(L"홍길동", info));// 즉, 앞에 있는 건 비교 대상이 될 거고 뒤에 있는건 저장할 data
	mapData.insert(make_pair(L"이지혜", info2));

	map<const wchar_t*, tStdInfo>::iterator mapiter;

	mapiter = mapData.find(L"홍길동");//이렇게 하면 찾게되는게 pair가 찾아진다. ex) return 값은 (L"홍길동", info)를 가리키는 iterator이다.
	mapiter = mapData.find(L"염길동");//존재하지 않는 것을 찾을 시 경고문이 뜨지 않고 end iterator를 반환 시켜준다.(못 찾았다는 의미로)


	_wsetlocale(LC_ALL, L"korean");//한글사용시 꼭 사용
	//찾지 못했다.
	if (mapiter == mapData.end())
	{
		wcout << L"데이터를 찾을 수 없다." << endl;
	}
	else
	{
		wcout << L"이름 : " << mapiter->second.szName << endl;
		wcout << L"나이 : " << mapiter->second.age << endl;
		wcout << L"성별 : ";
		if (MAN == mapiter->second.gender)
		{
			wcout << L"남자" << endl;
		}
		else if (WOMAN == mapiter->second.gender)
		{
			wcout << L"여자" << endl;
		}
		else {
			wcout << L"알 수 없음" << endl;
		}
	}



	mapiter->first;//실제 pair 부분은 위에 처럼 되어 있다.
	mapiter->second;

	map<wstring, tStdInfo> mapStdInfo;
	wstring str;//가변배열(vector<wchar_t>와 매우 유사한 기능을 한다.
	str = L"adbcef";//주소를 가지고 있는게 아니고 data를 복사해서 가지고 있는다. wstring 클래스 내에서 operator로 구현 되어 있음.
	str += L"hijk";// 뒤에 붙히는 opeator도 가능
	str += L"lmnop";// 이말은 동적할당으로 메모리를 관리하고 있다는 것을 알 수 있다.
	str[1] = L'c';//자체적인 힙 메모리를 바꾸니까


	//우열을 가릴 수 있게 wstring에는 operator가 구현되어 있다.
	//if (str == str2)// 따라서 map을 구현할 때 비교자를 비교할 때 문제가 없게 된다.
		//if (str < str2)// 따라서 map을 구현할 때 비교자를 비교할 때 문제가 없게 된다.
			//if (str > str2)// 따라서 map을 구현할 때 비교자를 비교할 때 문제가 없게 된다.


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

	pPair->first;//사실은 pPair->->first 이렇게 되어야 한다. 
	//즉 주소를 받지 않게 되면 pPair->는 pair이고 그리고 pair안에 first를 가리키게 되는 것이다.
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
