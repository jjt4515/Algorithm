
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static int[] parents;
    static ArrayList<Edge> edges = new ArrayList<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        for (int i=1;i<=V;i++){
            parents[i] = i;
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }

        Collections.sort(edges);
        int ans = 0;
        for (Edge e : edges) {
            int from = e.v1;
            int to = e.v2;
            int cost = e.w;

            if (isCycle(from, to))
                continue;

            union(from, to);
            ans += cost;

        }

        System.out.println(ans);


    }

    static boolean isCycle (int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        return aRoot == bRoot;
    }

    static int find (int x){
        if (parents[x] == x){
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot){
            parents[bRoot] = aRoot;
        } else {
            parents[aRoot] = bRoot;
        }
    }

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int w;
        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        public int compareTo (Edge e){
            return w - e.w;
        }
    }





}


