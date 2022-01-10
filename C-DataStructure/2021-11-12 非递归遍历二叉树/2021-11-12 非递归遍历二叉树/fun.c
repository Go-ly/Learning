#include "test.h"

// ջ�еĹ���
// ��ʼ��һ��
void StackInit(Stack* ps) {
	assert(ps != NULL);
	ps->arr = NULL;
	ps->capacity = 0;
	ps->top = 0;
}

// ����
void StackDestroy(Stack* ps) {
	assert(ps != NULL);
	free(ps->arr);
	ps->arr = NULL;
	ps->capacity = 0;
	ps->top = 0;
}

// ѹջ
void StackPush(Stack* ps, BiTreeNode* x) {
	assert(ps != NULL);
	if (ps->capacity == ps->top) {
		// ջ��������
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

// ��ջ
void StackPop(Stack* ps) {
	assert(ps != NULL);
	assert(!StackEmpty(ps));
	ps->top--;
}

// �õ�ջ��Ԫ��
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



// ��������һЩ����
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


// �������
void BiTreePreOrder(const BiTreeNode* ps, Stack* pstack) {
	assert(ps != NULL);
	assert(pstack != NULL);
	BiTreeNode* ptr = (BiTreeNode*)ps;
	while (ptr != NULL || !StackEmpty(pstack)) {
		while (ptr != NULL) {
			printf("%c", ptr->data);    // ���ʸ�֮��������
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

// �������
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

// �������
void BiTreePostOrder(const BiTreeNode* ps, Stack* pstack) {
	assert(ps != NULL);
	assert(pstack != NULL);
	BiTreeNode* ptr = (BiTreeNode*)ps;
	BiTreeNode* root = NULL;   // ��������ں����ж�������ǲ��ǵڶ��γ��ֵ�
	while (ptr != NULL || !StackEmpty(pstack)) {
		while (ptr != NULL) {
			// ������
			StackPush(pstack ,ptr);
			ptr = ptr->LChild;
		}
		if (!StackEmpty(pstack)) {
			ptr = StackTop(pstack);
			if (ptr->RChild == NULL || ptr->RChild == root) {     //���������Һ��ӻ����Һ����ѱ���
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