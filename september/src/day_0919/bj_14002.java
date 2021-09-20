package day_0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		int[] idx = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					idx[i] = j;
				}
			}
			if (dp[i] > max) {
				max = dp[i];
				maxIdx = i;
			}
		}
		int[] ans = new int[max];
		for (int i = max - 1; i >= 0; i--) {
			ans[i] = arr[maxIdx];
			maxIdx = idx[maxIdx];
		}
		sb.append(max);
		sb.append(System.lineSeparator());
		for (int i = 0; i < max; i++)
			sb.append(ans[i] + " ");
		System.out.println(sb);
	}
}
