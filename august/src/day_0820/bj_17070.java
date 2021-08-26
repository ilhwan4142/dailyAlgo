package day_0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17070 {

	static int N;
	static int[][] map;

	static int tcnt = 0;

	static boolean isPossible(int curR, int curC) {
		if(curR>=N||curC>=N)
			return false;
		return true;
	}

	public static void dfs(int curR, int curC, int d) {
		if (curR == N - 1 && curC == N - 1) {
			tcnt++;
			return;
		}

		// 파이프 가로
		if (d == 0) {
			// 가로
			if (isPossible(curR, curC + 1) && map[curR][curC + 1] == 0)
				dfs(curR, curC + 1, 0);
			// 대각선
			if (isPossible(curR + 1, curC + 1) && map[curR][curC + 1] == 0
					&& map[curR + 1][curC + 1] == 0 && map[curR + 1][curC] == 0)
				dfs(curR + 1, curC + 1, 2);
		}
		// 파이프 세로
		else if (d == 1) {
			// 세로
			if (isPossible(curR + 1, curC) && map[curR + 1][curC] == 0)
				dfs(curR + 1, curC, 1);
			// 대각선
			if (isPossible(curR + 1, curC + 1) && map[curR][curC + 1] == 0
					&& map[curR + 1][curC + 1] == 0 && map[curR + 1][curC] == 0)
				dfs(curR + 1, curC + 1, 2);
		}
		// 파이프 대각선
		else if (d == 2) {
			// 가로
			if (isPossible(curR, curC + 1) && map[curR][curC + 1] == 0)
				dfs(curR, curC + 1, 0);
			// 세로
			if (isPossible(curR + 1, curC) && map[curR + 1][curC] == 0)
				dfs(curR + 1, curC, 1);
			// 대각선
			if (isPossible(curR + 1, curC + 1) && map[curR][curC + 1] == 0
					&& map[curR + 1][curC + 1] == 0 && map[curR + 1][curC] == 0)
				dfs(curR + 1, curC + 1, 2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);

		System.out.println(tcnt);

	}

}
