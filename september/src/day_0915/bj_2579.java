package day_0915;

import java.util.Scanner;

public class bj_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = sc.nextInt();

		int[] stair = new int[total + 1];
		int[] dp = new int[total + 1];
		for (int i = 1; i <= total; i++) {
			stair[i] = sc.nextInt();
		}

		if (total == 1) {
			System.out.println(stair[1]);
			System.exit(0);
		}

		else if (total == 2) {
			System.out.println(stair[1] + stair[2]);
			System.exit(0);
		}

		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		dp[3] = Math.max(stair[1], stair[2]) + stair[3];

		for (int n = 4; n <= total; n++) {
			dp[n] = Math.max(dp[n - 3] + stair[n - 1], dp[n - 2]) + stair[n];
		}

		System.out.println(dp[total]);

	}

}
