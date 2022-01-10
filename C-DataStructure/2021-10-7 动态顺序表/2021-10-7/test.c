#define _CRT_SECURE_NO_WARNINGS 1
#include "SeqList.h"
void test1()
{
	SeqList s;
	SeqListInit(&s);
	SeqListPushBack(&s, 1);
	SeqListPushBack(&s, 2);
	SeqListPushBack(&s, 3);
	SeqListPushBack(&s, 4);
	SeqListPushBack(&s, 5);
	SeqListPushBack(&s, 6);
	SeqListPushBack(&s, 7);
	SeqListShow(&s);
	SeqListPushFront(&s, 0);
	SeqListShow(&s);
	SeqListPopBack(&s);
	SeqListShow(&s);
	SeqListPopFront(&s);
	SeqListShow(&s);
	printf("%d\n",SeqListFind(&s, 5));
	SeqListInsert(&s, 5, 12);
	SeqListShow(&s);
	SeqListErase(&s, 1);
	SeqListShow(&s);
	SeqListDestroy(&s);


}
int main()
{
	test1();
	return 0;
}