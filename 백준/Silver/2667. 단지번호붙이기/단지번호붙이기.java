
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int n;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;
    static int[] cnts =  new int[25*25];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for (int j=0;j<n;j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        visited = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j]==1 && visited[i][j]==0) {
                    cnt += 1;
                    visited[i][j] = cnt;
                    cnts[cnt] += 1;
                    bfs(i,j);
                }
            }
        }

        System.out.println(cnt);
        Arrays.sort(cnts);
        for(int i=0;i<cnts.length; i++) {
            if(cnts[i]>0)
                System.out.println(cnts[i]);
        }


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

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                if (visited[nextX][nextY] != 0 || map[nextX][nextY] == 0)
                    continue;
                queue.add(new int[]{nextX,nextY});
                visited[nextX][nextY] = cnt;
                cnts[cnt] += 1;
            }
        }
    }
}
