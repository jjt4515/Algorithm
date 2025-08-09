import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }

        int cnt = 0;
        int ans = 0;
        for (int i=0;i<=2*K;i++){
            if (i > 1000000)
                break;
            cnt += arr[i];
            ans = Math.max(ans,cnt);
        }
        for (int i=K+1;i<1000001-K;i++){
            cnt -= arr[i-K-1];
            cnt += arr[i+K];
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }





}


