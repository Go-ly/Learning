#include "test.h"

// 栈中的功能
// 初始化一下
void StackInit(Stack* ps) {
	assert(ps != NULL);
	ps->arr = NULL;
	ps->capacity = 0;
	ps->top = 0;
}

// 销毁
void StackDestroy(Stack* ps) {
	assert(ps != NULL);
	free(ps->arr);
	ps->arr = NULL;
	ps->capacity = 0;
	ps->top = 0;
}

// 压栈
void StackPush(Stack* ps, BiTreeNode* x) {
	assert(ps != NULL);
	if (ps->capacity == ps->top) {
		// 栈满，扩容
		ps->capacity = ps->capacity ? 2 * ps->capacity : 4;
		BiTreeNode** ptr = (BiTreeNode**)realloc(ps->arr, sizeof(BiTreeNode*) * ps->capacity );
		if (ptr == NULL) {
			perror("Push->realloc");
			return;
		}
		ps->arr = ptr;
		ptr = NULL;
	}
	ps->arr[ps->top] = x;
	ps->top++;
}

// 出栈
void StackPop(Stack* ps) {
	assert(ps != NULL);
	assert(!StackEmpty(ps));
	ps->top--;
}

// 得到栈顶元素
BiTreeNode* StackTop(Stack* ps) {
	assert(ps != NULL);
	assert(!StackEmpty(ps));
	return ps->arr[ps->top - 1];
}

bool StackEmpty(Stack* ps) {
	assert(ps != NULL);
	if (ps->top == 0) {
		return true;
	}
	return false;
}



// 二叉树的一些功能
void BiTreeCreate(BiTreeNode** pps) {
	assert(pps != NULL);
	char ch = getchar();
	if (ch == '#') {
		*pps = NULL;
	}
	else {
		BiTreeNode* ptr = (BiTreeNode*)malloc(sizeof(BiTreeNode*));
		if (ptr == NULL) {
			perror("malloc");
			exit(-1);
		}
		*pps = ptr;
		ptr = NULL;
		(*pps)->data = ch;
		BiTreeCreate(&(*pps)->LChild);
		BiTreeCreate(&(*pps)->RChild);
	}
}


// 先序遍历
void BiTreePreOrder(const BiTreeNode* ps, Stack* pstack) {
	assert(ps != NULL);
	assert(pstack != NULL);
	BiTreeNode* ptr = (BiTreeNode*)ps;
	while (ptr != NULL || !StackEmpty(pstack)) {
		while (ptr != NULL) {
			printf("%c", ptr->data);    // 访问根之后是左孩子
			StackPush(pstack, ptr);
			ptr = ptr->LChild;
		}
		if (!StackEmpty(pstack)) {
			ptr = StackTop(pstack);
			StackPop(pstack);
			ptr = ptr->RChild;
		}
	}
}

// 中序遍历
void BiTreeInOrder(const BiTreeNode* ps, Stack* pstack) {
	assert(ps != NULL);
	assert(pstack != NULL);
	BiTreeNode* ptr = (BiTreeNode*)ps;
	while (ptr != NULL || !StackEmpty(pstack)) {
		while (ptr != NULL) {
			StackPush(pstack, ptr);
			ptr = ptr->LChild;
		}
		if (!StackEmpty(pstack)) {
			ptr = StackTop(pstack);
			StackPop(pstack);
			printf("%c", ptr->data);
			ptr = ptr->RChild;
		}
	}
}

// 后序遍历
void BiTreePostOrder(const BiTreeNode* ps, Stack* pstack) {
	assert(ps != NULL);
	assert(pstack != NULL);
	BiTreeNode* ptr = (BiTreeNode*)ps;
	BiTreeNode* root = NULL;   // 这个用来在后面判断这个根是不是第二次出现的
	while (ptr != NULL || !StackEmpty(pstack)) {
		while (ptr != NULL) {
			// 先找左
			StackPush(pstack ,ptr);
			ptr = ptr->LChild;
		}
		if (!StackEmpty(pstack)) {
			ptr = StackTop(pstack);
			if (ptr->RChild == NULL || ptr->RChild == root) {     //这个结点无右孩子或者右孩子已遍历
				printf("%c", ptr->data);
				root = ptr;
				StackPop(pstack);
				ptr = NULL;
			}
			else {
				ptr = ptr->RChild;
			}
		}
	}
}