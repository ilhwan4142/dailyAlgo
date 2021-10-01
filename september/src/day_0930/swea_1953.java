package day_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

	static int N, M, cnt;
	static int[][] map;
	static boolean[][] v;
	static int[][] dx = { { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int[][] dy = { { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
			{ 0, 0, -1, 0 }, { 0, 0, -1, 0 } };
	static int[][] check = { { 0, 3, 4, 7 }, { 0, 3, 5, 6 }, { 0, 2, 6, 7 }, { 0, 2, 4, 5 } };

	static class Loc {
		int r;
		int c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			v = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 1;
			v[R][C] = true;
			bfs(R, C, L);
			sb.append("#" + tc + " " + cnt);
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString());

	}

	public static void bfs(int r, int c, int time) {

		Queue<Loc> q = new LinkedList<>();

		q.add(new Loc(r, c));

		for (int i = 1; i < time; i++) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Loc loc = q.poll();
				int curR = loc.r;
				int curC = loc.c;

				if (map[curR][curC] != 0) {
					out: for (int d = 0; d < 4; d++) {
						int nr = curR + dx[map[curR][curC] - 1][d];
						int nc = curC + dy[map[curR][curC] - 1][d];
						if (range(nr, nc)) {
							if (!v[nr][nc]) {
								for (int k = 0; k < 4; k++) {
									if (check[d][k] == map[nr][nc])
										continue out;
								}
								cnt++;
								q.add(new Loc(nr, nc));
								v[nr][nc] = true;
							}
						}
					}
				}
			}
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
