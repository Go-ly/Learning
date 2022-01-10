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
	int adjvex;                 // 该弧指向节点的位置
	struct ArcNode* nextarc;    // 该指针指向下一条弧
	ArcInfo info;               // 是网的话就存权值，其他情况不用这个
}ArcNode;

typedef struct VertexNode {
	VertexData data;       // 顶点数据
	ArcNode* firstarc;      // 该顶点指向的第一条弧
}VertexNode;

typedef struct Arc {
	VertexNode* vertex;
	int vertexnumber;
	int arcnumber;
	enum GraphKind kind;
}Arc;
bool* visited;


// 关于队列
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
