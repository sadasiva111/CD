from collections import defaultdict
productions={}
first_of=defaultdict(list)
follow_of=defaultdict(list)
terminals=['a','b','c','d','e','f','g','h']
non_terminals=['A','B','C','S','E','F','D']
size=int(input("enter size"))
for i in range(size):
    input_=input("enter production")
    productions[input_[0]]=input_[3:]
def epslon(key,start):
    for k,v in productions.items():
        if start == k:
            index=v.find(key)
            if index!=-1:
                if v[index+1] in terminals:
                    first_of[start].append(v[index+1])
                else:
                    first(v[index+1],start)
def first(key,start):
    #S->AB/c
    #A->a/@
    for key_,value_ in productions.items():
        if key == key_:
            if '@' in value_:
                epslon(key,start)
            if '/' in value_:
                
                for index,char in enumerate(value_):
                    if char=='/':
                        if value_[index+1] in terminals:
                            first_of[start].append(value_[index+1])
                        else:
                            first(value_[index+1],start)
            if value_[0] in terminals:
                first_of[start].append(value_[0])

            else:
                first(value_[0],start)
follow_of['S'].append('$')
def follow(key,start):
    for k,v in productions.items():
        if key in v:
            for index,char in enumerate(v):
                if char==key:
                    if index==len(v)-1 or v[index+1]=='/':
                        for k_,v_ in follow_of.items():
                            if key == k_:
                                for i in v_:
                                    follow_of[start].append(i)
                                break
                    else:
                        if v[index+1] in terminals:
                            follow_of[start].append(v[index+1])
                        else:
                            for k_,v_ in first_of.items():
                                if k_ == v[index+1]:
                                    for i in v_:
                                        follow_of[start].append(i)

for Terminal in productions.keys():
    first(Terminal,Terminal)
print(first_of)
for Terminal in productions.keys():
    follow(Terminal,Terminal)
print(follow_of)