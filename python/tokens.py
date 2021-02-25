keywords_in_c=['int','float','char','long','double','short','if','else','switch','while','do','for','break','continue','goto','enum','union','struct','auto','static','void','default','case','volatile']
operators=['+','-','*','/','%','&&','||','=']
separators=[',',';','(',')']
#input_string=input("enter input_string")
tokens=[]
#int a=b+c;
with open('c_file.txt','r') as file:
    content=file.readlines()
    list_of_lines=[line.strip() for line in content]
    print(list_of_lines)
    for each_line in list_of_lines:
        output=''
        for char in each_line:
            if char in operators:
                if output!='':
                    tokens.append(output)
                    output=''
                tokens.append(char)
            elif char in separators:
                if output!='':
                    tokens.append(output)
                    output=''
                tokens.append(char)
            else:
                if output in keywords_in_c:
                    tokens.append(output)
                    output=''
                else:
                    if output!=' ':
                        output+=char
                    else:
                        tokens.append(output)
                        output=''
print(tokens)
















         
# print(tokens)