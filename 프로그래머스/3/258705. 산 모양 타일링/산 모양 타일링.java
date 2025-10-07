import java.util.*;
class Solution {
    static int[][] ans;
    public int solution(int n, int[] tops) {
        ans = new int[n][2];
        ans[0][0] = 2 + tops[0];
        ans[0][1] = 1;
        
        for (int i=1;i<n;i++) {
            ans[i][1] = (ans[i-1][0] + ans[i-1][1])%10007;
            ans[i][0] = ((ans[i-1][0] + ans[i-1][1]) * (1 + tops[i]) + ans[i-1][0])%10007;
        }
        
        int answer = (ans[n-1][0] + ans[n-1][1])%10007;
        return answer;
    }
}