#include "Stack.h"

int main()
{
		char input = '0';
		Stack st;
		Stack* ps = &st;
		StackInit(ps);
		StackIncrease(ps);
		while (1)
		{
			input = getchar();
			if (input == '@')
			{
				break;
			}
			if (ps->arr[ps->top - 1] != input)
			{
				StackPush(ps, input);
			}
			else
			{
				StackPop(ps);
			}
		}
		bool is_empty = StackEmpty(ps);
		if (is_empty)
		{
			printf("这是一个回文\n");
		}
		else
		{
			printf("这不是一个回文\n");
		}
		StackDestroy(ps);        //销毁栈，释放内存
	return 0;
}