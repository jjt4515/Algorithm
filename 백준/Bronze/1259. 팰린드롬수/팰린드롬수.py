numList = []
i=0
while(True):
    num = int(input())
    numList.append(num)
    if numList[i] == 0:
        break

    if str(numList[i]) == str(numList[i])[::-1]:
        print("yes")
    else:
        print("no")

    i += 1

