/*
* ��ϣ�����
* Ϊ�༶30���˵��������һ����ϣ�����������ú���ƴ����ʾ��
* Ҫ���ó��������������ϣ������������̽����ɢ�з������ͻ
* ƽ�����ҳ��ȵ�����Ϊ2
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
	printf("��������Ҫ���ҵ�����(ƴ��):>");
	scanf("%s", &ch);
	int addr = HashSearch(&hashlist, ch);
	printf("%d\n", addr);
	return 0;
}
