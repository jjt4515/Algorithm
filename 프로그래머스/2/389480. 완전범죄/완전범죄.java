
import java.util.*;
class Solution {
    static int[][] dp;
    static int N;
    static int M;
    static int len;
    public int solution(int[][] info, int n, int m) {
        len = info.length;
        dp = new int[len][m];
        
        for (int i=0;i<len;i++)
            Arrays.fill(dp[i], 10000);

        dp[0][0] = info[0][0];
        if (info[0][1] < m)
            dp[0][info[0][1]] = 0;
        
        for (int i=1;i<len;i++) {
            int a = info[i][0];
            int b = info[i][1];
            for (int j=m-1;j>=0;j--) {
                if (dp[i-1][j] != 10000)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                    if (j+b < m) {
                            dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                    }
                }
            }
        }
        
        int ans = 10000;
        for (int k=0;k<m;k++) {
            if ( dp[len-1][k] != 10000) {
                ans = Math.min(dp[len-1][k], ans);
            }
        }

        if (ans >= n)
            ans = -1;

        return ans;
    }
}
