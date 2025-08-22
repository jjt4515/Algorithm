import java.util.*;

class Solution {
    static int[] dis;
    static int ans1 = 0;
    static int ans2 = 0;
    static int userNum = 0;
    static int emoNum = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        userNum = users.length;
        emoNum = emoticons.length;
        dis = new int[emoNum];

        dfs(0, users, emoticons);
        int[] answer = {ans1, ans2};
        return answer;
    }
    
    public void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == emoNum) {
            int plus = 0;
            int sell = 0;

            for (int i=0;i<userNum;i++) {
                int percent = users[i][0];
                int temp = 0;
                for (int j=0;j<emoNum;j++) {
                    if (percent <= dis[j]) {
                        temp += emoticons[j] * (100-dis[j]) / 100;   
                    }
                }
                
                if (temp >= users[i][1]) {
                    plus += 1;
                } else {
                    sell += temp;
                }
            }
            if (plus > ans1) {
                ans1 = plus;
                ans2 = sell;
            } else if(plus == ans1) {
                if (sell > ans2) {
                    ans2 = sell;
                }
            }
            
            return;
        }
        for (int i=0;i<=4;i++) {
            dis[depth] = i*10;
            dfs(depth+1, users, emoticons); 
        }
        
    }
}