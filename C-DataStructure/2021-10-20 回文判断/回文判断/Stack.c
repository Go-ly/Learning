#include "Stack.h"
void StackInit(Stack* ps)
{
	assert(ps);
	ps->arr = NULL;
	ps->capacity = 0;
	ps->top = 0;
}

void StackDestroy(Stack* ps)
{
	assert(ps);
	free(ps->arr);
	ps->arr = NULL;
	ps->top = 0;
	ps->capacity = 0;
}

void StackIncrease(Stack* ps)
{
	assert(ps);
	if (ps->capacity == ps->top)
	{
		int newcapacity = (ps->capacity == 0) ? 4 : 2 * ps->capacity;
		STDataType* ptr = (STDataType*)realloc(ps->arr, sizeof(STDataType) * (newcapacity));
		if (ptr == NULL)
		{
			perror("realloc");
			exit(-1);
		}
		ps->arr = ptr;
		ptr = NULL;
		ps->capacity = newcapacity;
	}
}

void StackPush(Stack* ps, STDataType x)
{
	assert(ps);
	if (ps->capacity == ps->top)
	{
		StackIncrease(ps);
	}
	ps->arr[ps->top] = x;
	(ps->top)++;
}

bool StackEmpty(Stack* ps)
{
	assert(ps);
	return ps->top == 0;
}

void StackPop(Stack* ps)
{
	assert(ps);
	assert(!StackEmpty(ps));
	ps->top--;
}

