#define _CRT_SECURE_NO_WARNINGS
#pragma once
#include <stdio.h> 
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

typedef char DataType;   // 顶点字母
enum GraphKind {      
	DG,    // 有向图
	DN,     // 有向网
	UDG,    //无向图
	UDN     //无向网
};

typedef struct Vertex {
	int adj;     // 无权图，用1或0表示是否相邻，带权图，则是权值

	            // 可以再加顶点的其他信息
}Vertex;

typedef struct ArcMatrix {
	Vertex** arr;       // 邻接矩阵
	DataType* ver;      // 存放顶点字母
	enum GraphKind kind;   // 图的种类flag
	int VertexNumber;     // 顶点数量
	int arcNum;           // 弧数量
}ArcMatrix;

int* visited;          // 各顶点访问状态
  
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





void ArcInit(ArcMatrix* ps);
void CreateArc(ArcMatrix* ps);
static void FillData(ArcMatrix* ps);   // 填充权值或者1/0
static void FillVexData(ArcMatrix* ps);  //填充顶点字母
static int FindVexIndex(ArcMatrix* ps, char v);
static void DepthFirstSearch(ArcMatrix* ps, int index);
void DepthFirstTraverseGraph(ArcMatrix* ps);
void PrintArcMatrix(ArcMatrix* ps);
void BreadthFirstTraverseGraph(ArcMatrix* ps, Queue* pq);
static void BreadthFirthSearch(ArcMatrix* ps, int index, Queue* pq);



void QueueInit(Queue* pq);
void QueueDestroy(Queue* pq);
void QueuePush(Queue* pq, QDatatype x);
void QueuePop(Queue* pq);
QDatatype QueueFront(Queue* pq);
bool QueueEmpty(Queue* pq);
