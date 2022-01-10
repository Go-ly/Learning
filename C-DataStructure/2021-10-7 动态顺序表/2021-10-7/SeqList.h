#define _CRT_SECURE_NO_WARNINGS 1
#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

//��̬˳���
//#define N 100
//struct SeqList
//{
//	int arr[N];
//	int size;    //��Ч����
//};


//��̬˳���
typedef int SeqDataType;
typedef struct SeqList
{
	SeqDataType* a;
	int size;   //��Ч���ݸ���
	int capacity;    //����
}SeqList;






void SeqListInit(SeqList* ps);
void SeqListDestroy(SeqList* ps);
void SeqListShow(SeqList* ps);
void SeqListPushBack(SeqList* ps, SeqDataType x);
void SeqListPushFront(SeqList* ps, SeqDataType x);
void SeqListPopBack(SeqList* ps);
void SeqListPopFront(SeqList* ps);
void SeqListCheck(SeqList* ps);
int SeqListFind(SeqList* ps, SeqDataType x);
void SeqListInsert(SeqList* ps, int pos, SeqDataType x);
void SeqListErase(SeqList* ps, int pos);
void SeqListModify(SeqList* ps, int pos, SeqDataType x);