import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {

        int neededAl = 0;
        int neededCo = 0;
        for (int[] problem: problems) {
            neededAl = Math.max(problem[0], neededAl);
            neededCo = Math.max(problem[1], neededCo);
        }
        
        if (neededAl <= alp && neededCo <= cop)
            return 0;
        
        if (alp > neededAl) 
            alp = neededAl;
        if (cop > neededCo)
            cop = neededCo;
        
        int[][] dp = new int[neededAl+2][neededCo+2];
        
        for (int i=alp;i<=neededAl;i++) {
            for (int j=cop;j<=neededCo;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for (int i=alp;i<=neededAl;i++) {
            for (int j=cop;j<=neededCo;j++) {
                dp[i+1][j] = Math.min(dp[i][j] + 1, dp[i+1][j]);
                dp[i][j+1] = Math.min(dp[i][j] + 1, dp[i][j+1]);
                for (int[] problem: problems) {
                    int alp_req = problem[0];   
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];
                    
                    if (i >= alp_req && j >= cop_req) {
                        int nx = i+alp_rwd;
                        int ny = j+cop_rwd;
                        if (nx > neededAl && ny > neededCo) {
                            dp[neededAl][neededCo] = Math.min(dp[neededAl][neededCo], dp[i][j] + cost);
                        } else if (nx > neededAl) {
                            dp[neededAl][ny] = Math.min(dp[neededAl][ny], dp[i][j] + cost);
                        } else if (ny > neededCo) {
                            dp[nx][neededCo] = Math.min(dp[nx][neededCo], dp[i][j] + cost);
                        } else {
                            dp[nx][ny] = Math.min(dp[nx][ny], dp[i][j] + cost);
                        }
                    }
                }
            }
        }      

        return dp[neededAl][neededCo];
    }

                                           
                            
}