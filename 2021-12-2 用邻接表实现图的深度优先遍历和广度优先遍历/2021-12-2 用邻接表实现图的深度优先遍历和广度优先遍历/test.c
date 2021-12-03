#include "test.h"

int main() {
	Arc arc;
	ArcInit(&arc);
	
	CreateArc(&arc);
	//for (int i = 0; i < arc.vertexnumber; i++) {
	//	printf("%c", arc.vertex[i].data);
	//}
	PrintArc(&arc);
	DepthFirthTraverseGraph(&arc);
	Queue queue;
	QueueInit(&queue);
	BreadthFirstTraverseGraph(&arc, &queue);



	return 0;
}