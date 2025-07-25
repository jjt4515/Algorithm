import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int n = in.nextInt();
 
		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];
 
 
		for (int i = 1; i <= n; i++) {
			arr[i] =in.nextInt();
		}
        
		dp[1] = arr[1];
        
		if (n >= 2) {
			dp[2] = arr[1] + arr[2];
		}
 
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] , dp[i - 3] + arr[i - 1]) + arr[i];
		}
 
		System.out.println(dp[n]);
 
	}
 
}