// ʵ�ֶ������� �õݹ鷽ʽ�����������򣬺������
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
typedef char DataType;
typedef struct BiTreeNode {
	DataType data;
	struct BiTreeNode* LChild;
	struct BiTreeNode* RChild;
}BiTreeNode;

void BiTreeCreate(BiTreeNode** pps) {
	assert(pps != NULL);
	char ch;
	ch = getchar();
	if (ch == '#') {      // ������ # ����ʾ�޺��� 
		*pps = NULL;
	}
	else {
		BiTreeNode* ptr = (BiTreeNode*)malloc(sizeof(BiTreeNode));
		if (ptr == NULL) {
			perror("malloc");
			exit(-1);
		}
		*pps = ptr;
		ptr = NULL;
		(*pps)->data = ch;
		BiTreeCreate(&((*pps)->LChild));
		BiTreeCreate(&((*pps)->RChild));
	}
}

void BiTreeNodeVisit(const BiTreeNode* ps) {
	printf("%c", ps->data);
}

// �������
void BiTreePreOrder(const BiTreeNode* ps) {
	if (ps == NULL) {
		return;
	}
	BiTreeNodeVisit(ps);
	BiTreePreOrder(ps->LChild);
	BiTreePreOrder(ps->RChild);
}

// �������
void BiTreeInorder(const BiTreeNode* ps) {
	if (ps == NULL) {
		return;
	}
	BiTreeInorder(ps->LChild);
	BiTreeNodeVisit(ps);
	BiTreeInorder(ps->RChild);
}

// �������
void BiTreePostOrder(const BiTreeNode* ps) {
	if (ps == NULL) {
		return;
	}
	BiTreePostOrder(ps->LChild);
	BiTreePostOrder(ps->RChild);
	BiTreeNodeVisit(ps);
}

int main() {
	BiTreeNode* BiTree;   //����һ�Ŷ���������ʱΪ����
	BiTreeCreate(&BiTree);    // ��������
	printf("�ݹ����\n");
	printf("�������  ");
	BiTreePreOrder(BiTree);
	printf("\n");
	printf("�������  ");
	BiTreeInorder(BiTree);
	printf("\n");
	printf("�������  ");
	BiTreePostOrder(BiTree);
	return 0;
}

