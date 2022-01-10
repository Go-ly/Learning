#include "test.h"
int main() {
	ArcMatrix arc;

	ArcInit(&arc);  

	// ≤‚ ‘
	CreateArc(&arc);
	PrintArcMatrix(&arc);
	//DepthFirstTraverseGraph(&arc);
	Queue queue;
	QueueInit(&queue);
	DepthFirstTraverseGraph(&arc);
	BreadthFirstTraverseGraph(&arc, &queue);
	return 0;
}