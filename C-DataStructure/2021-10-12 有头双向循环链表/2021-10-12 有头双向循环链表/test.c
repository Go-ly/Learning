#define _CRT_SECURE_NO_WARNINGS 1
#include "list.h"

void test1()
{
	ListNode* plist = ListInit();
	ListInit(plist);
	ListPushBack(plist, 3);
	ListPushBack(plist, 4);
	ListShow(plist);
	ListPushFront(plist, 2);
	ListPushFront(plist, 1);
	ListShow(plist);
	ListPopBack(plist);
	ListPopBack(plist);
	ListShow(plist);
	ListPushFront(plist, 0);
	ListPushFront(plist, 5);
	ListShow(plist);
	ListPopFront(plist);
	ListShow(plist);
	ListInsertBefore(plist, 1, 40);
	ListShow(plist);
	ListInsertBefore(plist, 2, 50);
	ListShow(plist);
	ListErase(plist, 1);
	ListShow(plist);
	ListErase(plist, 2);
	ListShow(plist);
	ListErase(plist, 7);
	ListErase(plist, 50);
	ListErase(plist, 40);
	ListShow(plist);
}
int main()
{
	test1();
	return 0;
}