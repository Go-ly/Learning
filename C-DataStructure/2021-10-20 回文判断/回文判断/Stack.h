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
	int top;          //顶
	int capacity;     //容量
}Stack;



void StackInit(Stack* ps);             //初始化
void StackDestroy(Stack* ps);            //销毁
void StackPush(Stack* ps, STDataType x);    //入栈
void StackPop(Stack* ps);             //出栈
bool StackEmpty(Stack* ps);      //用来判断栈是否为空
void StackIncrease(Stack* ps);    //动态扩容