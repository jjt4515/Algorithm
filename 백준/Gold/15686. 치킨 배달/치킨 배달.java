
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] open;
    static int M;
    static int N;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 1) {
                    home.add(new Point(i,j));
                } else if (graph[i][j] == 2) {
                    chicken.add(new Point(i,j));
                }
            }
        }

        open = new boolean[chicken.size()];

        backTracking(0, 0);
        System.out.println(ans);
    }

    static void backTracking(int start, int depth) {
        if (depth == M) {
            int[] distances = new int[home.size()];
            for (int i=0;i<home.size();i++) {
                int min = Integer.MAX_VALUE;
                for (int j=0;j<chicken.size();j++) {
                    if (!open[j])
                        continue;
                    Point h = home.get(i);
                    Point c = chicken.get(j);
                    int distance = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                    min = Math.min(min, distance);
                }
                distances[i] = min;
            }
            int sum = 0;
            for (int d : distances) {
                sum += d;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for (int i=start;i<chicken.size();i++) {
            open[i] = true;
            backTracking(i+1, depth+1);
            open[i] = false;
        }
    }
}
