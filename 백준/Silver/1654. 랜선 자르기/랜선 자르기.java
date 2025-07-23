import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lens =  new int[k];

        long min = 1;
        long max = 0;

        for (int i = 0; i < k; i ++)
        {
            lens[i] = Integer.parseInt(br.readLine());
            if (max < lens[i])
                max = lens[i];
        }
        
        max++;

        while (min < max)
        {
            long mid = (min + max) / 2;
            int cnt = 0;

            for (int i = 0; i < k; i++)
            {
                cnt += lens[i] / mid;
            }

            if (cnt < n){
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }

}