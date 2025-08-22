class Solution {
    static int N,M,R,C,K;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dir = {"d", "l", "r", "u"};
    static String answer = "z";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        if (distance(x,y) > k || (k - distance(x,y)) % 2 == 1)
            return "impossible";
        dfs(x,y,0,"");
        return answer;
    }
    
    public void dfs(int x, int y, int len, String route) {
        if(len + distance(x, y) > K || route.compareTo(answer) > 0){
            return;
        }        
        if (len == K && x == R && y == C) {
            answer = route;
            return;
        }
        for (int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx > 0 && nx <= N) && (ny > 0 && ny <= M)) {
                dfs(nx,ny,len+1,route+dir[i]);
            }
            
        }
    }
    
    public int distance(int x, int y) {
        return Math.abs(x-R) + Math.abs(y-C);
    }
}