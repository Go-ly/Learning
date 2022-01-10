#define _CRT_SECURE_NO_WARNINGS 1
#include "list.h"

ListNode* CreateNode(LTDataType x)
{
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	if (node == NULL)
	{
		perror("malloc");
		exit(-1);
	}
	node->prev = NULL;
	node->next = NULL;
	node->data = x;
	return node;
}

ListNode* ListInit()
{
	ListNode* phead = CreateNode(0);
	phead->prev = phead;
	phead->next = phead;
	return phead;
}

void ListShow(ListNode* phead)
{
	ListNode* cur = phead->next;
	while (cur != phead)
	{
		printf("%d->", cur->data);
		cur = cur->next;		
	}
		printf("NULL\n");
}

void ListPushBack(ListNode* phead, LTDataType x)
{
	assert(phead);
	ListNode* tail = phead->prev;
	ListNode* newnode = CreateNode(x);
	tail->next = newnode;
	newnode->prev = tail;
	phead->prev = newnode;
	newnode->next = phead;
}

void ListPushFront(ListNode* phead, LTDataType x)
{
	assert(phead);
	ListNode* newnode = CreateNode(x);
	if (phead->next == phead)
	{
		phead->prev = newnode;
		newnode->next = phead;
	}
	newnode->next = phead->next;
	phead->next->prev = newnode;
	phead->next = newnode;
	newnode->prev = phead;
}
void ListPopBack(ListNode* phead)
{
	assert(phead);
	if (phead->next == phead)
	{
		return;
	}
	ListNode* tail = phead->prev;
	tail->prev->next = phead;
	phead->prev = tail->prev;
	free(tail);
	tail = NULL;
}

void ListPopFront(ListNode* phead)
{
	assert(phead);
	if (phead->next == phead)
	{
		return;
	}
	ListNode* front = phead->next;
	phead->next = front->next;
	front->next->prev = phead;
	free(front);
	front = NULL;
}

ListNode* ListFind(ListNode* phead, LTDataType x)
{
	ListNode* cur = phead->next;
	while (cur != phead)
	{
		if (cur->data == x)
		{
			return cur;      //找到了，返回这个指针
		}
		cur = cur->next;
	}
		return NULL;     //找不到，返回空指针
}

void ListInsertBefore(ListNode* phead, LTDataType num, LTDataType x)
{
	assert(phead);
	ListNode* pos = ListFind(phead, num);
	if (pos == NULL)
	{
		printf("这个数字不存在\n");
		return;
	}
	ListNode* newnode = CreateNode(x);
	ListNode* prev = pos->prev;
	prev->next = newnode;
	newnode->prev = prev;
	newnode->next = pos;
	pos->prev = newnode;
}

void ListErase(ListNode* phead, LTDataType x)
{
	assert(phead);
	ListNode* pos = ListFind(phead, x);
	if (pos == phead || pos == NULL)
	{
		printf("这个数字不存在\n");
		return;
	}
	ListNode* prev = pos->prev;
	ListNode* next = pos->next;
	prev->next = next;
	next->prev = prev;
	free(pos);
	pos = NULL;
}