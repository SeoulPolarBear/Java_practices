#include "treenode.h"

int eval(TreeNode* root);
void print_tree(TreeNode* root, int level);
void inorder(TreeNode* root);
void preorder(TreeNode* root);
TreeNode* new_node(char ch);
int isdigit(ch);

TreeNode* construct_tree(char* input)
{
	TreeNode* lnode, * rnode, * parent;
	char ch;
	int index = 0;
	StackType* stack = (StackType*)malloc(sizeof(StackType));
	init_stack(stack);
	while ((ch = input[index++]) != '\0') {  // "94-385%+*435+2*++";
		if (ch >= '0' && ch <= '9')
			parent = new_node(ch);
		else {
			parent = new_node(ch);
			rnode = pop(stack);
			lnode = pop(stack);
			add_child(parent, lnode);
			add_child(parent, rnode);
		}
		push(stack, parent);
		//print_tree(parent, 0);
	}
	return pop(stack);// ���������� ��Ʈ�� pop�ϰ� �ȴ�.
}
int main()
{
	char input[50];
	scanf("%s", input);//94-385%+*435+2*++
	TreeNode* root = construct_tree(input);//test �Է����� ����
	printf("�Է�: %s\n\nƮ�� ���\n", input);
	/*printf("%d", root->right->right->right->data);*/
	eval(root);
	print_tree(root, 0);// ����� ���� ���� ����� �ǰ� �ؾ��Ѵ�
	printf("\n����ǥ���: ");// ��ȸ �˰����� ����� ����
	inorder(root);//inorder ���
	printf("\n����ǥ���: ");
	preorder(root);//preorder ���
	printf("\n");
	system("pause");
}

int eval(TreeNode* root) {
	/*printf("%c\n", root->name);*/
	if (!isdigit(root->name)) {
		return root->data;
	}

	else {
		switch (root->name) {
		case '+':
			root->data = eval(root->left) + eval(root->right);
			break;
		case '-':
			root->data = eval(root->left) - eval(root->right);
			break;
		case '%':
			if (eval(root->right) == 0) {
				printf("ERROR tree nodes %c ", root->name);
				exit(1);
			}
			else root->data = eval(root->left) % eval(root->right);
			break;
		case '*':
			root->data = eval(root->left) * eval(root->right);
			break;
		case '/':
			if (eval(root->right) == 0) {
				printf("ERROR tree nodes %c ", root->name);
				exit(1);
			}
			else root->data = eval(root->left) / eval(root->right);
			break;
		}

		return root->data;
	}
}


void print_tree(TreeNode* root, int level) {
	if (!isdigit(root->name)) {
		for (int i = 0; i < level; i++) {
			printf("... ");
		}
		printf("%d\n", root->data);
	}
	else {
		for (int i = 0; i < level; i++) {
			printf("... ");
		}
		level++;
		printf("%c(%d)\n", root->name, root->data);
		print_tree(root->left, level);
		print_tree(root->right, level);
	}
}

void inorder(TreeNode* root) {
	if (!isdigit(root->name)) {
		printf("%c", root->name);
	}
	else
	{
		printf("(");
		inorder(root->left);
		printf("%c", root->name);
		inorder(root->right);
		printf(")");
	}

}
void preorder(TreeNode* root) {
	if (!isdigit(root->name)) {
		printf("%c", root->name);
	}
	else
	{
		printf("(");
		printf("%c", root->name);
		preorder(root->left);
		preorder(root->right);
		printf(")");
	}
}

TreeNode* new_node(char ch)
{
	int data = 0;
	TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
	if (!isdigit(ch))
		data = ch - '0';
	set(node, ch, data, NULL, NULL);
	return node;
}

/*int is_op(char ch)
{*/
	//char ops[] = "+-*/%";
	/*for (int i = 0; i < 5; i++)
		if (ch == ops[i])
			return 1;
	return 0;
}*/

int isdigit(ch) {
	if (ch >= '0' && ch <= '9')
		return 0;
	else if (ch == '+' || ch == '-' || ch == '*' || ch == ' /' || ch == '%')
		return 1;
	else return 1;
}