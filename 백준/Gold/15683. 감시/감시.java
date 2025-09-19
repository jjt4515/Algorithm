
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] temp;
    static int ctCnt;
    static CT[] ct;
    static int[] dir;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int ans = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ArrayList<CT> tempLst = new ArrayList<>();
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k > 0 && k < 6)
                    tempLst.add(new CT(i,j,k));

                map[i][j] = k;
            }
        }

        ct = tempLst.toArray(new CT[0]);
        ctCnt = ct.length;
        dir = new int[ctCnt];
        Arrays.fill(dir, -1);

        backtracking(0);
        System.out.println(ans);

    }

    public static void backtracking(int depth) {
        if (depth == ctCnt) {
            temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < ctCnt; i++) {
                CT node = ct[i];
                direction(node, dir[i]);
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 0)
                        cnt ++;
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 0;i<4;i++) {
            dir[depth] = i;
            backtracking(depth+1);
        }
    }

    public static void direction(CT cctv, int dir) {
        int cNum = cctv.num;
        if (cNum == 1) {
            if (dir == 0) watch(cctv, 0);
            else if (dir == 1) watch(cctv, 1);
            else if (dir == 2) watch(cctv, 2);
            else if (dir == 3) watch(cctv, 3);
        } else if (cNum == 2) {
            if (dir == 0 || dir == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else {
                watch(cctv, 1);
                watch(cctv, 3);
            }
        } else if (cNum == 3) {
            if (dir == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
            } else if (dir == 1) {
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (dir == 2) {
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (dir == 3) {
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if (cNum == 4) {
            if (dir == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (dir == 1) {
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (dir == 2) {
                watch(cctv, 2);
                watch(cctv, 3);
                watch(cctv, 0);
            } else if (dir == 3) {
                watch(cctv, 3);
                watch(cctv, 0);
                watch(cctv, 1);
            }
        } else if (cNum == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }

    }

    public static void watch(CT cctv, int lineDir) {
        Queue<int[]> q = new LinkedList<>();
        int[] start = {cctv.row, cctv.col};
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int nx = cur[0] + dx[lineDir];
            int ny = cur[1] + dy[lineDir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                break;

            if (temp[nx][ny] == 6)
                break;

            if (temp[nx][ny] == 0 || temp[nx][ny] == 7)
                temp[nx][ny] = 7;

            q.offer(new int[]{nx, ny});
        }
    }
}

class CT {
    public int row;
    public int col;
    public int num;
    public CT(int row, int col, int num) {
        this.row = row;
        this.col = col;
        this.num = num;
    }
}




