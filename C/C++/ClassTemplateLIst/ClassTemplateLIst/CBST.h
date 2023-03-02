#pragma once
#include<assert.h>



enum class NODE_TYPE
{
	PARNET,//0
	LCHILD,//1
	RCHILD,//2
	END,//3
};


template<typename T1, typename T2>
struct tPair
{
	T1 first;
	T2 second;
};

template<typename T1, typename T2>
tPair<T1, T2> make_bstpair(const T1& _first, const T2& _second)
{
	return tPair<T1, T2>{ _first, _second };
}


template<typename T1, typename T2>
struct tBSTNode
{
	//data
	tPair<T1, T2> pair;
	tBSTNode* arrNode[(int)NODE_TYPE::END];//�迭�� �����ϰڴ�


	//�θ���
	//tBSTNode* pParent;
	////�ڽĳ��
	//tBSTNode* pLeftChild;
	//tBSTNode* pRightChild;

	bool IsRoot() {//��Ʈ ������� Ȯ��
		if (nullptr == arrNode[(int)NODE_TYPE::PARNET)])
		return true;

		return false;
	}

	bool IsLeftChild()
	{
		//pSuccessor�� �θ��� ���� �ڽ� ��尡 pSuccessor�� ���
		if (this->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::LCHILD] == this)
			return true;

		return false;
	}

	bool IsRightChild()
	{
		//pSuccessor�� �θ��� ������ �ڽ� ��尡 pSuccessor�� ���
		if (this->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::RCHILD] == this)
			return true;

		return false;
	}

	bool IsLeaf() 
	{
		if (nullptr == arrNode[(int)NODE_TYPE::LCHILD] && nullptr == arrNode[(int)NODE_TYPE::RCHILD])
			return true;

		return false;
	}

	bool IsFull()
	{
		if (arrNode[(int)NODE_TYPE::LCHILD] &&arrNode[(int)NODE_TYPE::RCHILD])//������ true nullptr�� �ƴϹǷ�
			return true;

		return false;
	}

	tBSTNode()
		:pair()
		, arrNode()
	{}

	tBSTNode(const tPair<T1, T2>& _pair, tBSTNode* _pParent, tBSTNode* _pLChild, tBSTNode* _pRChild)
		:pair(_pair)
		, arrNode{ _pParent, _pLChild, _pRChild }

};

template <typename T1, typename T2>
class CBST//binary search tree
{
private:
	tBSTNode<T1, T2>* m_pRoot;//��Ʈ ��� �ּ�
	int m_iCount;//������ ����

public:
	bool insert(const tPair<T1, T2>& _pair);
	tBSTNode<T1, T2>* GetInOrderSuccessor(tBSTNode<T1, T2>* _pNode);
	tBSTNode<T1, T2>* GetInOrderPredecessor(tBSTNode<T1, T2>* _pNode);

	class iterator;
public:
	iterator begin();
	iterator end();
	iterator find(const T1& _find);//���� ã�����ϴ� ���� ���� �ִ� iterator ��ȯ
	iterator erase(const iterator& _iter);//iterator�� ����Ű�� ��带 �����.


private:
	tBSTNode<T1, T2>* DeleteNode(tBSTNode<T1,T2>* _pTargetNode);


public:
	CBST()
		:m_pRoot(nullptr)
		, m_iCount(0)
	{}

	//iterator
	class iterator
	{
	private:
		CBST<T1, T2>* m_pBST;
		tBSTNode<T1, T2>* m_pNode;//null�� ��� end iterator

	public:
		bool operator == (const iterator& _other)
		{
			if (m_pBST == _other.m_pBST && m_pNode == _other.m_pNode)
				return true;

			return false;
		}

		bool operator != (const iterator& _other)
		{
			return !(*this == _other);
		}

