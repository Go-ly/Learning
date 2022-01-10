#include "sort.h"

int* GenerateRandom() {
	int* data;
	int* ptr = (int*)malloc(sizeof(int) * RANDOMCOUNT);
	if (ptr == NULL) {
		perror("malloc->data");
		exit(-1);
	}
	data = ptr;
	ptr = NULL;
	// 将随机数存入data中
	for (int i = 0; i < RANDOMCOUNT; i++) {
		data[i] = rand();
	}
	SaveResult(data, "e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\data.txt");
	printf("20000随机数已准备就绪\n");
	return data;
}

// 折半插入排序 O(N^2)
float BinaryInsertSort(int* data) {
	assert(data != NULL);
	data = loadData(data);
	int fromIndex = 0;
	int toIndex = 0;
	int mid = 0;
	int key = 0;
	int startTime = clock();
	for (int i = 0; i < RANDOMCOUNT; i++) {
		fromIndex = 0;
		toIndex = i - 1;    // 这里用的是闭区间
		key = data[i];
		while (fromIndex <= toIndex) {
			mid = (fromIndex + toIndex) / 2;
			if (key >= data[mid]) {
				fromIndex = mid + 1;
			}
			else if (key < data[mid]) {
				toIndex = mid - 1;
			}
		}
		for (int j = i; j > fromIndex; j--) {
			data[j] = data[j - 1];  // 向后搬
		}
		// 经过计算，此时fromIndex恰好就是要插入的位置
		data[fromIndex] = key;
	}
	int finishTime = clock();
	SaveResult(data, "e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\BinaryInsertSortResult.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

// 保存数据到文件当中
void SaveResult(int* data, char* path) {
	assert(data != NULL);
	assert(path != NULL);
	FILE* pf = fopen(path, "w");
	if (pf == NULL) {
		perror("Save::error");
		exit(-1);
	}
	for (int i = 0; i < RANDOMCOUNT; i++) {
		fprintf(pf, "%d, ", data[i]);    
	}
	fclose(pf);
	pf = NULL;
}

float ShellSort(int* data) {
	assert(data != NULL);
	data = loadData(data);
	int startTime = clock();
	int gap = RANDOMCOUNT;
	int count = 0;
	while (gap >= 1) {   // 间隔已经小于1的话，就已经排序结束了
		gap = gap / 2;
		for (int i = 0; i < RANDOMCOUNT - gap; i++) {
			int cur = i;
			int tmp = data[cur + gap];
			while (cur >= 0) {
				if (tmp < data[cur]) {
					data[cur + gap] = data[cur];
					cur = cur - gap;   // 不是将那一组中的所有数排序
				}                       // 而是每次循环将每组中的前两个数排序
				else {
					break;
				}
			}
			data[cur + gap] = tmp;
		}
	}
	int finishTime = clock();
	SaveResult(data, "e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\ShellSort.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

// 将data.txt中的数据加载到内存中
int* loadData(int* data) {
	assert(data != NULL);
	FILE* pf = fopen("e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\data.txt", "r");
	if (pf == NULL) {
		perror("BinaryInsertSort::pf");
		exit(-1);
	}
	for (int i = 0; i < RANDOMCOUNT; i++) {
		fscanf(pf, "%d, ", &data[i]);   // 格式必须和存入文件时相同
	}
	fclose(pf);
	pf = NULL;
	return data;
}

void QuickSort(int* data, int left, int right) {
	assert(data != NULL);
	if (left < right) {
		int pos = QSortPass(data, left, right);   // 用pos将其分为左右两部分
		QuickSort(data, left, pos - 1);
		QuickSort(data, pos + 1, right);
	}
}

static int QSortPass(int* data, int left, int right) {
	assert(data != NULL);
	int x = data[left];   // 先将中心元素存起来
	while (left < right) {
		while (left < right && data[right] >= x) {
			right--;
		}           // 从右向左找第一个比x大的元素
		if (left < right) {
			data[left] = data[right];
			left++;
		}
		while (left < right && data[left] < x) {
			left++;
		}     // 从左向右找第一个比x小的元素
		if (left < right) {
			data[right] = data[left];
			right--;
		}
	}
	data[left] = x;    // 此时left恰好就是分界点
	return left;
}

// 得到最小的数据的下标
static int getMin(int* data, int left, int right) {
	assert(data != NULL);
	int min = left;
	int i = 0;
	for (i = left + 1; i < right; i++) {
		if (data[min] > data[i]) {
			min = i;
		}
	}
	return min;
}

// 简单选择排序
float EasySelectSort(int* data) {
	assert(data != NULL);
	int startTime = clock();
	data = loadData(data);
	int minIndexNum = 0;
	for (int i = 0; i < RANDOMCOUNT; i++) {
		minIndexNum = getMin(data, i, RANDOMCOUNT);
		if (minIndexNum == i) {
			continue;        // 如果两个相等那就不用交换了
		}
		int tmp = data[i];       // 将那个小的元素放到前面来
		data[i] = data[minIndexNum];
		data[minIndexNum] = tmp;
	}
	int finishTime = clock();
	SaveResult(data, "e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\SelectSort.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

static void AdjustHeap(int* data,int root, int n) {
	assert(data != NULL);
	int parent = root;
	int child = parent * 2 + 1;
	while (child < n) {
		if (child + 1 < n && data[child + 1] > data[child]) {
			child++;
		}       // 找两个孩子中最大的那个
		if (data[child] > data[parent]) {
			Swap(data, child, parent);
			parent = child;
			child = 2 * parent + 1;
		}    // 最大的那个孩子比父亲还大，那就交换
		else {
			break;
		}
	}
}

static void Swap(int* data, int i, int j) {
	assert(data != NULL);
	int tmp = data[i];
	data[i] = data[j];
	data[j] = tmp;
}

float HeapSort(int* data) {
	assert(data != NULL);
	data = loadData(data);
	int startTime = clock(); 
	for (int i = (RANDOMCOUNT - 1 - 1) / 2; i >= 0; i--) {
		AdjustHeap(data, i, RANDOMCOUNT);    // 这里数组的下标从0开始
	}
	int end = RANDOMCOUNT - 1;
	while (end > 0) {     // end > 0就说明还没调整完
		Swap(data, 0, end);
		AdjustHeap(data, 0, end);
		end--;
	}
	int finishTime = clock();
	SaveResult(data, "e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\HeapSort.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

// 保存各排序执行时间到
void SaveTime(float* time) {
	assert(time != NULL);
	FILE* pf = fopen("e:\\代码\\DataStructure\\2021-12-13 综合排序\\SortResult\\OperatTime.txt", "w");
	if (pf == NULL) {
		perror("SaveTime");
		exit(-1);
	}
	fprintf(pf, "BinaryInsertSortTime: %f\n", time[binaryInsertSort]);
	fprintf(pf, "ShellSortTime: %f\n", time[shellSort]);
	fprintf(pf, "QuickSortTime: %f\n", time[quickSort]);
	fprintf(pf, "EasySelectSortTime: %f\n", time[easySelectSort]);
	fprintf(pf, "HeapSortTime: %f\n", time[heapSort]);
	fclose(pf);
	pf = NULL;
}

// 释放内存
void FreeMemory(int* data) {
	assert(data != NULL);
	free(data);
	data = NULL;
}

void Menu() {
	printf("********************************************************\n");
	printf("*********      数据结构课设：   综合排序     ***********\n");
	printf("********************************************************\n");
	printf("*****    1. QuickSort     2. BinaryInsertSort    *******\n");
	printf("*****    3. ShellSort     4. EasySelectSort      *******\n");
	printf("*****    5. HeapSort      0. EXIT                *******\n");
	printf("********************************************************\n");
}