#include "sort.h";

/*
* 综合排序
* 利用随机函数产生N个随机整数(20000以上),对这些数进行多种方法进行排序
* 要求：
* 1）采用四种方法实现上述问题求解（可选用的方法有：折半插入排序，希尔排序，快速排序，堆排序，归并排序）。
*	并把排序结果保存在不同的文件中
* 2）统计每一种排序方法的性能（以上机运行程序所花费的时间为准进行对比），找出其中两种较快的方法
*/

int main() {
	srand((unsigned int)time(NULL));   // 时间戳设置随机种子
	Menu();
	int* data = GenerateRandom();
	float time[1024] = { 0 };
	int input = 0;
	do
	{
		printf("请选择:>");
		scanf("%d", &input);
		switch (input) {
			case quickSort: {
				data = loadData(data);
				int startTime = clock();
				QuickSort(data, 0, RANDOMCOUNT - 1);   // 注意传参不能越界
				int finishTime = clock();
				printf("QuickSort完成！！！\n");
				printf("共用时%f秒\n", (finishTime - startTime) / (float)CLOCKS_PER_SEC);
				time[quickSort] = (finishTime - startTime) / (float)CLOCKS_PER_SEC;
				SaveResult(data, "e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\QuickSort.txt");
				break;
			}
			case binaryInsertSort: {
				float BinaryInsertSortTime = BinaryInsertSort(data);	
				printf("BinaryInsertSort完成！！！\n");
				printf("共用时%f秒\n", BinaryInsertSortTime);
				time[binaryInsertSort] = BinaryInsertSortTime;
				break;
			}
			case shellSort: {
				float ShellSortTime = ShellSort(data);
				printf("ShellSort完成！！！\n");
				printf("共用时%f秒\n", ShellSortTime);
				time[shellSort] = ShellSortTime;
				break;
			}
			case easySelectSort: {
				float EasySelectSortTime = EasySelectSort(data);
				printf("EasySelectSort完成！！！\n");
				printf("共用时%f秒\n", EasySelectSortTime);
				time[easySelectSort] = EasySelectSortTime;
				break;
			}
			case heapSort: {
				float HeapSortTime = HeapSort(data);
				printf("HeapSort完成！！！\n");
				printf("共用时%f秒\n", HeapSortTime);
				time[heapSort] = HeapSortTime;
				break;
			}
			case Exit: {
				printf("程序退出\n");
				break;
			}
			default: {
				printf("输入错误，请重新输入\n");
				break;    // 容错处理
			}
		}
	} while (input);
	printf("排序时间和排序结果已保存！！！\n");
	SaveTime(time);
	FreeMemory(data);   // 及时释放内存，避免内存泄露
	return 0;
}