		const tPair<T1, T2>& operator *()//�ᱹ ��� �ȿ� ����ִ� ���� pair�̱� ������
		{
			//m_pNode nullptr üũ(end iterator)���� �ƴ���
			//��, m_pNode nullptr�̸� ��� �߰� �ƴϸ� �ȶ߰� �ȴ�.
			assert(m_pNode);
			return m_pNode->pair;
		}

		const tPair<T1, T2>* operator ->()//pair�� �ּҰ��� �ִ� ����
		{
			assert(m_pNode);
			return &m_pNode->pair;
		}

		iterator& operator ++()
		{
			m_pNode = m_pBST->GetInOrderSuccessor(m_pNode);
			return *this;
		}

	public:
		iterator()
			:m_pBST(nullptr)
			, m_pNode(nullptr)
		{}
		iterator(CBST<T1, T2>* _pBST, tBSTNode<T1, T2>* _pNode) {
			:m_pBST(_pBST)
				, m_pNode(_pNode)
		}

		friend class CBST<T1, T2>;
	};

};

template<typename T1, typename T2>
inline bool CBST<T1, T2>::insert(const tPair<T1, T2>& _pair)
{
	tBSTNode<T1, T2>* pNewNode = new tBSTNode<T1, T2>(_pair, nullptr, nullptr, nullptr); //�⺻ �����ڷ� ȣ��
	//pNewNode->pair = _pair;//����ü ������ ���� ������ �����ϴ�.
	//tBSTNode->pParent = nullptr;
	//tBSTNode->pLeftChild = nullptr;
	//tBSTNode->pRightChild = nullptr;

	//ù ��° ��忩�� �ƹ��͵� ���� ���
	if (nullptr == m_pRoot)
	{
		m_pRoot = pNewNode;
	}
	else
	{
		tBSTNode<T1, T2>* pNode = m_pRoot;
		NODE_TYPE node_type = NODE_TYPE::END;
		while (true) {

			if (pNode->pair.first < pNewNode->pair.first)
			{
				node_type = NODE_TYPE::RCHILD;
			}

			else if (pNode->pair.first > pNewNode->pair.first)
			{
				node_type = NODE_TYPE::LCHILD;
			}

			else return false;

			if (nullptr == pNode->arrNode[(int)node_type])//NODE_TYPE node_type ���� ������ Ȯ���� ������ �����Ƿ� ����ִ� ���� Ȯ��, ���� ������� Ȯ��
			{
				pNode->arrNode[(int)node_type] = pNewNode;
				pNewNode->arrNode[(int)NODE_TYPE::PARNET] = pNode;
				break;
			}
			else {
				pNode = pNode->arrNode[(int)node_type];
			}
		}
	}
}

template<typename T1, typename T2>
inline tBSTNode<T1, T2>* CBST<T1, T2>::GetInOrderSuccessor(tBSTNode<T1, T2>* _pNode)
{
	tBSTNode<T1, T2>* pSuccessor = nullptr;

	//1. ������ �ڽ��� �ִ� ���, ������ �ڽ����� ����, ���� �ڽ��� ���� ������ �������� ������
	if (nullptr != _pNode->arrNode[(int)NODE_TYPE::RCHILD])
	{
		pSuccessor = _pNode->arrNode[(int)NODE_TYPE::RCHILD];

		while (pSuccessor->arrNode[(int)NODE_TYPE::LCHILD])
		{
			pSuccessor = pSuccessor->arrNode[(int)NODE_TYPE::LCHILD];
		}
	}
	//2. ������ �ڽ��� ���� ��쿡�� �θ�κ��� �����ڽ��� ������ ���� �ö�

	else {
		pSuccessor = _pNode;

		while (true)
		{
			//��Ʈ���� �ö��� ���
			if (pSuccessor->IsRoot())//pSuccessor�� pointer�̹Ƿ� �̷���
				return nullptr;
			if (pSuccessor->IsLeftChild())//pSuccessor�� ���� �ڽ����� Ȯ���ϰ� �����ڽ��� ������ �θ� �ļ���
			{
				pSuccessor = pSuccessor->arrNode[(int)NODE_TYPE::PARNET];
				break;
			}
			else {// pSuccessor�� ���� �ڽ����� Ȯ���ϰ� �����ڽ��� �ƴϸ� �θ������� �ٽ� �ö󰣴�.
				pSuccessor = pSuccessor->arrNode[(int)NODE_TYPE::PARNET];
			}
		}
	}

	return pSuccessor;
}

