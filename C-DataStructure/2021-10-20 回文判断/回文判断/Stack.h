#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>
#define _CRT_SECURE_NO_WARNINGS 1


typedef char STDataType;
typedef struct Stack
{
	STDataType* arr;
	int top;          //��
	int capacity;     //����
}Stack;



void StackInit(Stack* ps);             //��ʼ��
void StackDestroy(Stack* ps);            //����
void StackPush(Stack* ps, STDataType x);    //��ջ
void StackPop(Stack* ps);             //��ջ
bool StackEmpty(Stack* ps);      //�����ж�ջ�Ƿ�Ϊ��
void StackIncrease(Stack* ps);    //��̬����