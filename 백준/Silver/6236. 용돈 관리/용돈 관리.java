
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] money_arr;
    static int max = 0;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        money_arr = new int[n];

        for (int i=0;i<n;i++) {
            int money = Integer.parseInt(br.readLine());
            money_arr[i] = money;
            max = Math.max(max, money);
        }

        int left = max;
        int right = 10000 * 100000;
        int cnt = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (m >= getWithdrawalCount(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }

    static int getWithdrawalCount(int withdrawalAmount) {
        int count = 1;
        int money = withdrawalAmount;

        for (int i : money_arr) {
            money -= i;
            if (money < 0) {
                ++count;
                money = withdrawalAmount - i;
            }
        }
        return count;
    }
}
