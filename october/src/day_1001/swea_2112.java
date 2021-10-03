package day_1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2112 {

	static int D, W, K, ans;
	static int[][] map, tmpmap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			tmpmap = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmpmap[i][j] = map[i][j];
				}
			}

			if (check(map)) {
				sb.append("#" + tc + " 0");
				sb.append(System.lineSeparator());
			} else {
				ans = Integer.MAX_VALUE;
				powset(0, 0);
				sb.append("#" + tc + " " + ans);
				sb.append(System.lineSeparator());
			}

		}

		System.out.println(sb.toString());

	}

	public static boolean check(int[][] testmap) {

		for (int i = 0; i < W; i++) {

			int numA = 0;
			int numB = 0;
			int maxA = 0;
			int maxB = 0;
			for (int j = 0; j < D; j++) {
				if (testmap[j][i] == 0) {
					numA++;
					maxA = Math.max(maxA, numA);
					if (j < D - 1) {
						if (testmap[j + 1][i] == 1)
							numA = 0;
					}
				}

				else {
					numB++;
					maxB = Math.max(maxB, numB);
					if (j < D - 1) {
						if (testmap[j + 1][i] == 0)
							numB = 0;
					}
				}

			}
			if (maxA < K && maxB < K) {
				return false;
			}
		}

		return true;
	}

	public static void powset(int idx, int cnt) {

		if (ans < cnt)
			return;

		if (idx == D) {
			if (check(tmpmap)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}

		powset(idx + 1, cnt);

		for (int c = 0; c < W; ++c)
			tmpmap[idx][c] = 0;
		powset(idx + 1, cnt + 1);

		for (int c = 0; c < W; ++c)
			tmpmap[idx][c] = 1;
		powset(idx + 1, cnt + 1);

		for (int c = 0; c < W; ++c)
			tmpmap[idx][c] = map[idx][c];

	}

}
