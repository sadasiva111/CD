#E->E+E
#E->E*E
#E->i
from collections import defaultdict
productions=[]
size=int(input("enter size"))
for number in range(size):
    input_=input("enter production")
    productions.append(input_)
productions_=defaultdict(list)
for each_production in productions:
    productions_[each_production[0]].append(each_production[3:])
input_string=input("enter input string")
#i+i+i
stack=['$']
for char in input_string:
    stack.append(char)
    dynamic=len(stack)-2
    output=''
    while dynamic!=-1:
        for i in stack[:dynamic:-1]:
            output+=i
        
        for key,value in productions_.items():
            if output in value:
                for k in output:
                    #print(k)
                    stack.pop()
                stack.append(key)
                print(stack)
        dynamic-=1
        print(output)
        output=''


if stack[1]=='E':
    print("accept")
else:
    print("reject")





    
