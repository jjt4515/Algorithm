import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int v = Integer.parseInt(str[2]);

        graph = new int[n+1][n+1];

        for(int i = 0; i < m; i++) {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);

        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);
    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if(v > graph.length - 1) {
            return;
        }

        for(int next = 1; next < graph.length; next++) {
            if(graph[v][next] == 1 && visited[next] == false) {
                dfs(next);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int next = 1; next < graph.length; next++) {
                if(graph[temp][next] == 1 && visited[next] == false) {
                    queue.add(next);
                    visited[next] = true;
                    System.out.print(next + " ");
                }
            }
        }
    }
}
