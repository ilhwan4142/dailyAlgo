package day_0915;

import java.util.Scanner;

public class bj_1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] home = new int[n + 1][3];
		int[][] dp = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			home[i][0] = sc.nextInt();
			home[i][1] = sc.nextInt();
			home[i][2] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			dp[1][i] = home[1][i];
			dp[1][i] = home[1][i];
			dp[1][i] = home[1][i];
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
		}

		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
	}

}
