#include "HashList.h"
void FillData(Data* ps) {
	assert(ps != NULL);
	PeoInfo* ptr = (PeoInfo*)malloc(sizeof(PeoInfo) * POPULATION);
	if (ptr == NULL) {
		perror("malloc->PeoInfo");
		exit(-1);
	}
	ps->data = ptr;
	ptr = NULL;
	strcpy(ps->data[0].name, "jsklfd");
	strcpy(ps->data[1].name, "fjlds");
	strcpy(ps->data[2].name, "fsddg");
	strcpy(ps->data[3].name, "fsd");
	strcpy(ps->data[4].name, "gr");
	strcpy(ps->data[5].name, "ewf");
	strcpy(ps->data[6].name, "ew");
	strcpy(ps->data[7].name, "fsbfs");
	strcpy(ps->data[8].name, "fwed");
	strcpy(ps->data[9].name, "fdv");
	strcpy(ps->data[10].name, "vdxv");
	strcpy(ps->data[11].name, "ewg");
	strcpy(ps->data[12].name, "gffs");
	strcpy(ps->data[13].name, "gre");
	strcpy(ps->data[14].name, "gews");
	strcpy(ps->data[15].name, "gsrf");
	strcpy(ps->data[16].name, "rsfsdv");
	strcpy(ps->data[17].name, "gsecd");
	strcpy(ps->data[18].name, "gsevd");
	strcpy(ps->data[19].name, "greb");
	strcpy(ps->data[20].name, "dweg");
	strcpy(ps->data[21].name, "gers");
	strcpy(ps->data[22].name, "hgres");
	strcpy(ps->data[23].name, "her");
	strcpy(ps->data[24].name, "gws");
	strcpy(ps->data[25].name, "qwef");
	strcpy(ps->data[26].name, "yhgd");
	strcpy(ps->data[27].name, "jgy");
	strcpy(ps->data[28].name, "gb");
	strcpy(ps->data[29].name, "yjr");
	strcpy(ps->data[30].name, "hih");
}

void KeyOf(Data* ps) {
	assert(ps != NULL);
	char* str;
	int k = 0;
	for (int i = 0; i < POPULATION; i++) {
		k = 0;
		str = &ps->data[i].name[0];
		while (*str != '\0') {
			k = *str + k;
			str++;
		}
		ps->data[i].key = k;
	}
}

void InitHashList(HashList* ph) {
	assert(ph != NULL);
	PeoInfo* ptr = (PeoInfo*)malloc(sizeof(PeoInfo) * LENGTH);
	if (ptr == NULL) {
		perror("malloc->InitHashList");
		exit(-1);
	}
	ph->List = ptr;
	ptr = NULL;
	for (int i = 0; i < LENGTH; i++) {
		ph->List[i].key = 0;
		strcpy(ph->List[i].name, " ");
	}
}

void Save(Data* pd, HashList* ph) {
	assert(pd != NULL);
	assert(ph != NULL);
	// 除留余数法
	int addr = 0;
	for (int i = 0; i < POPULATION; i++) {
		addr = pd->data[i].key % RANDOM;
		for (int j = 0; j < LENGTH && addr + j < LENGTH; j++) {
			addr = (addr + j) % RANDOM;
			if (ph->List[addr].key == 0) {
				ph->List[addr].key = pd->data[i].key;
				strcpy(ph->List[addr].name, pd->data[i].name);
				break;
			}
		}
	}
}

int HashSearch(HashList* ph, char* name) {
	assert(ph != NULL);
	int key = 0;
	while (*name != '\0') {
		key = key + *name;
		name++;
	}
	int addr = key % RANDOM;
	if (ph->List[addr].key == 0) {
		return -1;
	}
	else if (ph->List[addr].key == key) {
		return addr;
	}
	else {
		// 处理冲突
		for (int i = 0; i < LENGTH && addr + i < LENGTH; i++) {
			addr = (addr + i) % RANDOM;
			if (ph->List[addr].key == 0) {
				return -1;
			}
			else if (ph->List[addr].key == key) {
				return addr;
			}
		}
		return -1;
	}
}