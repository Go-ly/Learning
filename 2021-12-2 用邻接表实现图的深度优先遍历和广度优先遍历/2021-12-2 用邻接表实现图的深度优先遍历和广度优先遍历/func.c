#include "test.h"

void ArcInit(Arc* pa) {
	assert(pa != NULL);
	printf("请输入图的顶点数:>");
	scanf("%d", &pa->vertexnumber);
	printf("请输入弧的数量:>");
	scanf("%d", &pa->arcnumber);
	printf("请输入图的种类\n");
	scanf("%d", &pa->kind);
	VertexNode* ptr = (VertexNode*)malloc(sizeof(VertexNode) * pa->vertexnumber);
	if (ptr == NULL) {
		perror("VertexNode:malloc");
		exit(-1);
	}
	pa->vertex = ptr;
	ptr = NULL;
	for (int i = 0; i < pa->vertexnumber; i++) {
		pa->vertex[i].firstarc = NULL;
	}
	printf("初始化完成\n");
}

void CreateArc(Arc* pa) {
	assert(pa != NULL);
	while ((getchar()) != '\n') {
		;
	}
	FillVexData(pa);
	// 先按照无向图来处理

	while ((getchar()) != '\n') {
		;
	}
	for (int i = 0; i < pa->arcnumber; i++) {
		FillArcData(pa);
	}
	printf("创建完成\n");
}

static void FillVexData(Arc* pa) {
	assert(pa != NULL);
	printf("请输入各顶点的代表字母:>");
	for (int i = 0; i < pa->vertexnumber; i++) {
		scanf("%c", &pa->vertex[i].data);
	}
}
static void FillArcData(Arc* pa) {
	assert(pa != NULL);
	VertexData v1;
	VertexData v2;
	char c;
	while ((c = getchar()) != '\n' && c != EOF);
	printf("请输入弧的相关信息(两个顶点及其他信息):>");
	scanf("%c%c", &v1, &v2);
	ArcNode* newnode = (ArcNode*)malloc(sizeof(ArcNode));
	if (newnode == NULL) {
		perror("ArcNode:malloc");
		exit(-1);
	}
	int i = FindVex(pa, v1);
	int j = FindVex(pa, v2);
	newnode->adjvex = j;
	newnode->nextarc = NULL;
	ArcNode* cur = pa->vertex[i].firstarc;
	if (cur != NULL) {
		while (cur->nextarc != NULL) {
			cur = cur->nextarc;
		}
		cur->nextarc = newnode;
	}
	else {
		cur = newnode;
		pa->vertex[i].firstarc = cur;
	}

	ArcNode* newnode2 = (ArcNode*)malloc(sizeof(ArcNode));
	if (newnode2 == NULL) {
		perror("ArcNode2:malloc");
		exit(-1);
	}
	newnode2->adjvex = i;
	newnode2->nextarc = NULL;
	cur = pa->vertex[j].firstarc;
	if (cur != NULL) {
		while (cur->nextarc != NULL) {
			cur = cur->nextarc;
		}
		cur->nextarc = newnode2;
	}
	else {
		cur = newnode2;
		pa->vertex[j].firstarc = cur;
	}
}

static int FindVex(Arc* pa, VertexData v) {
	assert(pa != NULL);
	for (int i = 0; i < pa->vertexnumber; i++) {
		if (pa->vertex[i].data == v) {
			return i;
		}
	}
	return -1;
}



void PrintArc(Arc* pa) {
	assert(pa != NULL);
	printf("构造的邻接表如下:>\n");
	ArcNode* cur;
	printf("\n");
	for (int i = 0; i < pa->vertexnumber; i++) {
		printf("%c->", pa->vertex[i].data);
		int index;
		cur = pa->vertex[i].firstarc;
		while (cur != NULL) {
			index = cur->adjvex;
			printf("%c->", pa->vertex[index].data);
			cur = cur->nextarc;
		}
		printf("\n");
	}
	printf("\n");
}

