TT={
	'A' : ['B','D'],
	'B' : ['B','DC'],
	'C' : ['B','C'],
	'D' : ['ED','D'],
	'E' : ['E','D']
}
SS = 'A'
PS = SS
FS = ['C','E']
IS = input("Enter Input String")
for char in IS:
	for key,value in TT.items():
		if PS==key:
			PS=value[int(char)]
			if len(PS)>1:
				for index in PS:
					if index in FS:
						PS = index
						print(f"{key}--{char}--{PS}")
						break
					else:
						PS = index
			else:
				print(f"{key}--{char}--{PS}")
			break
if PS in FS:
	print("Accepted")
else:
	print("Rejected")

			