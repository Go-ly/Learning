#pragma once
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

enum GraphKind {
	DN, 
	DG, 
	UDN,
	UDG
};

typedef int ArcInfo;
typedef char VertexData;

typedef struct ArcNode {
	int adjvex;                 // �û�ָ��ڵ��λ��
	struct ArcNode* nextarc;    // ��ָ��ָ����һ����
	ArcInfo info;               // �����Ļ��ʹ�Ȩֵ����������������
}ArcNode;

typedef struct VertexNode {
	VertexData data;       // ��������
	ArcNode* firstarc;      // �ö���ָ��ĵ�һ����
}VertexNode;

typedef struct Arc {
	VertexNode* vertex;
	int vertexnumber;
	int arcnumber;
	enum GraphKind kind;
}Arc;
bool* visited;


// ���ڶ���
typedef int QDatatype;
typedef struct QueueNode
{
	QDatatype data;
	struct QueueNode* next;
}QueueNode;

typedef struct Queue
{
	QueueNode* head;
	QueueNode* tail;
}Queue;




void ArcInit(Arc* pa);
void CreateArc(Arc* pa);
static void FillVexData(Arc* pa);
static void FillArcData(Arc* pa);
static int FindVex(Arc* pa, VertexData v);
void PrintArc(Arc* pa);
static void DepthFirthSearch(Arc* pa, int index);
void visit(Arc* pa, int index);
void DepthFirthTraverseGraph(Arc* pa);
void BreadthFirstTraverseGraph(Arc* pa, Queue* pq);
static void BreadthFirstSearch(Arc* pa, int index, Queue* pq);
static int FirstAdjVertex(Arc* pa, int index);
static int NextAdjVertex(Arc* pa, int index, int index2);



void QueueInit(Queue* pq);
void QueuePush(Queue* pq, QDatatype x);
void QueuePop(Queue* pq);
QDatatype QueueFront(Queue* pq);
bool QueueEmpty(Queue* pq);
