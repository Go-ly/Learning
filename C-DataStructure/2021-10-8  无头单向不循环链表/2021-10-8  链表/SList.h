#define _CRT_SECURE_NO_WARNINGS 1
#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>


typedef int SLTDataType;

typedef struct SListNode
{
	SLTDataType data;
	struct SListNode* next;
}SListNode;
//单向不带头非循环链表




void SListPushBack(SListNode** pplist, SLTDataType x);       //尾插
void SListPushFront(SListNode** pplist, SLTDataType x);      //头插
void SListPopBack(SListNode** pplist);        //尾删
void SListPopFront(SListNode** pplist);       //头删
void SListShow(const SListNode* plist);                       //展示链表内容
SListNode* SListFind(const SListNode* plist, SLTDataType x);    //查找
void SListInsertAfter(const SListNode* plist, SLTDataType d, SLTDataType x);    //后面插入数据
void SListInsertBefore(SListNode** pplist, SLTDataType d, SLTDataType x);              //前面插入数据
void SListEraseAfter(const SListNode* plist, SLTDataType d);                   //删除d后面的结点