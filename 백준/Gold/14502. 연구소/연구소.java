
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);
        System.out.println(ans);
    }

    static void backtracking(int depth) {
        if (depth == 3) {
            ans = Math.max(ans, dfs());
            return;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtracking(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int dfs() {
        int[][] visited = new int[N + 1][M + 1];
        Queue<Point> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = map[i][j];
                if (visited[i][j] == 2)
                    q.offer(new Point(i, j));
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 1 || ny < 1 || nx > N || ny > M)
                    continue;
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = 2;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j] == 0)
                    result++;
            }
        }
        return result;
    }
}