static void DepthFirthSearch(Arc* pa, int index) {
	assert(pa != NULL);
	// 先按无向图处理
	visit(pa, index);
	visited[index] = true;
	ArcNode* ptr = pa->vertex[index].firstarc;
	while (ptr != NULL) {
		if (!visited[ptr->adjvex]) {
			DepthFirthSearch(pa, ptr->adjvex);
		}
		ptr = ptr->nextarc;
	}
}

void DepthFirthTraverseGraph(Arc* pa) {
	assert(pa != NULL);
	printf("深度遍历结果如下\n");
	bool* ptr = malloc(sizeof(int) * pa->vertexnumber);
	if (ptr == NULL) {
		perror("visited:malloc");
		exit(-1);
	}
	visited = ptr;
	ptr = NULL;
	for (int i = 0; i < pa->vertexnumber; i++) {
		visited[i] = false;
	} 
	for (int i = 0; i < pa->vertexnumber; i++) {
		if (!visited[i]) {
			DepthFirthSearch(pa, i);
		}
	}
}

void visit(Arc* pa, int index) {
	assert(pa != NULL);
	printf("%c", pa->vertex[index].data);
}

static void BreadthFirstSearch(Arc* pa, int index, Queue* pq) {
	assert(pa != NULL);
	visit(pa, index);
	visited[index] = true;
	QueueInit(pq);
	QueuePush(pq, index);
	while (!QueueEmpty(pq)) {
		int i = QueueFront(pq);
		QueuePop(pq);
		int j = FirstAdjVertex(pa, i);
		while (j != -1) {
			if (!visited[j]) {
				visit(pa, j);
				visited[j] = true;
				QueuePush(pq, j);
			}
			j = NextAdjVertex(pa, i, j);
		}
	}
}

static int FirstAdjVertex(Arc* pa, int index) {
	assert(pa != NULL);
	if (pa->vertex[index].firstarc == NULL) {
		return -1;
	}
	return pa->vertex[index].firstarc->adjvex;
}

static int NextAdjVertex(Arc* pa, int index, int index2) {
	assert(pa != NULL);
	ArcNode* cur = pa->vertex[index].firstarc;
	while (cur != NULL) {
		if (cur->adjvex == index2 && cur->nextarc != NULL) {
			return cur->nextarc->adjvex;
		}
		cur = cur->nextarc;
	}
	return -1;
}

void BreadthFirstTraverseGraph(Arc* pa, Queue* pq) {
	assert(pa != NULL);
	printf("\n广度遍历结果如下\n");
	ArcNode* ptr = (ArcNode*)malloc(sizeof(ArcNode) * pa->vertexnumber);
	if (ptr == NULL) {
		perror("BFT:malloc");
		exit(-1);
	}
	visited = ptr;
	ptr = NULL;
	for (int i = 0; i < pa->vertexnumber; i++) {
		visited[i] = false;
	}
	for (int i = 0; i < pa->vertexnumber; i++) {
		if (!visited[i]) {
			BreadthFirstSearch(pa, i, pq);
		}
	}
}



// =============================
void QueueInit(Queue* pq)
{
	assert(pq);
	pq->head = NULL;
	pq->tail = NULL;
}

void QueuePush(Queue* pq, QDatatype x)
{
	assert(pq);
	QueueNode* newnode = (QueueNode*)malloc(sizeof(QueueNode));
	if (newnode == NULL)
	{
		perror("malloc");
		exit(-1);
	}
	newnode->data = x;
	newnode->next = NULL;
	if (pq->tail == NULL)
	{
		pq->head = newnode;
		pq->tail = newnode;
	}
	else
	{
		pq->tail->next = newnode;
		pq->tail = newnode;
	}
	pq->tail = newnode;
}

void QueuePop(Queue* pq)
{
	assert(pq);
	assert(!QueueEmpty(pq));
	if (pq->head->next == NULL)
	{
		free(pq->head);
		pq->head = NULL;
		pq->tail = NULL;
	}
	else {
		QueueNode* next = pq->head->next;
		free(pq->head);
		pq->head = next;
	}

}

QDatatype QueueFront(Queue* pq)
{
	assert(pq);
	assert(!QueueEmpty(pq));
	return pq->head->data;
}

bool QueueEmpty(Queue* pq)
{
	assert(pq);
	return pq->tail == NULL;
}