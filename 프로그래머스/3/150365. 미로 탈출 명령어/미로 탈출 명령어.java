import java.util.*;
class Solution {
    static int[][] dis;
    static int N, M, K, R, C;
    static int[] dx = {1,0,0,-1}; //아래, 왼, 우, 위
    static int[] dy = {0,-1,1,0};
    static char[] answer;
    static boolean flag = false;
    static char[] dirs = {'d','l','r','u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dis = new int[n+1][m+1];
        
        answer = new char[k];
        
        N = n;
        M = m;
        K = k;
        R = r;
        C = c;
        
        dis[r][c] = 0;

        makeDis(r,c);

        dfs(x,y,0);
        
        if (!flag)
            return "impossible";
        
        String ans = new String(answer);
        return ans;
    }
    
    public void makeDis(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        boolean[][] visited = new boolean[N+1][M+1];
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i=0;i<4;i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                
                if (overLine(nx,ny)) {
                    continue;
                }
                
                if (visited[nx][ny])
                    continue;
                
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                dis[nx][ny] = dis[p[0]][p[1]] + 1;
            }
        }
        
    }
    
    public void dfs(int x, int y, int depth) {
        if (depth == K) {
            if (x == R && y == C) {
                flag = true;
            }
            return;
        }
        
        for (int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (overLine(nx,ny))
                continue;
            
            if (dis[nx][ny] > K - depth - 1)
                continue;
            
            if ((K-depth-1 - dis[nx][ny]) % 2 == 1)
                continue;
            
            answer[depth] = dirs[i];

            dfs(nx,ny,depth+1);
            
            if (flag) 
                break;
        }
    }
    
    public boolean overLine(int r, int c) {
        if (r <= 0 || r > N || c <= 0 || c > M)
            return true;
        return false;
    }

}

