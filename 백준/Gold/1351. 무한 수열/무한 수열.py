#2/7
#그냥 재귀는 시간초과
#그냥 dp는 메모리초과
#딕셔너리를 활용한 dp

n, p, q = map(int, input().split())

def algorigthm(x):
    if x in data:
        return data[x]      

    data[x] = algorigthm(x//p) + algorigthm(x//q)
    return data[x]

data = {}
data[0] = 1

print(algorigthm(n))
