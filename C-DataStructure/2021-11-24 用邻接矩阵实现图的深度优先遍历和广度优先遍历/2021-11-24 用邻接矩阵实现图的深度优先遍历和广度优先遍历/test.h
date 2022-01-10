#define _CRT_SECURE_NO_WARNINGS
#pragma once
#include <stdio.h> 
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

typedef char DataType;   // ������ĸ
enum GraphKind {      
	DG,    // ����ͼ
	DN,     // ������
	UDG,    //����ͼ
	UDN     //������
};

typedef struct Vertex {
	int adj;     // ��Ȩͼ����1��0��ʾ�Ƿ����ڣ���Ȩͼ������Ȩֵ

	            // �����ټӶ����������Ϣ
}Vertex;

typedef struct ArcMatrix {
	Vertex** arr;       // �ڽӾ���
	DataType* ver;      // ��Ŷ�����ĸ
	enum GraphKind kind;   // ͼ������flag
	int VertexNumber;     // ��������
	int arcNum;           // ������
}ArcMatrix;

int* visited;          // ���������״̬
  
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





void ArcInit(ArcMatrix* ps);
void CreateArc(ArcMatrix* ps);
static void FillData(ArcMatrix* ps);   // ���Ȩֵ����1/0
static void FillVexData(ArcMatrix* ps);  //��䶥����ĸ
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
