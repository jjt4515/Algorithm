def solution(players, m, k):
    answer = 0
    
    server = [0 for _ in range(24)]
    
    for i in range(24):
        if players[i] >= (server[i] + 1) * m:
    
            num = (players[i] - ((server[i] + 1) * m)) // m + 1
            answer += num
            print(answer)
            for j in range(i, i+k):
                if j < 24:
                    server[j] += num
                    
            
    
    return answer