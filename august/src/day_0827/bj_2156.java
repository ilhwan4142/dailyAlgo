package day_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] grape = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			grape[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.println(grape[0]);
		} else if (n == 2) {
			System.out.println(grape[0] + grape[1]);
		} else {
			dp[0] = grape[0];
			dp[1] = dp[0] + grape[1];
			dp[2] = Math.max(dp[1], Math.max(grape[1] + grape[2], grape[0] + grape[2]));

			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(dp[i - 3] + grape[i] + grape[i - 1], dp[i - 2] + grape[i]);
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}
			System.out.println(dp[n - 1]);
		}
	}

}
