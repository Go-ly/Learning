#include <stdio.h> 
#include <stdlib.h> 
#include <assert.h>
#include <stdbool.h>

typedef char DataType;
typedef struct BiTreeNode {
	DataType data;
	struct BiTreeNode* LChild;
	struct BiTreeNode* RChild;
}BiTreeNode;

// ջ�е�Ԫ��
typedef struct Stack {
	BiTreeNode** arr;
	int top;
	int capacity;
}Stack;


// ջ��صĺ���
void StackInit(Stack* ps);
void StackDestroy(Stack* ps);
void StackPush(Stack* ps, BiTreeNode* x);
void StackPop(Stack* ps);
BiTreeNode* StackTop(Stack* ps);   // �õ�ջ��������
bool StackEmpty(Stack* ps);         // ���ջ�ǲ��ǿյ�



// ����������صĺ���
void BiTreeCreate(BiTreeNode** pps);
void BiTreePreOrder(const BiTreeNode* ps, Stack* pstack);
void BiTreeInOrder(const BiTreeNode* ps, Stack* pstack);
void BiTreePostOrder(const BiTreeNode* ps, Stack* pstack);