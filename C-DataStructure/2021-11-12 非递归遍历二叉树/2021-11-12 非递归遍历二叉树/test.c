#include "test.h"

int main() {
	BiTreeNode* BiTree;
	BiTreeCreate(&BiTree);
	Stack stack;
	StackInit(&stack);
	printf("非递归遍历二叉树\n");
	printf("先序遍历  ");
	BiTreePreOrder(BiTree, &stack);
	printf("\n");
	printf("中序遍历  ");
	BiTreeInOrder(BiTree, &stack);
	printf("\n");
	printf("后序遍历  ");
	BiTreePostOrder(BiTree, &stack);
	StackDestroy(&stack);
	return 0;
}