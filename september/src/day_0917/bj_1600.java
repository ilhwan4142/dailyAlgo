package day_0917;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1600 {

	static class loc {
		int x;
		int y;
		int dis;
		int jump;

		public loc(int x, int y, int dis, int jump) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.jump = jump;
		}
	}

	static int k, n, m;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] hm = { { -2, 1 }, { -2, -1 }, { -1, 2 }, { -1, -2 }, { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();

		int[][] map = new int[n][m];
		boolean[][][] v = new boolean[k + 1][n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Queue<loc> q = new LinkedList<>();

		q.add(new loc(0, 0, 0, 0));

		v[0][0][0] = true;

		while (!q.isEmpty()) {
			loc cur = q.poll();
			// System.out.println(cur.x + " " + cur.y+ " " + cur.dis + " " + cur.jump);
			if (cur.x == n - 1 && cur.y == m - 1) {
				System.out.println(cur.dis);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (map[nx][ny] == 1)
					continue;

				if (v[cur.jump][nx][ny])
					continue;

				q.add(new loc(nx, ny, cur.dis + 1, cur.jump));
				v[cur.jump][nx][ny] = true;

			}

			if (cur.jump == k)
				continue;

			for (int i = 0; i < 8; i++) {
				int nx = cur.x + hm[i][0];
				int ny = cur.y + hm[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (map[nx][ny] == 1)
					continue;

				if (v[cur.jump + 1][nx][ny])
					continue;

				q.add(new loc(nx, ny, cur.dis + 1, cur.jump + 1));
				v[cur.jump + 1][nx][ny] = true;
			}
		}

		System.out.println(-1);
	}
}
