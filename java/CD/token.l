%{
	#include<stdio.h>
%}

%%

int|float|char|const|void|long|double|short|signed|unsigned|if|else|while|do|for|switch|case|default|return|break|continue|auto|static|register|extern|union|struct|enum|typedef|sizeof|volatile|delete  {printf("It is a keyword");}
[a-zA-Z_][a-zA-Z_0-9]*	{printf("It is a identifier");}
[0-9]+	{printf("It is a Number");}
.*	{printf("Neither keyword/number/identifier");}

%%

int main(){
	printf("Enter input:");
	yylex();
	return 0;
}
int yywrap(){
	return 1;
}