template<typename T1, typename T2>
inline tBSTNode<T1, T2>* CBST<T1, T2>::GetInOrderPredecessor(tBSTNode<T1, T2> _pNode)
{
	return nullptr;
}

template<typename T1, typename T2>
inline typename CBST<T1, T2>::iterator CBST<T1, T2>::begin()//���� ��ȸ�� ù��° ��, �� ���� �ܸ����
{
	tBSTNode<T1, T2>* pNode = m_pRoot;

	while (pNode->arrNode[(int)NODE_TYPE::LCHILD]) {
		pNode = pNode->arrNode[(int)NODE_TYPE::LCHILD]
	}
	return iterator(this, pNode);
}

template<typename T1, typename T2>
inline typename CBST<T1, T2>::iterator CBST<T1, T2>::end()
{

	return iterator(this, nullptr);
	//end iterator�� nullptr�� ����Ű�ڰ� ����ߴ�.
	//�׸��� ã���ִ� ��尡 ������ end�� ����
}

template<typename T1, typename T2>
inline typename CBST<T1, T2>::iterator CBST<T1, T2>::find(const T1& _find)
{

	tBSTNode<T1, T2>* pNode = m_pRoot;
	NODE_TYPE node_type = NODE_TYPE::END;
	while (true) {

		if (pNode->pair.first < _find)
			node_type = NODE_TYPE::RCHILD;

		else if (pNode->pair.first > _find)
			node_type = NODE_TYPE::LCHILD;
		//ã���� ���
		else break;
		//�� ã���� ���
		if (nullptr == pNode->arrNode[(int)node_type])//ã�� ��尡 ���� ���
		{
			pNode = nullptr;
			break;
		}
		else {
			pNode = pNode->arrNode[(int)node_type];
		}

	}

	return iterator(this, pNode);
}

template<typename T1, typename T2>
inline typename CBST<T1,T2>::iterator CBST<T1, T2>::erase(const iterator& _iter)
{
	assert(this == _iter.m_pBST);//���� iterator�� ����Ű�� Ʈ���� _iter�� Ʈ���� ������ Ȯ��
	
	tBSTNode<T1, T2>* pSuccessor = DeleteNode(_iter.m_pNode);

	return iterator(this, pSuccessor);
}

