productions={}
terminals=['a','b','c','d','e','f']
non_terminals=['A','B','C','D']
no_of_productions=int(input("enter number of productions"))
for i in range(no_of_productions):
    input_=input("enter production")
    productions[input_[0]]=input_[3:]
#checking for left derivative
#productions{
# 'E' : 'Ea/b'
# }
for key,value in productions.items():
    if '/' in value:
        index_=value.find('/')
        if key == value[0] and value[index_+1] in terminals:
            print(f"the production with key {key} is left derivative")
            print("after removing left derivative the productions are")
            print(f"{key}-->{value[index_+1]}{key}'")
            print(f"{key}'-->{value[1:index_]}{key}'/@")
        else:
            print(f"the production with key {key} is not  left derivative")
#E->Ea/b
#E->bE'
#E'->aE'/@
