import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int a = scores[0][0];
        int b = scores[0][1];
        
        int selfSum = a + b;
        int answer = 1;
        int maxPeer = 0;
        
        Arrays.sort(scores, (x,y) -> {
                        if (x[0] != y[0]) return y[0] - x[0];
                        else return x[1] - y[1];
                    });
        
        for (int i=0;i<scores.length;i++) {
            int curA = scores[i][0];
            int curB = scores[i][1];
            
            if (curB < maxPeer) {
                if (curA == a && curB == b) {
                    return -1;
                }
                continue; 
            }
            
            if (curB > maxPeer) {
                maxPeer = curB;
            }

            if (curA + curB > selfSum) {
                answer++;
            }
        }
        
        return answer;
    }
}