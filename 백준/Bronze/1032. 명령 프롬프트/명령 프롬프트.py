num = int(input())
list1 = list(input())
str_len = len(list1)
for i in range(num -1):
    str_list = list(input())
    for j in range(str_len):
        if list1[j] != str_list[j]:
            list1[j] = '?'
print(''.join(list1))