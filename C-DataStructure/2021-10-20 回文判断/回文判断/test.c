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
			printf("����һ������\n");
		}
		else
		{
			printf("�ⲻ��һ������\n");
		}
		StackDestroy(ps);        //����ջ���ͷ��ڴ�
	return 0;
}