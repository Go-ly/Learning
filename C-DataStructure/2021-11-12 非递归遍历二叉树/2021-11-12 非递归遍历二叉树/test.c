#include "test.h"

int main() {
	BiTreeNode* BiTree;
	BiTreeCreate(&BiTree);
	Stack stack;
	StackInit(&stack);
	printf("�ǵݹ����������\n");
	printf("�������  ");
	BiTreePreOrder(BiTree, &stack);
	printf("\n");
	printf("�������  ");
	BiTreeInOrder(BiTree, &stack);
	printf("\n");
	printf("�������  ");
	BiTreePostOrder(BiTree, &stack);
	StackDestroy(&stack);
	return 0;
}