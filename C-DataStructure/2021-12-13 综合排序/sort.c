#include "sort.h";

/*
* �ۺ�����
* ���������������N���������(20000����),����Щ�����ж��ַ�����������
* Ҫ��
* 1���������ַ���ʵ������������⣨��ѡ�õķ����У��۰��������ϣ�����򣬿������򣬶����򣬹鲢���򣩡�
*	���������������ڲ�ͬ���ļ���
* 2��ͳ��ÿһ�����򷽷������ܣ����ϻ����г��������ѵ�ʱ��Ϊ׼���жԱȣ����ҳ��������ֽϿ�ķ���
*/

int main() {
	srand((unsigned int)time(NULL));   // ʱ��������������
	Menu();
	int* data = GenerateRandom();
	float time[1024] = { 0 };
	int input = 0;
	do
	{
		printf("��ѡ��:>");
		scanf("%d", &input);
		switch (input) {
			case quickSort: {
				data = loadData(data);
				int startTime = clock();
				QuickSort(data, 0, RANDOMCOUNT - 1);   // ע�⴫�β���Խ��
				int finishTime = clock();
				printf("QuickSort��ɣ�����\n");
				printf("����ʱ%f��\n", (finishTime - startTime) / (float)CLOCKS_PER_SEC);
				time[quickSort] = (finishTime - startTime) / (float)CLOCKS_PER_SEC;
				SaveResult(data, "e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\QuickSort.txt");
				break;
			}
			case binaryInsertSort: {
				float BinaryInsertSortTime = BinaryInsertSort(data);	
				printf("BinaryInsertSort��ɣ�����\n");
				printf("����ʱ%f��\n", BinaryInsertSortTime);
				time[binaryInsertSort] = BinaryInsertSortTime;
				break;
			}
			case shellSort: {
				float ShellSortTime = ShellSort(data);
				printf("ShellSort��ɣ�����\n");
				printf("����ʱ%f��\n", ShellSortTime);
				time[shellSort] = ShellSortTime;
				break;
			}
			case easySelectSort: {
				float EasySelectSortTime = EasySelectSort(data);
				printf("EasySelectSort��ɣ�����\n");
				printf("����ʱ%f��\n", EasySelectSortTime);
				time[easySelectSort] = EasySelectSortTime;
				break;
			}
			case heapSort: {
				float HeapSortTime = HeapSort(data);
				printf("HeapSort��ɣ�����\n");
				printf("����ʱ%f��\n", HeapSortTime);
				time[heapSort] = HeapSortTime;
				break;
			}
			case Exit: {
				printf("�����˳�\n");
				break;
			}
			default: {
				printf("�����������������\n");
				break;    // �ݴ���
			}
		}
	} while (input);
	printf("����ʱ����������ѱ��棡����\n");
	SaveTime(time);
	FreeMemory(data);   // ��ʱ�ͷ��ڴ棬�����ڴ�й¶
	return 0;
}