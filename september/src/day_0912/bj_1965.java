package day_0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1965 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 전체 크기 입력 받음
		int n = Integer.parseInt(st.nextToken());

		// 상자 크기를 저장할 배열
		int[] dp = new int[n + 1];
		// dp 값을 저장할 배열
		int[] value = new int[n + 1];
		// 최댓값 저장 변수
		int max = 0;

		// 상자 크기들을 입력 받음
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}

		// n 이하인 i들에 대하여
		for (int i = 1; i <= n; i++) {
			value[i] = 1;
			// i 이하인 j들에 대하여
			for (int j = 1; j < i; j++) {
				// j번째 값이 i번째 보다 작고 
				if (dp[j] < dp[i] && value[i] <= value[j]) {
					value[i] = value[j] + 1;
				}
				max = Math.max(max, value[i]);
			}
		}
		System.out.println(max);
	}

}