TT={
	'A' : ['B','B'],
	'B' : ['B','C'],
	'B' : ['D','D'],
	'B' : ['A','A']
}
PS = 'A'
FS = ['A']
IS = input("Enter input String")
for char in IS:
 for key,value in TT.items():
  if PS==key:
   PS=value[int(char)]
   print(f"{key}--{char}--{PS}")
   break
if PS in FS:
	print("Accepted")
else:
	print("Not Accepted")


		