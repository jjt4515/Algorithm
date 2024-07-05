import sys
n = int(sys.stdin.readline())
lst = []
output_lst = []
stack = []
new_lst = []
result = []

for i in range(1, n+1):
    lst.append(i)

for i in range(n):
    num = int(sys.stdin.readline())
    result.append(num)

j = 0
while len(new_lst) < len(result):
    if len(lst) == 0:
        pop_num = stack.pop(-1)
        if pop_num == result[j]:
            new_lst.append(pop_num)
            j += 1
            output_lst.append('-')
        else:
            output_lst.clear()
            output_lst.append("NO")
            break
    else:
        if lst[0] <= result[j]:
            push_num = lst.pop(0)
            stack.append(push_num)
            output_lst.append('+')
            if push_num == result[j]:
                pop_num = stack.pop(-1)
                new_lst.append(pop_num)
                j += 1
                output_lst.append('-')
        else:
            pop_num = stack.pop(-1)
            if pop_num == result[j]:
                new_lst.append(pop_num)
                j += 1
                output_lst.append('-')
            else:
                output_lst.clear()
                output_lst.append("NO")
                break
    
        
for i in output_lst:
    print(i)
    
