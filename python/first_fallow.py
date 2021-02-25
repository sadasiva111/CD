from collections import defaultdict;
terminals=['a','b','c','d','e']
non_terminals=['S','A','B','C','D']
productions={}
no_of_productions=int(input("enter the number of productions"))
for number in range(no_of_productions):
    input_=input("enter production")
    productions[input_[0]]=input_[3:]
first_of=defaultdict(list)
fallow_of=defaultdict(list)
fallow_of['S'].append('$')
slash='/'
print(productions)
def func(key,start):
    for key_,value_ in productions.items():
        if start == key_:
            index=value_.find(key)
            if value_[index+1] in terminals:
                first_of[start].append(value_[index+1])
            else:
                first(value_[index+1],start)

def first(key,start):
    for key_,value_ in productions.items():
        if key == key_:
            if '/' in value_:
                index=value_.find('/')
                #print(index,value_)
                if value_[index+1] == '@':
                    func(key,start)
                if value_[index+1] in terminals:
                    first_of[start].append(value_[index+1])
                else:
                    first(value_[index+1],start)
            if value_[0] in terminals:
                    first_of[start].append(value_[0])
            else:
                first(value_[0],start)      
def fallow_(index,key,start,value_):
    if index == len(value_)-1 or value_[index+1]=='/':
                for k_,v_ in fallow_of.items():
                    if key == k_:
                        for i in v_:
                            fallow_of[start].append(i)
                        break
    else:
        if value_[index+1] in terminals:
            fallow_of[start].append(value_[index+1])
        else:
            for k1_,v1_ in first_of.items():
                if k1_ == value_[index+1]:
                    for i in v1_:
                        fallow_of[start].append(i)
                    break
def fallow(key,start):
    for key_,value_ in productions.items():
        if key in value_:
            for char in value_:
                if char == key:
                    index=value_.find(char)
                    fallow_(index,key_,start,value_)

            


            

for Terminal in productions.keys():
    #print(Terminal)
    first(Terminal,Terminal)

for Terminal in productions.keys():
    #print(Terminal)
    fallow(Terminal,Terminal)
for key,value in first_of.items():
    print(f"first of {key} is {value}")

for key,value in fallow_of.items():
    print(f"fallow of {key} is {value}")
#S->AB/AC
#A->a