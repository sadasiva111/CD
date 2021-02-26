#include<stdio.h>
#include<conio.h>
#include<string.h>
int main(){
	char keyword[31][10]={"int","float","long","short","if","else","while","for","switch","break","continue","char","double","volatile","struct","enum","void","delete","goto","union","default","auto","case","static","register","return","extern","signed","do","sizeof","const"};
	char input_string[10];
	printf("enter input string");
	scanf("%s",input_string);
	int i,flag=0;
	for(i=0;i<29;i++){
		//printf("%s   -- %s",keyword[i],input_string);
		if(strcmp(keyword[i],input_string)==0){
			printf("its a keyword in c");
			flag=1;
			break;
		}
	}
	if(flag==0){
		printf("its not a keyword in c");
	}
	return 0;
}
