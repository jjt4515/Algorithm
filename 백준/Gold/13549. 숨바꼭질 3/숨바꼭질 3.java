

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
    }

    static void bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        visited[start] = 0;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now == K)
            {
                System.out.println(visited[now]);
                return;
            }

            if (now*2 <= 100000 && visited[now*2] == -1)
            {
                dq.offerFirst(now*2);
                visited[now*2] = visited[now];
            }

            if (now > 0 && visited[now-1] == -1)
            {
                dq.offerLast(now-1);
                visited[now-1] = visited[now] + 1;
            }

            if (now < 100000 && visited[now+1] == -1)
            {
                dq.offerLast(now+1);
                visited[now+1] = visited[now] + 1;
            }

        }
    }
}
