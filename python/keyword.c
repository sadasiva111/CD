#include<stdio.h>
#include<string.h>
int main(){
	char keyword[31][10]={"int","float","long","short","if","else","while","for","switch","break","continue","char","double","volatile","struct","enum","void","delete","goto","union","default","auto","case","static","register","return","extern","signed","do","sizeof","const"};
	int i,k,j,flag=0,length1,h=0;
	char input_string[10];
	printf("enter input string");
	scanf("%s",input_string);
	int length=strlen(input_string);
	for(i=0;i<31;i++){
		k=0;
		length1=strlen(keyword[i]);
		for(j=0;j<keyword[i][j]!='/0';j++){
			if(k<length){
				if(keyword[i][j] == input_string[k]){
					k++;
			    }
			    else{
			    	flag+=1;
			    	break;
				}
			}
			else if(k == length1){
				h=1;
				printf("its a keyword in c");
				break;
			}
			else{
				//printf("its not  a keyword in c");
				break;
			}	
		}
		if(h==1){
			break;
		}
		if(flag==31){
			printf("its not a keyword in c");
			break;
		}
	}
	if(h==0 && flag!=31){
		printf("its not akeyword in c");
	}
	
	return 0;
}
