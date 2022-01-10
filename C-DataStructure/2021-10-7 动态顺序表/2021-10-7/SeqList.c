#define _CRT_SECURE_NO_WARNINGS 1
#include "SeqList.h"


void SeqListInit(SeqList* ps)
{
	assert(ps != NULL);
	ps->a = NULL;
	ps->capacity = 0;
	ps->size = 0;
}

void SeqListDestroy(SeqList* ps)
{
	assert(ps != NULL);
	free(ps->a);
	ps->a = NULL;
	ps->capacity = 0;
	ps->size = 0;
}

static void SeqListCheck(SeqList* ps)
{
	assert(ps);
	if (ps->capacity == ps->size)
	{
		int newcapacity = (ps->capacity == 0) ? 4 : 2 * ps->capacity;
		SeqDataType* newA = (SeqDataType*)realloc(ps->a, sizeof(SeqDataType) * newcapacity);
		if (newA == NULL)
		{
			perror("realloc");
			exit(-1);
		}
		ps->capacity = newcapacity;
		ps->a = newA;
		newA = NULL;
	}
}
void SeqListPushBack(SeqList* ps, SeqDataType x)
{
	//assert(ps);
	//SeqListCheck(ps);
	//ps->a[ps->size] = x;
	//ps->size++;
	SeqListInsert(ps, ps->size, x);
}
void SeqListShow(SeqList* ps)
{
	assert(ps);
	for (int i = 0; i < ps->size; i++)
	{
		printf("%d ", ps->a[i]);
	}
	printf("\n");
}

void SeqListPushFront(SeqList* ps, SeqDataType x)
{
	//assert(ps);
	//SeqListCheck(ps);
	//int end = ps->size - 1;	
	//while (end >= 0)
	//{
	//	ps->a[end + 1] = ps->a[end];
	//	end--;
	//}
	//ps->a[0] = x;
	//ps->size++;
	SeqListInsert(ps, 0, x);
}

void SeqListPopBack(SeqList* ps)
{
	//assert(ps);
	//assert(ps->size > 0);
	//--(ps->size);
	SeqListErase(ps, ps->size - 1);
}

void SeqListPopFront(SeqList* ps)
{
	//assert(ps);
	//assert(ps->size > 0);
	//int front = 0;
	//while (front < ps->size - 1)
	//{
	//	ps->a[front] = ps->a[front + 1];
	//	front++;
	//}
	//ps->size--;
	SeqListErase(ps, 0);
}

int SeqListFind(SeqList* ps, SeqDataType x)
{
	assert(ps);
	for (int i = 0; i < ps->size; i++)
	{
		if (ps->a[i] == x)
		{
			return i;
		}
	}
	return -1;
}

void SeqListInsert(SeqList* ps, int pos, SeqDataType x)
{
	assert(ps);
	assert(pos >= 0 && pos <= ps->size);
	SeqListCheck(ps);
	int end = ps->size - 1;
	while (end >= pos)
	{
		ps->a[end + 1] = ps->a[end];
		end--;
	}
	ps->a[pos] = x;
	ps->size++;
}

void SeqListErase(SeqList* ps, int pos)
{
	assert(ps);
	assert(pos >= 0 && pos < ps->size);
	//int begin = pos;
	while (pos < ps->size)
	{
		ps->a[pos] = ps->a[pos + 1];
		pos++;
	}
	ps->size--;
}

void SeqListModify(SeqList* ps, int pos, SeqDataType x)
{
	assert(ps);
	assert(pos >= 0 && pos <= ps->size);
	ps->a[pos] = x;
}