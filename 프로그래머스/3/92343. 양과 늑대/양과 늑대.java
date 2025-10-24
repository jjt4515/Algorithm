import java.util.*;

class Solution {
    static int[][] gEdges;
    static int[] gInfo;
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        gEdges = edges;
        gInfo = info;
        boolean[] visited = new boolean[info.length];

        dfs(0, visited, 0, 0);
        return answer;
    }
    
    public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true;
        
        if (gInfo[idx] == 0) {
            sheepCnt++;
            if (sheepCnt > answer) answer = sheepCnt;
        } else {
            wolfCnt++;
        }
        
        if (wolfCnt >= sheepCnt) {
            return;
        }
        
        for (int[] edge: gEdges) {
            int p = edge[0];
            int c = edge[1];
            if (visited[p] && !visited[c]) {
                boolean[] newVisited = new boolean[gInfo.length];
                for (int i=0;i<gInfo.length;i++) {
                    newVisited[i] = visited[i];
                }
                dfs(c, newVisited, sheepCnt, wolfCnt);
            }
        }
    }
        
}