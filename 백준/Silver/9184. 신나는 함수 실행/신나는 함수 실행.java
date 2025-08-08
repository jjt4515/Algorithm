
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][][] dp = new int[21][21][21];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                return;

            int w = getW(a,b,c);

            printW(a,b,c,w);
        }
    }

    static void printW (int a, int b, int c, int result) {
        System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
    }

    static int getW (int a, int b, int c) {
        
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return getW(20,20,20);
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            dp[a][b][c] = getW(a, b, c - 1) + getW(a, b - 1, c - 1) - getW(a, b - 1, c);
        } else {
            dp[a][b][c] = getW(a-1, b, c) + getW(a-1, b-1, c) + getW(a-1, b, c-1) - getW(a-1, b-1, c-1);
        }

        return dp[a][b][c];
    }

}
