vowel = ['a','e','i','o','u']
l, c = map(int, input().split())
words = sorted(list(map(str, input().split())))

def back_tracking(cnt, idx):
    vo, co = 0,0
    if cnt == l:
        for i in range(l):
            if answer[i] in vowel:
                vo += 1
            else:
                co += 1
        if vo >= 1 and co >= 2:
            print("".join(answer))
        return 
    for i in range(idx, c):
        answer.append(words[i])
        back_tracking(cnt+1, i+1)
        answer.pop()

answer=[]
back_tracking(0,0)



