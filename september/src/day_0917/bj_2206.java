package day_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2206 {

	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static boolean[][] vw;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class loc {
		int x;
		int y;
		int dis;
		int w;

		public loc(int x, int y, int dis, int w) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		vw = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		int ans = mzs(0, 0);

		System.out.println(ans);

	}

	static int mzs(int x, int y) {
		Queue<loc> q = new LinkedList<>();
		q.add(new loc(x, y, 1, 0));
		v[x][y] = true;
		vw[x][y] = true;

		while (!q.isEmpty()) {
			loc cur = q.poll();

			if (cur.x == n - 1 && cur.y == m - 1)
				return cur.dis;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (range(nx, ny)) {
					if (!v[nx][ny] && cur.w == 0) {
						if (map[nx][ny] == 0) {
							q.offer(new loc(nx, ny, cur.dis + 1, cur.w));
							v[nx][ny] = true;
						} else {
							q.offer(new loc(nx, ny, cur.dis + 1, 1));
							v[nx][ny] = true;
						}
					}
					if (!vw[nx][ny] && cur.w == 1) {
						if (map[nx][ny] == 0) {
							q.offer(new loc(nx, ny, cur.dis + 1, cur.w));
							vw[nx][ny] = true;
						}
					}

				}
			}
		}

		return -1;
	}

	static boolean range(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
