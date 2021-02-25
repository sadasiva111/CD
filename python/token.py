keywords_in_c=['int','float','char','long','double','short','if','else','switch','while','do','for','break','continue','goto','enum','union','struct','auto','static','void','default','case','volatile']
operators=['+','-','*','/','%','&&','||','=']
separators=[',',';','(',')']
input_string=input("enter input string")
tokens=[]
output=''
for char in input_string:
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
        if char!=' ':
            output+=char
        else:
            if output in keywords_in_c:
                tokens.append(output)
                output=''

print(tokens)
for token in tokens:
    print(token)