import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for (int j=0;j<m;j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0;i<4;i++){
                int nextX = curX+dx[i];
                int nextY = curY+dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;
                queue.add(new int[]{nextX,nextY});
                map[nextX][nextY] = map[curX][curY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
