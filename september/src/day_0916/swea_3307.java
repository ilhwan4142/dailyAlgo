package day_0916;

import java.util.Scanner;

public class swea_3307 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N + 1];
			for (int i = 1; i <= N; i++)
				arr[i] = sc.nextInt();

			int[] dp = new int[N + 1];

			int answer = 0;

			for (int i = 1; i <= N; i++) {

				int max = 0;

				for (int j = 0; j < i; j++)
					if (arr[j] < arr[i])
						max = Math.max(max, dp[j]);

				dp[i] = max + 1;
				answer = Math.max(answer, dp[i]);
			}

			System.out.println("#" + tc + " " + answer);
			
		}

	}
}
