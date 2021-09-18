package day_0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3307 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

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

			sb.append("#" + tc + " " + answer);
			sb.append(System.lineSeparator());
		}
		
		System.out.println(sb.toString());
		
	}
}
