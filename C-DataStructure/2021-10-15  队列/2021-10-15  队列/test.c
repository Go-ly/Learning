#define _CRT_SECURE_NO_WARNINGS 1
#include "Queue.h"
void test()
{
	Queue queue;
	QueueInit(&queue);
	QueuePush(&queue, 1);
	QueuePush(&queue, 2);
	QueuePush(&queue, 3);
	QueuePush(&queue, 4);
	while (!QueueEmpty(&queue))
	{
		printf("%d ", QueueFront(&queue));
		QueuePop(&queue);
	}
	QueueDestroy(&queue);
}
int main()
{
	test();
	return 0;
}