#define _CRT_SECURE_NO_WARNINGS 1

#include "Stack.h"

void StackInit(Stack* ps)
{
	assert(ps);
	//ps->arr = NULL;
	//ps->capacity = 0;
	//ps->top = 0;

	ps->arr = malloc(sizeof(Stack) * 4);
	ps->top = 0;
	ps->capacity = 4;
}

void StackDestroy(Stack* ps)
{
	assert(ps);
	free(ps->arr);
	ps->arr = NULL;
	ps->capacity = 0;
	ps->top = 0;
}

void StackPush(Stack* ps, STDataType x)
{
	assert(ps);
	if (ps->capacity == ps->top)
	{
		Stack* ptr = (Stack*)realloc(ps->arr, sizeof(Stack)* ps->capacity * 2);
		if (ptr == NULL)
		{
			perror("realloc");
			exit(-1);  //结束当前程序
		}
		ps->arr = ptr;
		ptr = NULL;
		ps->capacity = ps->capacity * 2;

	}
	ps->arr[ps->top] = x;
	ps->top++;
}

void StackPop(Stack* ps)
{
	assert(ps);
	assert(!StackEmpty(ps));
	ps->top--;
}

STDataType StackTop(Stack* ps)
{
	assert(ps);
	assert(!StackEmpty(ps));
	return ps->arr[ps->top - 1];
}

bool StackEmpty(Stack* ps)
{
	assert(ps);
	return ps->top == 0;
}

int StackSize(Stack* ps)
{
	assert(ps);
	return ps->top;
}