// 实现二叉链表， 用递归方式进行先序，中序，后序遍历
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
	if (ch == '#') {      // 这里用 # 来表示无孩子 
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

// 先序遍历
void BiTreePreOrder(const BiTreeNode* ps) {
	if (ps == NULL) {
		return;
	}
	BiTreeNodeVisit(ps);
	BiTreePreOrder(ps->LChild);
	BiTreePreOrder(ps->RChild);
}

// 中序遍历
void BiTreeInorder(const BiTreeNode* ps) {
	if (ps == NULL) {
		return;
	}
	BiTreeInorder(ps->LChild);
	BiTreeNodeVisit(ps);
	BiTreeInorder(ps->RChild);
}

// 后序遍历
void BiTreePostOrder(const BiTreeNode* ps) {
	if (ps == NULL) {
		return;
	}
	BiTreePostOrder(ps->LChild);
	BiTreePostOrder(ps->RChild);
	BiTreeNodeVisit(ps);
}

int main() {
	BiTreeNode* BiTree;   //创建一颗二叉树，此时为空树
	BiTreeCreate(&BiTree);    // 存入数据
	printf("递归遍历\n");
	printf("先序遍历  ");
	BiTreePreOrder(BiTree);
	printf("\n");
	printf("中序遍历  ");
	BiTreeInorder(BiTree);
	printf("\n");
	printf("后序遍历  ");
	BiTreePostOrder(BiTree);
	return 0;
}

