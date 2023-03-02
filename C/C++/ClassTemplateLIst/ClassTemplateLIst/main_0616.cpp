#include<iostream>
#include "CBST.h"


using std::cout;
using std::endl;
using std::sin;

class CParent
{
protected://��� ���� Ŭ���������� ���� �����ϰ� �ϴ� ����� �Ѵ�.
	int  m_i;

public:
	void SetInt(int _a)
	{
		m_i = _a;
	}

	virtual void Output()
	{
		cout << "Parent" << endl;
	}

public:
	CParent()
		:m_i(0)
	{
		cout << "�θ� ������" << endl;
	}

	CParent(int _a)
		:m_i(_a)
	{}
	~CParent()
	{
		cout << "�θ� �Ҹ���" << endl;
	}
};

class CChild : public CParent//: public CParent�̰� ��� �޾Ҵٴ� ǥ��
	//�ݺ����� ���� �����Ǵ� ���� ������� �������� 
{
private:
	float m_f;

public:
	void SetFloat(float _f)
	{
		m_f = _f;
		m_i = 100;
	}

	//��ӹ��� �θ�Ŭ������ �Լ��� ������(�������̵�) ��
	void Output()
	{
		cout << "child" << endl;
	}

public:
	CChild()
		//CParent() //�⺻������ �����Ǿ� �ִ�.
		:CParent(10)//������ ���� ����� ���� �����ڴ� �ݵ�� �����ε� ����� �Ѵ�.
		,m_f(0.f)
		//,m_i(0)������ �Ǵ� ������ �ʱ�ȭ�� ���� �θ�, �ڽĿ��� ������Ѵ�.
		//��, �޸� �Ҵ翡�� �θ� �ڽ��� ���� ��� ������ å������ �Ǵ� ���̴�.
		
		//����� ȣ���� �ڽ��� ���� �ǰ� ������ �θ����� ȣ���ؼ� ������ ���� �ڽ��� �ʱ�ȭ�� �����Ѵ�.
		//ȣ���� �ڽ��� ����(�ʱ�ȭ)�� �θ� ���� �Ǵ� ���̴�.
	
	{
		//m_i = 0;
		cout << "�ڽ� ������" << endl;
	}

	~CChild()
		//�Ҹ��ڴ� �ڽ� �Ҹ��ں��� ȣ��ǰ� ȣ��� �ڽ� �Ҹ����� ����� ���� ������ ��
		//�θ� �Ҹ��ڸ� ȣ���ϰ� �����Ѵ�.
	{
		cout << "�ڽ� �Ҹ���" << endl;
	}

};

class CChildChild : public CChild
{
private:
	long long m_ll;
};

//������ ���� ��� ���� �Լ���
void FuncA()
{
	cout << "Function A" << endl;
}

void FuncB()
{
	FuncA();
	cout << "Function B" << endl;
}

//�Ҹ��� ���� ��� ���� �Լ���

void FuncAA()
{
	cout << "Function A" << endl;
}

void FuncBB()
{
	cout << "Function B" << endl;
	FuncAA();
}



int main()
{
	//��ü���� ��� Ư¡
	//1. ĸ��ȭ
	//2. ���
	//3. ������
	//4. �߻�ȭ

	CParent parent;
	parent.Output();
	CChild child;
	child.Output();
	child.CParent::Output();//�ڽ� ��ü���� �������̵��� �θ�Ŭ������ �Լ��� �θ��ʿ��� ȣ���ϰ� �������

	//���
	//�ڽ� or �θ� Ŭ������ ��Ӱ��迡�� �ٸ� Ŭ������ ����� �ʱ�ȭ �� �� ����.
	//������ ȣ�� ���� �ڽ�->�θ�
	//������ ���� ����, �ʱ�ȭ ���� �θ� ->�ڽ�
	
	// �Ҹ��� ���� �� ȣ�� ����, �ڽ� -> �θ�
	//�ڽ� �Ҹ��� ���� �θ��� �Ҹ��ڸ� �����ϰ� �ִ� �����̴�
	 
	//�������̵�
	//�θ� Ŭ������ ����Լ��� �ڽ��ʿ��� ������ �����ν�, �ڽ� Ŭ������ ������ ����� ȣ��ǵ��� �Ѵ�.
	
	//��� And ������
	

	/*
	CParent parent;
	CChild child;
	CParent* pParent = &parent; --(1)
	CChild* pChild = &child;    --(2)

	CParent* pParent = &child;  --(1)
	//�޸� �Ҵ��� ���� [parent | child ]�̷��� �Ǿ��ִµ� 
	ó�� �ּҰ� parent�̹Ƿ� �޺κ��� �� �ʿ䰡 ���� ������ ������ ���� �ʴ´�.

	CChild* pChild = &parent;   --(2)//������ �ִ�. 
	//�޸� �Ҵ��� ���� &parent; �� �κ��� [parent]�̷��� �Ǿ��ִµ� child�� �޺κб��� �˾ƾ��ϴµ� �� �� ���� ������
	��ĩ �ٸ� �޸� �κ��� ħ���� �� �ִ�. �����ּҵ� ���� �Ӵ���
	
	*/

	//�ڵ���(�θ�)�� ������ ����, �ڵ���, Ʈ��(�ڽĵ�)�� ����� �ְ� �ȴٰ� ������

	CParent* pParent = nullptr;
	
	parent.Output();
	pParent = &parent;
	pParent->Output();

	child.Output();
	pParent = &child;
	pParent->Output();


	pParent = &parent;

	((CChild*)pParent)->NewFunc();//NewFunc() CChild���� �����ϴ� �ڽĸ� ������ �ִ� �Լ�

	CChild* pChild = dynamic_cast<CChild*>(pParent);
	if (nullptr != pChild)
	{
		pChild->NewFunc();
	}





	//������, �����Լ�(virtual)
	//�θ� ������ Ÿ������, �θ� Ŭ�����κ��� �Ļ��Ǵ� �ڽ�Ŭ���� ��ü���� �ּҸ� ����ų �� �ִ�.
	//��� ��ü�� �θ� Ŭ���� Ÿ������ �ν��ϰ� �Ǳ� ������, ���� ��ü�� �������� �� �� ����.
	//virtual Ű���带 ���ؼ�, �� Ŭ������ �ڽŸ��� ������ �����Լ� ���̺��� ������ �ȴ�.
	//�� Ŭ������ ��ü���� �����Լ� ���̺� �����Ϳ��� �ش� Ŭ������ �´� ���̺��� ����Ű�� �ȴ�.
	//�� ���̺��� �ش� Ŭ������ �����Լ����� ��ϵȴ�.

	//�ٿ� �ɽ���
	//�θ� Ŭ�������� ������� ����, ���� �ڽ��ʿ����� �߰��� �Լ��� ȣ�� �ϰ� ���� ��
	//�ڽ� ������ Ÿ������ �Ͻ������� ĳ���� �ؼ� ȣ���Ѵ�.
	//������ �߻� �� �� �ֱ� ������ dynamic_cast�� �����ϰ� Ȯ���� �� �� �ִ�.
	//RTTI(Run Time Type Identification or Information)

	//�߻�ȭ
	//���� ��ü�� ������ ������ Ŭ������ �ƴ�, ����� ���ؼ� �����ؾ��� ������ �����ϴ� ��� �������� ������� Ŭ����
	//virtual, =0(1 �� �̻��� ���� �����Լ��� �����ϸ� �߻�Ŭ������ �ȴ�.)






	parent.SetInt(10);
	child.SetInt(10);

	return 0;
}