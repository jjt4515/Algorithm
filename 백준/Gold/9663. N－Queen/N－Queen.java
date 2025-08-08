

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int ans = 0;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       arr = new int[N];

       nQueen(0);
       System.out.println(ans);
    }

    static void nQueen(int depth){
        if (depth == N){
            ans++;
            return;
        }

        for (int i=0; i<N; i++){
            arr[depth] = i;
            if (isPossible(depth)){
                nQueen(depth+1);
            }
        }
    }

    static boolean isPossible(int col){
        for (int i=0; i<col; i++){
            if (arr[col] == arr[i])
                return false;

            else if (Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
