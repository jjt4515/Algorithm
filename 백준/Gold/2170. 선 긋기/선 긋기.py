from sys import stdin
n = int(stdin.readline())
line = []
input_lst = [list(map(int, stdin.readline().split())) for _ in range(n)]
input_lst.sort()
for x,y in input_lst:
    line_length = len(line)
    if line_length == 0:
        line.append([x,y])
    else:
        if line[line_length-1][1] < x:
            line.append([x,y])
        else:
            if line[line_length-1][1] < y:
                line[line_length-1][1] = y
            else:
                continue
res = 0
for x, y in line:
    res += (y-x)
print(res)