template<typename T1, typename T2>
inline tBSTNode<T1, T2>* CBST<T1, T2>::DeleteNode(tBSTNode<T1, T2>* _pTargetNode)
{
	
	tBSTNode<T1, T2>* pSuccessor = GetInOrderSuccessor(_pTargetNode);
	//1. �ڽ��� �ϳ��� ���� ���, �� �ܸ� ��� �� ��
	if (_pTargetNode.m_pNode->IsLeaf())
	{	//������ų ����� �ļ��� ��带 ã�Ƶд�.
		
		//������ ��尡 ��Ʈ����(�ڽ��� ���� ��Ʈ ==> BST �ȿ� �����Ͱ� 1�� �ۿ� ������)
		if (_pTargetNode == this->m_pRoot)//�� �Լ��� CBST Ŭ������ �����ִ�. 
		{
			m_pRoot = nullptr;
		}
		else{


		//�θ���� ����, ������ �۽� ��带 ����Ű�� �����͸� nullptr�� �����.
		if (_pTargetNode->IsLeftChild())
		{
			_pTargetNode->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::LCHILD] = nullptr;
		}
		else
		{
			_pTargetNode->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::RCHILD] = nullptr;
		}
		delete _pTargetNode;
	}
		//������ ���� ���̱�
		--m_iCount;
	}
	//2. �ڽ��� 2���� ���
	else if (_pTargetNode->IsFull())
		//������ �ڸ��� ���� �ļ���, ������ �� �ϳ��� �͵� ����������
		//���⼭�� �ļ��ڰ� �� �� �ִ°��� �������� �Ѵ�.
	{
		//������ �ڸ��� ���� �ļ����� ���� �����Ų��.
		_pTargetNode->pair = pSuccessor->pair;
		//���� �ļ����� ��带 �����Ѵ�.
		DeleteNode(pSuccessor);

		pSuccessor = _pTargetNode;//��ȯ ������ ���� ��带 ����ϹǷ�
		return pSuccessor;
		//���⼭�� ��带 ������ �����Ƿ� --m_iCount;�� ���ʿ䰡 ���� 
		//�ֳ��ϸ� �ϳ��� �ڽ��� �������Ƿ� ���ȣ���� �Ͽ� 1,3�� Case�� �ɸ��� �ڵ������� 1,3�� �߿��� �ѹ�  --m_iCount;�� �ϱ� ����
	}
	//3. �ڽ��� 1���� ���
	else 
	{

		NODE_TYPE eChildType = NODE_TYPE::LCHILD;
		if (_pTargetNode->arrNode[(int)NODE_TYPE::RCHILD])//������ �ڽ��� �����ϸ� ������ �ڽ��� ������ �ִٰ� �ν��ϰڴ�(������ �ڽ��� 1���̹Ƿ�)
			eChildType = NODE_TYPE::RCHILD;
		//������ ��尡 ��Ʈ����.
		if (_pTargetNode == m_pRoot)
		{
			//�ڽĳ��(1��)�� ��Ʈ�� �����.
			m_pRoot = _pTargetNode->arrNode[(int)eChildType];
			_pTargetNode->arrNode[(int)eChildType]->arrNode[(int)NODE_TYPE::PARNET] = nullptr;
		}
		else {
			//������ ����� �θ��, ������ ����� �ڽ��� �������ش�.
			if (_pTargetNode->IsLeftChild())
			{
				_pTargetNode->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::LCHILD] = _pTargetNode->arrNode[(int)eChildType];
				//Ÿ���� ���� �ڽ��̸� Ÿ���� �θ��� ������ Ÿ���� �ϳ����� �ڽ����� ��ü
			}

			else {
				_pTargetNode->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::RCHILD] = _pTargetNode->arrNode[(int)eChildType];
				//Ÿ���� ���� �ڽ��̸� Ÿ���� �θ��� ������ Ÿ���� �ϳ����� �ڽ����� ��ü
			}
			_pTargetNode->arrNode[(int)eChildType]->arrNode[(int)NODE_TYPE::PARNET] = _pTargetNode->arrNode[(int)NODE_TYPE::PARNET];
		}
		delete _pTargetNode;
			
			
			//������ų ����� �ļ��� ��带 ã�Ƶд�. 

		//������ ���� ���̱�
		--m_iCount;
	}
	

	return pSuccessor;
}

//			while (true) {
//
//				tBSTNode<T1, T2>* pNode = m_pRoot;
//			if (pNode->pair.first < pNewNode->pair.first)
//			{
//
//
//				if (nullptr == pNode->pRightChild)
//				{
//					pNewNode->pParent = pNode;
//					pNode->pRightChild = pNewNode;
//					break;
//				}
//				else 
//				{
//					pNode = pNode->pRightChild;
//				}
//				
//			}
//			else if (pNode->pair.first > pNewNode->pair.first)
//			{
//				if (nullptr == pNode->pLeftChild)
//				{
//					pNewNode->pParent = pNode;
//					pNode->pLeftChild = pNewNode;
//					break;
//				}
//				else 
//				{
//					pNode = pNode->pLeftChild;
//				}
//				
//			}
//			else//�ߺ�Ű�� ���
//			{
//				return false;
//			}
//		}
//		++m_iCount;
//		return true;
//	}
//
