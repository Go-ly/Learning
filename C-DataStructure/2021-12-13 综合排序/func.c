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
	// �����������data��
	for (int i = 0; i < RANDOMCOUNT; i++) {
		data[i] = rand();
	}
	SaveResult(data, "e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\data.txt");
	printf("20000�������׼������\n");
	return data;
}

// �۰�������� O(N^2)
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
		toIndex = i - 1;    // �����õ��Ǳ�����
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
			data[j] = data[j - 1];  // ����
		}
		// �������㣬��ʱfromIndexǡ�þ���Ҫ�����λ��
		data[fromIndex] = key;
	}
	int finishTime = clock();
	SaveResult(data, "e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\BinaryInsertSortResult.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

// �������ݵ��ļ�����
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
	while (gap >= 1) {   // ����Ѿ�С��1�Ļ������Ѿ����������
		gap = gap / 2;
		for (int i = 0; i < RANDOMCOUNT - gap; i++) {
			int cur = i;
			int tmp = data[cur + gap];
			while (cur >= 0) {
				if (tmp < data[cur]) {
					data[cur + gap] = data[cur];
					cur = cur - gap;   // ���ǽ���һ���е�����������
				}                       // ����ÿ��ѭ����ÿ���е�ǰ����������
				else {
					break;
				}
			}
			data[cur + gap] = tmp;
		}
	}
	int finishTime = clock();
	SaveResult(data, "e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\ShellSort.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

// ��data.txt�е����ݼ��ص��ڴ���
int* loadData(int* data) {
	assert(data != NULL);
	FILE* pf = fopen("e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\data.txt", "r");
	if (pf == NULL) {
		perror("BinaryInsertSort::pf");
		exit(-1);
	}
	for (int i = 0; i < RANDOMCOUNT; i++) {
		fscanf(pf, "%d, ", &data[i]);   // ��ʽ����ʹ����ļ�ʱ��ͬ
	}
	fclose(pf);
	pf = NULL;
	return data;
}

void QuickSort(int* data, int left, int right) {
	assert(data != NULL);
	if (left < right) {
		int pos = QSortPass(data, left, right);   // ��pos�����Ϊ����������
		QuickSort(data, left, pos - 1);
		QuickSort(data, pos + 1, right);
	}
}

static int QSortPass(int* data, int left, int right) {
	assert(data != NULL);
	int x = data[left];   // �Ƚ�����Ԫ�ش�����
	while (left < right) {
		while (left < right && data[right] >= x) {
			right--;
		}           // ���������ҵ�һ����x���Ԫ��
		if (left < right) {
			data[left] = data[right];
			left++;
		}
		while (left < right && data[left] < x) {
			left++;
		}     // ���������ҵ�һ����xС��Ԫ��
		if (left < right) {
			data[right] = data[left];
			right--;
		}
	}
	data[left] = x;    // ��ʱleftǡ�þ��Ƿֽ��
	return left;
}

// �õ���С�����ݵ��±�
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

// ��ѡ������
float EasySelectSort(int* data) {
	assert(data != NULL);
	int startTime = clock();
	data = loadData(data);
	int minIndexNum = 0;
	for (int i = 0; i < RANDOMCOUNT; i++) {
		minIndexNum = getMin(data, i, RANDOMCOUNT);
		if (minIndexNum == i) {
			continue;        // �����������ǾͲ��ý�����
		}
		int tmp = data[i];       // ���Ǹ�С��Ԫ�طŵ�ǰ����
		data[i] = data[minIndexNum];
		data[minIndexNum] = tmp;
	}
	int finishTime = clock();
	SaveResult(data, "e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\SelectSort.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

static void AdjustHeap(int* data,int root, int n) {
	assert(data != NULL);
	int parent = root;
	int child = parent * 2 + 1;
	while (child < n) {
		if (child + 1 < n && data[child + 1] > data[child]) {
			child++;
		}       // �����������������Ǹ�
		if (data[child] > data[parent]) {
			Swap(data, child, parent);
			parent = child;
			child = 2 * parent + 1;
		}    // �����Ǹ����ӱȸ��׻����Ǿͽ���
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
		AdjustHeap(data, i, RANDOMCOUNT);    // ����������±��0��ʼ
	}
	int end = RANDOMCOUNT - 1;
	while (end > 0) {     // end > 0��˵����û������
		Swap(data, 0, end);
		AdjustHeap(data, 0, end);
		end--;
	}
	int finishTime = clock();
	SaveResult(data, "e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\HeapSort.txt");
	return (finishTime - startTime) / (float)CLOCKS_PER_SEC;
}

// ���������ִ��ʱ�䵽
void SaveTime(float* time) {
	assert(time != NULL);
	FILE* pf = fopen("e:\\����\\DataStructure\\2021-12-13 �ۺ�����\\SortResult\\OperatTime.txt", "w");
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

// �ͷ��ڴ�
void FreeMemory(int* data) {
	assert(data != NULL);
	free(data);
	data = NULL;
}

void Menu() {
	printf("********************************************************\n");
	printf("*********      ���ݽṹ���裺   �ۺ�����     ***********\n");
	printf("********************************************************\n");
	printf("*****    1. QuickSort     2. BinaryInsertSort    *******\n");
	printf("*****    3. ShellSort     4. EasySelectSort      *******\n");
	printf("*****    5. HeapSort      0. EXIT                *******\n");
	printf("********************************************************\n");
}