
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<Problem> set = new TreeSet<>();
        HashMap<Integer,Problem> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            Problem prob = new Problem(number, level);
            set.add(prob);
            map.put(number, prob);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Problem prob = new Problem(number, level);
                set.add(prob);
                map.put(number, prob);

            }else if(str.equals("recommend")){
                if(Integer.parseInt(st.nextToken()) > 0){
                    sb.append(set.first().number).append("\n");
                }else{
                    sb.append(set.last().number).append("\n");
                }
            }else{
                int number = Integer.parseInt(st.nextToken());
                set.remove(map.get(number));
                map.remove(number);
            }
        }
        System.out.println(sb);
    }

    static class Problem implements Comparable<Problem> {

        int number;
        int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (level == o.level) {
                return o.number - number;
            }
            return o.level - level;
        }
    }


}


