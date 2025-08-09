
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static String arr, answer;
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = br.readLine().replace(" ", "");

        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=N;i++) {
            sb.append(i);
        }
        answer = sb.toString();

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, arr));
        visited.add(arr);

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.s.equals(answer)) {
                return now.cnt;
            }

            for (int i=0;i<=N-K;i++) {
                char[] charArr = now.s.toCharArray();
                for (int j=0;j<K/2;j++) {
                    char tmp = charArr[i+j];
                    charArr[i+j] = charArr[i+K-1-j];
                    charArr[i + K - 1 - j] = tmp;
                }

                String n = new String(charArr);

                if(!visited.contains(n)){
                    Pair tmpP = new Pair(now.cnt + 1, n);
                    q.add(tmpP);
                    visited.add(tmpP.s);
                }

            }
        }
        return -1;
    }


    public static class Pair{
        int cnt;
        String s;

        Pair(int cnt, String s)
        {
            this.cnt = cnt;
            this.s = s;
        }
    }
}


