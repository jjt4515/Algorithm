from sys import stdin 

n = int(stdin.readline())
s = set()

for _ in range(n):
    inp = stdin.readline().split()
    com = inp[0]
    if len(inp) > 1:
        num = int(inp[1])
  
    if com == "add":
        s.add(num)
    elif com == "remove":
        try:
            s.remove(num)
        except:
            pass
    elif com == "check":
        if num in s:
            print(1)
        else:
            print(0)
    elif com == "toggle":
        if num in s:
            s.remove(num)
        else:
            s.add(num)
    elif com == "all":
        s = set(range(1,21))
    elif com == "empty":
        s = set()
