package day_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178 {

	static int n, m;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		mzs(0, 0);

		System.out.println(map[n - 1][m - 1]);
	}

	static class loc {
		int x;
		int y;

		public loc(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void mzs(int x, int y) {
		Queue<loc> q = new LinkedList();
		q.offer(new loc(x, y));
		while (!q.isEmpty()) {
			loc cur = q.poll();
			for (int i = 0, nx, ny; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				if (range(nx, ny) && map[nx][ny] == 1) {
					map[nx][ny] = map[cur.x][cur.y] + 1;
					q.offer(new loc(nx, ny));
				}
			}
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
