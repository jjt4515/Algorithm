import java.util.*;
class Solution {
    static int N, S, A, B;
    static int[][] dist;
    static final int INF = 30000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        S = s;
        A = a;
        B = b;
        
        dist = new int[N+1][N+1];
        
        for (int i=0;i<=N;i++) {
            for (int j=0;j<=N;j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        
        for (int[] fare: fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
        
        boolean[] visited = new boolean[n+1];
        
        for (int k=1;k<=N;k++) {
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=N;j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        
        int minDst = INF;
        for (int v=1;v<=N;v++) {
            int totalDist = dist[s][v] + dist[v][a] + dist[v][b];
            if (totalDist < minDst) {
                minDst = totalDist;
            }
        }

        return minDst;
    }
    

}

class Edge {
    public int next;
    public int cost;
    public Edge(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}