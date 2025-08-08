

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int height=0;height<=100;height++) {
            ans = Math.max(ans, dfs(height));
        }

        System.out.println(ans);

    }


    static int dfs(int height) {
        int[][] temp = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (map[i][j] > height)
                    temp[i][j] = 1;
                else
                    temp[i][j] = 0;
            }
        }

        int area = 0;

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (temp[i][j] == 1) {
                    area++;
                    temp[i][j] = 0;

                    Stack<Point> stack = new Stack<>();
                    stack.push(new Point(i, j));
                    while (!stack.isEmpty()) {
                        Point now = stack.pop();
                        int x = now.x;
                        int y = now.y;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 1 && ny >= 1 && nx <= N && ny <= N && temp[nx][ny] == 1) {
                                stack.push(new Point(nx, ny));
                                temp[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
        }
        return area;
    }
}
