/*
* 哈希表设计
* 为班级30个人的姓名设计一个哈希表，假设姓名用汉语拼音表示。
* 要求用除留余数法构造哈希函数，用线性探测再散列法处理冲突
* 平均查找长度的上限为2
*/
#include "HashList.h"
int main() {
	Data data;
	HashList hashlist;
	InitHashList(&hashlist);
	FillData(&data);
	KeyOf(&data);
	Save(&data, &hashlist);
	char ch[1024];
	printf("请输入你要查找的人名(拼音):>");
	scanf("%s", &ch);
	int addr = HashSearch(&hashlist, ch);
	printf("%d\n", addr);
	return 0;
}
