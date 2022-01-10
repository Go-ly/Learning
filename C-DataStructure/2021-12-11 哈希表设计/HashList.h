#pragma once
#define _CRT_SECURE_NO_WARNINGS

#define POPULATION 30 
#define LENGTH 50
#define RANDOM 47


#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>

typedef struct PeoInfo {
	int key;
	char name[1024];
}PeoInfo;

typedef struct Data {
	PeoInfo* data;
}Data;

typedef struct HashList {
	PeoInfo* List;
}HashList;

void FillData(Data* ps);
void KeyOf(Data* ps);
void Save(Data* pd, HashList* ph);
void InitHashList(HashList* ph);