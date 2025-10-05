import java.util.*;
class Solution {
    static ArrayList<Integer>[] nodes;
    static int N;
    static int eLen;
    static int[] cnt = new int[3];
    
    static int[] toCnt;
    static int[] fromCnt;
    
    public int[] solution(int[][] edges) {
        N = 1000000;
        eLen = edges.length;
        
        int first = -1;
        nodes = new ArrayList[N+1];
        toCnt = new int[N+1];
        fromCnt = new int[N+1];
        
        for (int i=0;i<=N;i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int i=0;i<eLen;i++) {
            int start = edges[i][0];
            int next = edges[i][1];
            nodes[start].add(next);
            toCnt[start]++;
            fromCnt[next]++;
        }
        
        for (int i=1;i<=N;i++) {
            if (fromCnt[i] == 0 && toCnt[i] > 1) {
                first = i;
                break;
            }
        }
        
        for (int next: nodes[first]) {
            cnt[dfs(next, next)]++;
        }
        
        int[] answer = new int[4];
        answer[0] = first;
        answer[1] = cnt[0];
        answer[2] = cnt[1];
        answer[3] = cnt[2];
        return answer;
    }
    
    public int dfs(int cur, int start) {
        if (toCnt[cur] == 2) {
            return 2;
        } 
        
        if (toCnt[cur] == 0)
            return 1;

        int next = nodes[cur].get(0);
        
        if (next == start) {
            return 0;
        }
        
        return dfs(next, start);

    }
}