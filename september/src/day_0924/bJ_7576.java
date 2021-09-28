package day_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bJ_7576 {

	static class loc {
		int r, c;

		loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { -1, 1, 0, 0 };

		int cnt = -1;

		Queue<loc> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.add(new loc(i, j));
			}
		}

		while (!q.isEmpty()) {

			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				loc cur = q.poll();

				for (int d = 0; d < 4; d++) {

					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (range(nr, nc, n, m)) {

						if (map[nr][nc] == 0) {
							map[nr][nc] = 1;
							q.offer(new loc(nr, nc));
						}
					}
				}

			}
		}

		boolean jud = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					jud = true;
			}
		}

		if (jud)
			System.out.println(-1);
		else
			System.out.println(cnt);

	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y, int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
