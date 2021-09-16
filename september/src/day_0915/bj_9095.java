package day_0915;

import java.util.Scanner;

public class bj_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] dp = new int[n + 1];
			
			if(n <= 2) {
				System.out.println(n);
				continue;
			}
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; 
			}

			System.out.println(dp[n]);
		}

	}

}
