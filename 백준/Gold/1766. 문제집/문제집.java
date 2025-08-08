
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> nexts = new ArrayList<>();
        int[] indegree = new int[n+1];

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nexts.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nexts.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=1;i<=n;i++) {
            if (indegree[i]==0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int node = pq.poll();
            results.add(node);

            for (int next : nexts.get(node)) {
                indegree[next]--;
                if (indegree[next]==0) {
                    pq.add(next);
                }
            }
        }

        for (int node : results) {
            System.out.print(node + " ");
        }

    }

}
