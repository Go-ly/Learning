#define _CRT_SECURE_NO_WARNINGS 1
#include "Stack.h"

void test1()
{
	Stack st;
	StackInit(&st);
	StackPush(&st, 1);
	StackPush(&st, 2);
	StackPush(&st, 3);
	StackPush(&st, 4);
	printf("%d \n", StackSize(&st));
}

int main()
{
	test1();
	return 0;
}