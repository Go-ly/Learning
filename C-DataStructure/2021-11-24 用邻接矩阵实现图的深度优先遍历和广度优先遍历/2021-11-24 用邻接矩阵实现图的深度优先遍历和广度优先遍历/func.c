#include "test.h"

void ArcInit(ArcMatrix* ps) {
	assert(ps != NULL);
	printf("请输入图的顶点个数:>");
	scanf("%d", &ps->VertexNumber);
	printf("输入图的种类:>");
	scanf("%d", &ps->kind);
	printf("输入顶点弧数量:>");
	scanf("%d", &ps->arcNum);
	if (ps->kind == DG) {
		printf("这是一个有向图\n");
	}
	if (ps->kind == DN) {
		printf("这是一个有向网\n");
	}
	if (ps->kind == UDN) {
		printf("这是一个无向网\n");
	}
	if (ps->kind == UDG) {
		printf("这是一个无向图\n");
	}
	Vertex** pptr = (Vertex**)malloc(sizeof(Vertex*) * ps->VertexNumber);
	if (pptr == NULL) {
		perror("Vertex**_malloc");
		exit(-1);
	}
	ps->arr = pptr;
	pptr = NULL;
	for (int i = 0; i < ps->VertexNumber; i++) {
		Vertex* p = (Vertex*)malloc(sizeof(Vertex) * ps->VertexNumber);
		if (p == NULL) {
			perror("Vertex*_malloc");
			exit(-1);
		}
		ps->arr[i] = p;
		p = NULL;
	}
	if (ps->kind == DG || ps->kind == UDG) {
		for (int i = 0; i < ps->VertexNumber; i++) {
			for (int j = 0; j < ps->VertexNumber; j++) {
				ps->arr[i][j].adj = 0;
			}
		}
	}
	if (ps->kind == DN || ps->kind == UDN) {
		for (int i = 0; i < ps->VertexNumber; i++) {
			for (int j = 0; j < ps->VertexNumber; j++) {
				ps->arr[i][j].adj = 0;
			}
		}
	}

	for (int i = 0; i < ps->VertexNumber; i++) {
		DataType* pt = (DataType*)malloc(sizeof(DataType) * ps->VertexNumber);
		if (pt == NULL) {
			perror("ver:malloc");
			exit(-1);
		}
		ps->ver = pt;
		pt = NULL;
	}
	printf("初始化完成\n");
	//初始化完毕
}

void CreateArc(ArcMatrix* ps) {
	assert(ps != NULL);
	// 清空键盘缓冲区
	while ((getchar()) != '\n') {
		;
	}
	printf("键盘缓冲区已清空!!!\n");
	//各顶点的字母输入
	FillVexData(ps);

	while ((getchar()) != '\n') {
		;
	}
	printf("键盘缓冲区已清空!!!\n");
	for (int k = 0; k < ps->arcNum; k++) {
		FillData(ps);
	}
	printf("创建完成\n");
}

static void FillVexData(ArcMatrix* ps) {
	assert(ps != NULL);
	printf("请输入各顶点的字母:>\n");
	for (int i = 0; i < ps->VertexNumber; i++) {
		ps->ver[i] = getchar();
	}
}

static void FillData(ArcMatrix* ps) {
	assert(ps != NULL);
	// 图和网分开处理
	char v1;
	char v2;
	int weight;
	if (ps->kind == DG || ps->kind == UDG) {
		printf("请输入一条弧的两个顶点:>");
		
		scanf("%c%c", &v1, &v2);
		while ((getchar()) != '\n') {
			;
		}
		int i = FindVexIndex(ps, v1);
		int j = FindVexIndex(ps, v2);
		ps->arr[i][j].adj = 1;
		if (ps->kind == UDG) {
			ps->arr[j][i].adj = 1;
		}
	} else {
		printf("请输入一条弧的两个顶点及权值(空格隔开):>");
		scanf("%c %c %d", &v1, &v2, &weight);
		while ((getchar()) != '\n') {
			;
		}
		int i = FindVexIndex(ps, v1);
		int j = FindVexIndex(ps, v2);
		ps->arr[i][j].adj = weight;
		if (ps->kind == UDN) {
			ps->arr[j][i].adj = weight;
		}
	}
}

