#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <time.h>

#define RANDOMCOUNT 20000

enum Function {
	Exit,
	quickSort,
	binaryInsertSort,
	shellSort,
	easySelectSort,
	heapSort,
};      // 枚举常量用在switch中

int* GenerateRandom();
float BinaryInsertSort(int* data);
void QuickSort(int* data, int left, int right);
void SaveResult(int* data, char* path);
float ShellSort(int* data);
int* loadData(int* data);
static int QSortPass(int* data, int left, int right);
float EasySelectSort(int* data);
static int getMin(int* data, int left, int right);
float HeapSort(int* data);
static void Swap(int* data, int i, int j);
void SaveTime(float* time);
void FreeMemory(int* data);
void Menu();