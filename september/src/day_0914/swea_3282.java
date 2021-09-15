package day_0914;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3282 {

	public static void main(String[] args) throws IOException {
		// 입출력을 위한 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		// 전체 테스트케이스 개수
		int T = Integer.parseInt(st.nextToken());

		// 테스트케이스만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 전체 개수
			int n = Integer.parseInt(st.nextToken());
			// 가방 부피
			int k = Integer.parseInt(st.nextToken());

			int[][] vc = new int[n + 1][2];
			int[][] dp = new int[n + 1][k + 1];

			// 입력 받음
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				vc[i][0] = Integer.parseInt(st.nextToken());
				vc[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= k; i++) {
				dp[0][i] = 0;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					if (vc[i][0] > j)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vc[i][0]] + vc[i][1]);
				}
			}
			sb.append("#" + tc + " " + dp[n][k]);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

}
