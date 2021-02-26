%{
	#include"intop.tab.h"
	#include<stdio.h>
%}
%%
[0-9]+  {yylval=atoi(yytext); return NUMBER;}
.|\n       return *yytext;
%%

int yywrap(){
    return 1;
}