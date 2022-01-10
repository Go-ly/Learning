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

// 栈中的元素
typedef struct Stack {
	BiTreeNode** arr;
	int top;
	int capacity;
}Stack;


// 栈相关的函数
void StackInit(Stack* ps);
void StackDestroy(Stack* ps);
void StackPush(Stack* ps, BiTreeNode* x);
void StackPop(Stack* ps);
BiTreeNode* StackTop(Stack* ps);   // 得到栈顶的数据
bool StackEmpty(Stack* ps);         // 检查栈是不是空的



// 二叉链表相关的函数
void BiTreeCreate(BiTreeNode** pps);
void BiTreePreOrder(const BiTreeNode* ps, Stack* pstack);
void BiTreeInOrder(const BiTreeNode* ps, Stack* pstack);
void BiTreePostOrder(const BiTreeNode* ps, Stack* pstack);