package day_0828;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1012 {

	static class loc {
		int r;
		int c;

		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();

			int[][] map = new int[n][m];

			for (int i = 0; i < k; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = 1;
			}

			Queue<loc> q = new LinkedList<>();
			int ans = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0)	continue;
					ans++;
					q.offer(new loc(i, j));
					map[i][j] = 0;
					while (!q.isEmpty()) {
						loc cur = q.poll();
						for (int d = 0; d < 4; d++) {
							if (cur.r + dx[d] >= 0 && cur.r + dx[d] < n && cur.c + dy[d] >= 0 && cur.c + dy[d] < m) {
								if (map[cur.r + dx[d]][cur.c + dy[d]] == 1) {
									q.offer(new loc(cur.r + dx[d], cur.c + dy[d]));
									map[cur.r + dx[d]][cur.c + dy[d]] = 0;
								}
							}
						}

					}

				}
			}
			
			System.out.println(ans);

		}

	}

}