static int FindVexIndex(ArcMatrix* ps, char v) {
	assert(ps != NULL);
	int ret = 0;
	for (int i = 0; i < ps->VertexNumber; i++) {
		if (ps->ver[i] == v) {
			ret = i;
			break;
		}
	}
	return ret;
}

static void visit(ArcMatrix* ps, int index) {
	assert(ps != NULL);
	printf("%c", ps->ver[index]);
}

// 深度遍历v所在的连通子图
static void DepthFirstSearch(ArcMatrix* ps, int index) {
	assert(ps != NULL);
	visit(ps, index);
	visited[index] = true;
	for (int j = 0; j < ps->VertexNumber; j++) {
		if (!visited[j] && ps->arr[index][j].adj == 1) {
			DepthFirstSearch(ps, j);
		}
	}
}

void DepthFirstTraverseGraph(ArcMatrix* ps) {
	assert(ps != NULL);
	printf("\n深度遍历结果为:>\n");
	visited = (int*)malloc(sizeof(int) * ps->VertexNumber);
	if (visited == NULL) {
		perror("visited:malloc");
		exit(-1);
	}
	for (int i = 0; i < ps->VertexNumber; i++) {
		visited[i] = false;
	}
	for (int i = 0; i < ps->VertexNumber; i++) {
		if (!visited[i]) {
			DepthFirstSearch(ps, i);
		}
	}
	free(visited);
	visited = NULL;
}

void PrintArcMatrix(ArcMatrix* ps) {
	assert(ps != NULL);
	printf("构造的邻接矩阵如下\n");
	printf("   ");
	for (int i = 0; i < ps->VertexNumber; i++) {
		printf(" %c  ", ps->ver[i]);
	}
	printf("\n\n");
	for (int i = 0; i < ps->VertexNumber; i++) {
		printf("%c   ", ps->ver[i]);
		for (int j = 0; j < ps->VertexNumber; j++) {
			printf("%d   ", ps->arr[i][j].adj);
		}
		printf("\n");
		printf("\n");
	}
}

void BreadthFirstTraverseGraph(ArcMatrix* ps, Queue* pq) {
	assert(ps != NULL);
	printf("\n广度优先遍历结果为\n");
	visited = (int*)malloc(sizeof(int) * ps->VertexNumber);
	if (visited == NULL) {
		perror("visited:malloc");
		exit(-1);
	}
	for (int i = 0; i < ps->VertexNumber; i++) {
		visited[i] = false;
	}
	for (int i = 0; i < ps->VertexNumber; i++) {
		if (!visited[i]) {
			BreadthFirthSearch(ps, i, pq);
		}
	}
}

static void BreadthFirthSearch(ArcMatrix* ps, int index, Queue* pq) {
	assert(ps != NULL);
	visit(ps, index);
	visited[index] = true;
	QueueInit(pq);
	QueuePush(pq, index);
	while (!QueueEmpty(pq)) {
		int i = QueueFront(pq);
		QueuePop(pq);
		int j = FirsrAdjVertex(ps, i);
		while (j != -1) {
			if (!visited[j]) {
				visit(ps, j);
				visited[j] = true;
				QueuePush(pq, j);
			}
			j = NextAdjVertex(ps, i, j);
		}
	}
}

static int FirsrAdjVertex(ArcMatrix* ps, int i) {
	assert(ps != NULL);
	if (ps->kind == DG || ps->kind == DN) {
		for (int j = 0; j < ps->VertexNumber; j++) {
				if (ps->arr[i][j].adj != 0) {
					return j;
				}
		}
	}
	else {
		for (int j = 0; j < ps->VertexNumber; j++) {
			if (ps->arr[i][j].adj != 0 || ps->arr[j][i].adj != 0) {
				return j;
			}
		}
	}
	return -1;
}

static int NextAdjVertex(ArcMatrix* ps, int i, int j) {
	assert(ps != NULL);
	for (int k = j + 1; k < ps->VertexNumber; k++) {
		if (ps->arr[i][k].adj != 0 || ps->arr[k][i].adj != 0) {
			return k;
		}
	}
	return -1;
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