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
	tBSTNode* arrNode[(int)NODE_TYPE::END];//배열로 관리하겠다


	//부모노드
	//tBSTNode* pParent;
	////자식노드
	//tBSTNode* pLeftChild;
	//tBSTNode* pRightChild;

	bool IsRoot() {//루트 노드인지 확인
		if (nullptr == arrNode[(int)NODE_TYPE::PARNET)])
		return true;

		return false;
	}

	bool IsLeftChild()
	{
		//pSuccessor의 부모의 왼쪽 자식 노드가 pSuccessor일 경우
		if (this->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::LCHILD] == this)
			return true;

		return false;
	}

	bool IsRightChild()
	{
		//pSuccessor의 부모의 오른쪽 자식 노드가 pSuccessor일 경우
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
		if (arrNode[(int)NODE_TYPE::LCHILD] &&arrNode[(int)NODE_TYPE::RCHILD])//있으면 true nullptr이 아니므로
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
	tBSTNode<T1, T2>* m_pRoot;//루트 노드 주소
	int m_iCount;//데이터 개수

public:
	bool insert(const tPair<T1, T2>& _pair);
	tBSTNode<T1, T2>* GetInOrderSuccessor(tBSTNode<T1, T2>* _pNode);
	tBSTNode<T1, T2>* GetInOrderPredecessor(tBSTNode<T1, T2>* _pNode);

	class iterator;
public:
	iterator begin();
	iterator end();
	iterator find(const T1& _find);//내가 찾고자하는 것을 갖고 있는 iterator 반환
	iterator erase(const iterator& _iter);//iterator가 가리키는 노드를 지운다.


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
		tBSTNode<T1, T2>* m_pNode;//null인 경우 end iterator

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

		const tPair<T1, T2>& operator *()//결국 노드 안에 들어있는 것은 pair이기 때문에
		{
			//m_pNode nullptr 체크(end iterator)인지 아닌지
			//즉, m_pNode nullptr이면 경고가 뜨고 아니면 안뜨게 된다.
			assert(m_pNode);
			return m_pNode->pair;
		}

		const tPair<T1, T2>* operator ->()//pair의 주소값을 주는 역할
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
	tBSTNode<T1, T2>* pNewNode = new tBSTNode<T1, T2>(_pair, nullptr, nullptr, nullptr); //기본 생성자로 호출
	//pNewNode->pair = _pair;//구조체 끼리는 대입 연산이 가능하다.
	//tBSTNode->pParent = nullptr;
	//tBSTNode->pLeftChild = nullptr;
	//tBSTNode->pRightChild = nullptr;

	//첫 번째 노드여서 아무것도 없을 경우
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

			if (nullptr == pNode->arrNode[(int)node_type])//NODE_TYPE node_type 왼쪽 오르쪽 확인은 위에서 했으므로 비어있는 곳만 확인, 종말 노드인지 확인
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

	//1. 오른쪽 자식이 있는 경우, 오른쪽 자식으로 가서, 왼쪽 자식이 없을 때까지 왼쪽으로 내려감
	if (nullptr != _pNode->arrNode[(int)NODE_TYPE::RCHILD])
	{
		pSuccessor = _pNode->arrNode[(int)NODE_TYPE::RCHILD];

		while (pSuccessor->arrNode[(int)NODE_TYPE::LCHILD])
		{
			pSuccessor = pSuccessor->arrNode[(int)NODE_TYPE::LCHILD];
		}
	}
	//2. 오른쪽 자식이 없을 경우에는 부모로부터 왼쪽자식일 때까지 위로 올라감

	else {
		pSuccessor = _pNode;

		while (true)
		{
			//루트까지 올라갔을 경우
			if (pSuccessor->IsRoot())//pSuccessor은 pointer이므로 이렇게
				return nullptr;
			if (pSuccessor->IsLeftChild())//pSuccessor이 왼쪽 자식인지 확인하고 왼쪽자식이 맞으면 부모가 후속자
			{
				pSuccessor = pSuccessor->arrNode[(int)NODE_TYPE::PARNET];
				break;
			}
			else {// pSuccessor이 왼쪽 자식인지 확인하고 왼쪽자식이 아니면 부모쪽으로 다시 올라간다.
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
inline typename CBST<T1, T2>::iterator CBST<T1, T2>::begin()//중위 순회의 첫번째 즉, 맨 왼쪽 단말노드
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
	//end iterator는 nullptr을 가리키자고 약속했다.
	//그리고 찾고있는 노드가 없으면 end로 정의
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
		//찾았을 경우
		else break;
		//못 찾았을 경우
		if (nullptr == pNode->arrNode[(int)node_type])//찾는 노드가 없을 경우
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
	assert(this == _iter.m_pBST);//지금 iterator가 가리키는 트리와 _iter의 트리가 같은지 확인
	
	tBSTNode<T1, T2>* pSuccessor = DeleteNode(_iter.m_pNode);

	return iterator(this, pSuccessor);
}

template<typename T1, typename T2>
inline tBSTNode<T1, T2>* CBST<T1, T2>::DeleteNode(tBSTNode<T1, T2>* _pTargetNode)
{
	
	tBSTNode<T1, T2>* pSuccessor = GetInOrderSuccessor(_pTargetNode);
	//1. 자식이 하나도 없을 경우, 즉 단말 노드 일 때
	if (_pTargetNode.m_pNode->IsLeaf())
	{	//삭제시킬 노드의 후속자 노드를 찾아둔다.
		
		//삭제할 노드가 루트였다(자식이 없고 루트 ==> BST 안에 데이터가 1개 밖에 없었다)
		if (_pTargetNode == this->m_pRoot)//이 함수는 CBST 클래스에 속해있다. 
		{
			m_pRoot = nullptr;
		}
		else{


		//부모노드로 접근, 삭제될 작식 노드를 가리키는 포인터를 nullptr로 만든다.
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
		//데이터 개수 줄이기
		--m_iCount;
	}
	//2. 자식이 2개인 경우
	else if (_pTargetNode->IsFull())
		//삭제시 자리에 중위 후속자, 선행자 중 하나가 와도 무방하지만
		//여기서는 후속자가 올 수 있는것을 기준으로 한다.
	{
		//삭제될 자리에 중위 후속자의 값을 복사시킨다.
		_pTargetNode->pair = pSuccessor->pair;
		//중위 후속자의 노드를 삭제한다.
		DeleteNode(pSuccessor);

		pSuccessor = _pTargetNode;//반환 값으로 다음 노드를 줘야하므로
		return pSuccessor;
		//여기서는 노드를 삭제해 버리므로 --m_iCount;를 할필요가 없다 
		//왜냐하면 하나의 자식이 없어지므로 재귀호출을 하여 1,3번 Case에 걸리고 자동적으로 1,3번 중에서 한번  --m_iCount;을 하기 때문
	}
	//3. 자식이 1개인 경우
	else 
	{

		NODE_TYPE eChildType = NODE_TYPE::LCHILD;
		if (_pTargetNode->arrNode[(int)NODE_TYPE::RCHILD])//오른쪽 자식이 존재하면 오른쪽 자식을 가지고 있다고 인식하겠다(어차피 자식은 1개이므로)
			eChildType = NODE_TYPE::RCHILD;
		//삭제할 노드가 루트였다.
		if (_pTargetNode == m_pRoot)
		{
			//자식노드(1개)를 루트로 만든다.
			m_pRoot = _pTargetNode->arrNode[(int)eChildType];
			_pTargetNode->arrNode[(int)eChildType]->arrNode[(int)NODE_TYPE::PARNET] = nullptr;
		}
		else {
			//삭제될 노드의 부모와, 삭제될 노드의 자식을 연결해준다.
			if (_pTargetNode->IsLeftChild())
			{
				_pTargetNode->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::LCHILD] = _pTargetNode->arrNode[(int)eChildType];
				//타겟이 왼쪽 자식이면 타겟의 부모의 왼쪽을 타겟의 하나남은 자식으로 대체
			}

			else {
				_pTargetNode->arrNode[(int)NODE_TYPE::PARNET]->arrNode[(int)NODE_TYPE::RCHILD] = _pTargetNode->arrNode[(int)eChildType];
				//타겟이 왼쪽 자식이면 타겟의 부모의 왼쪽을 타겟의 하나남은 자식으로 대체
			}
			_pTargetNode->arrNode[(int)eChildType]->arrNode[(int)NODE_TYPE::PARNET] = _pTargetNode->arrNode[(int)NODE_TYPE::PARNET];
		}
		delete _pTargetNode;
			
			
			//삭제시킬 노드의 후속자 노드를 찾아둔다. 

		//데이터 개수 줄이기
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
//			else//중복키일 경우
//			{
//				return false;
//			}
//		}
//		++m_iCount;
//		return true;
//	}
//
