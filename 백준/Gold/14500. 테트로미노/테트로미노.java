

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int ans;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        map = new int[N][M];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                visited[i][j] = true;
                dfs(i,j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int i,int j, int sum, int depth){
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int k=0;k<4;k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            if (!visited[nx][ny]){
                if (depth == 2){
                    visited[nx][ny] = true;
                    dfs(i, j, sum + map[nx][ny], depth + 1);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

}
