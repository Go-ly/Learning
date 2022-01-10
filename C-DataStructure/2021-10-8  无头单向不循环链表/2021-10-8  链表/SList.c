#define _CRT_SECURE_NO_WARNINGS 1
#include "SList.h"
void SListShow(const SListNode* plist)
{
	SListNode* cur = plist;
	while (cur != NULL)
	{
		printf("%d->", cur->data);
		cur = cur->next;
	}
	printf("NULL\n");
}

SListNode* CreateNode(SLTDataType x)
{
	SListNode* node = (SListNode*)malloc(sizeof(SListNode));
	if (node == NULL)
	{
		perror("malloc");
		exit(-1);
	}
	node->data = x;
	node->next = NULL;
	return node;
}

void SListPushBack(SListNode** pplist, SLTDataType x)
{	
	SListNode* node = CreateNode(x);
	if (*pplist == NULL)
	{
		*pplist = node;
	}
	else
	{
		SListNode* cur = *pplist;
		while (cur->next != NULL)
		{         //找尾结点
			cur = cur->next;
		}
		cur->next = node;
	}
}

void SListPushFront(SListNode** pplist, SLTDataType x)
{
	SListNode* node = CreateNode(x);
	node->next = *pplist;
	*pplist = node;
}

void SListPopBack(SListNode** pplist)
{
	if (*pplist == NULL)
	{
		return;
	}
	else if ((*pplist)->next == NULL)    //一个节点
	{
		free(*pplist);
		*pplist = NULL;
	}
	else
	{
		SListNode* prev = NULL;
		SListNode* cur = *pplist;
		while (cur->next != NULL)
		{
			prev = cur;
			cur = cur->next;
		}
		free(cur);
		cur = NULL;
		prev->next = NULL;
	}
}

void SListPopFront(SListNode** pplist)
{
	if (*pplist == NULL)
	{
		return;
	}
	else
	{
		SListNode* cur = *pplist;
		*pplist = (*pplist)->next;
		free(cur);
		cur = NULL;
	}
}

SListNode* SListFind(const SListNode* plist, SLTDataType x)
{
	while (plist)
	{
		if (plist->data == x)
		{
			return plist;
		}
		plist = plist->next;
	}
	return NULL;
}

void SListInsertAfter(const SListNode* plist, SLTDataType d, SLTDataType x)
{
	SListNode* pos = SListFind(plist, d);
	SListNode* newnode = CreateNode(x);
	newnode->next = pos->next;
	pos->next = newnode;
}

void SListInsertBefore(SListNode** pplist, SLTDataType d, SLTDataType x)
{
	SListNode* newnode = CreateNode(x);
	SListNode* cur = *pplist;
	SListNode* pos = SListFind(*pplist, d);
	if (pos == NULL)
	{
		return;
	}
	SListNode* prev = NULL;
	if (pos == *pplist)
	{
		*pplist = newnode;
		newnode->next = pos;
		return;
	}
	while (cur != pos)
	{
		prev = cur;
		cur = cur->next;
	}
	prev->next = newnode;
	newnode->next = pos;
}

void SListEraseAfter(const SListNode* plist, SLTDataType d)
{
	if (plist == NULL)
	{
		return;
	}
	SListNode* pos = SListFind(plist, d);
	assert(pos);
	SListNode* after = pos->next;
	pos->next = after->next;
	free(after);
	after = NULL;
}