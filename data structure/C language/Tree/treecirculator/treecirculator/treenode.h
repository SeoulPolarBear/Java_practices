#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct TreeNode {
	char name;
	int data; 
	struct TreeNode* left, * right;
} TreeNode;

typedef TreeNode* element;

typedef struct tag {
	element* data;
	int capacity;
	int top;
}StackType;

void init_stack(StackType* s);
int is_empty(StackType* s);
int is_full(StackType* s);
void push(StackType* s, element item);
element pop(StackType* s);

void set(TreeNode* node, char name, int data, TreeNode* lch, TreeNode* rch);
void add_child(TreeNode* node, TreeNode* child);
void print_tree(TreeNode* root, int level);
void print_node(TreeNode* node, int level);