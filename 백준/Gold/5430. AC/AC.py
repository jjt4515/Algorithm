from sys import stdin
total_num = int(stdin.readline())

for i in range(total_num):

    re = 0

    com = stdin.readline().rstrip()
    num = int(stdin.readline())
    lst = stdin.readline().rstrip()[1:-1].split(',')

    length = len(lst)

    if num == 0:
        lst = []
    
    for c in com:
        if c == 'R':
            re += 1
        elif c == 'D':
            if len(lst) == 0:
                print("error")
                break
            else:
                if re % 2 == 1:
                    lst.pop()
                else:
                    lst.pop(0)

    
    else:
        if re % 2 == 1:
            lst.reverse()
            print("[" + ",".join(lst) + "]")
        else:
            print("[" + ",".join(lst) + "]")
 