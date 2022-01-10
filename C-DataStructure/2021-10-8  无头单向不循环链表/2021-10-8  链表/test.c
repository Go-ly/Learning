#define _CRT_SECURE_NO_WARNINGS 1
#include "SList.h"
void test1()
{
	SListNode* plist = NULL;
	SListPushBack(&plist, 1);
	SListPushBack(&plist, 3);
	SListPushBack(&plist, 5);
	SListPushBack(&plist, 7);
	SListPushBack(&plist, 9);
	SListShow(plist);
	SListPushFront(&plist, 6);
	SListShow(plist);
	SListPushFront(&plist, 5);
	SListShow(plist);
	SListPopBack(&plist);
	SListShow(plist);
	SListPopBack(&plist);
	SListPopBack(&plist);
	SListPopBack(&plist);
	SListPopBack(&plist);
	SListPopBack(&plist);
	SListPopBack(&plist);
	SListShow(plist);
	SListPopBack(&plist);
	SListShow(plist);
	SListPushBack(&plist, 3);
	SListPushBack(&plist, 4);
	SListPushBack(&plist, 5);
	SListShow(plist);
	SListPopFront(&plist);
	SListShow(plist);
	printf("%d\n", *(SListFind(plist, 4)));
	SListInsertAfter(plist, 4, 12);
	SListShow(plist);
	SListInsertBefore(&plist, 5, 0);
	SListShow(plist);
	SListEraseAfter(plist, 12);
	SListShow(plist);

}
int main()
{
	test1();
	return 0;
}