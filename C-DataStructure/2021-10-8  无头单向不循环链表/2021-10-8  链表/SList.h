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
//���򲻴�ͷ��ѭ������




void SListPushBack(SListNode** pplist, SLTDataType x);       //β��
void SListPushFront(SListNode** pplist, SLTDataType x);      //ͷ��
void SListPopBack(SListNode** pplist);        //βɾ
void SListPopFront(SListNode** pplist);       //ͷɾ
void SListShow(const SListNode* plist);                       //չʾ��������
SListNode* SListFind(const SListNode* plist, SLTDataType x);    //����
void SListInsertAfter(const SListNode* plist, SLTDataType d, SLTDataType x);    //�����������
void SListInsertBefore(SListNode** pplist, SLTDataType d, SLTDataType x);              //ǰ���������
void SListEraseAfter(const SListNode* plist, SLTDataType d);                   //ɾ��d����Ľ��