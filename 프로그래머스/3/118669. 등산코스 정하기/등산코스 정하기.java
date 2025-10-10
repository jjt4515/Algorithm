import java.util.*;

class Solution {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    static final int INF = Integer.MAX_VALUE;
    static int ansSummit = INF;
    static int ansIntensity = INF;
    
    static HashSet<Integer> gs;
    static HashSet<Integer> ss;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(summits);

        gs = new HashSet<>();
        ss = new HashSet<>();
        
        for (int k=0;k<gates.length;k++) {
            gs.add(gates[k]);
        }

        for (int k=0;k<summits.length;k++) {
            ss.add(summits[k]);
        }
         
        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0;i<paths.length;i++) {
            int s = paths[i][0];
            int e = paths[i][1];
            int c = paths[i][2];
            
            if (gs.contains(s) || ss.contains(e)) {
                graph.get(s).add(new Node(e,c));
                continue;
            } 
        
            if (gs.contains(e) || ss.contains(s)) {
                graph.get(e).add(new Node(s,c));
                continue;
            }
            
            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }

        return dijkstra(n, gates, summits);
    }
    
    public int[] dijkstra(int n, int[] gates, int[] summits) {
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        for(int gate: gs) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curV = cur.vertex;
            int curC = cur.cost;
            
            if (curC > intensity[curV])
                continue;
                
            for (Node next: graph.get(curV)) {
                int newV = next.vertex;
                int newC = next.cost;
                
                int dis = Math.max(newC, intensity[curV]);
                
                if (intensity[newV] > dis) {
                    intensity[newV] = dis;
                    pq.offer(new Node(newV, dis));
                }
            }
        }
        
        for (int summit: summits) {
            if (intensity[summit] < ansIntensity) {
                ansIntensity = intensity[summit];
                ansSummit = summit;
            }
        }
        
        return new int[]{ansSummit, ansIntensity};
    }
}

class Node {
    public int vertex;
    public int cost;
    public Node (int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}