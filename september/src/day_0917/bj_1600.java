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
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class test {
//
//	static int k, n, m;
//	static int[][] map;
//	static boolean[][][] v;
//	static int[] dx = { 1, 0, -1, 0 };
//	static int[] dy = { 0, 1, 0, -1 };
//	static int[] hdx = { -2, -2, -1, -1, 1, 1, 2, 2 };
//	static int[] hdy = { 1, -1, 2, -2, 2, -2, 1, -1 };
//
//	static class loc {
//		int x;
//		int y;
//		int dis;
//		int jump;
//
//		public loc(int x, int y, int dis, int jump) {
//			this.x = x;
//			this.y = y;
//			this.dis = dis;
//			this.jump = jump;
//		}
//
//	}
//
//	static class xy {
//		int x;
//		int y;
//		int jump;
//
//		public xy(int x, int y, int jump) {
//			this.x = x;
//			this.y = y;
//			this.jump = jump;
//		}
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//		k = Integer.parseInt(st.nextToken());
//
//		st = new StringTokenizer(br.readLine(), " ");
//		m = Integer.parseInt(st.nextToken());
//		n = Integer.parseInt(st.nextToken());
//
//		map = new int[n][m];
//		v = new boolean[n][m][k + 1];
//		for (int i = 0; i < n; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			for (int j = 0; j < m; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		int ans = mzs(0, 0);
//
//		System.out.println(ans);
//
//	}
//
//	static int mzs(int x, int y) {
//		Queue<loc> q = new LinkedList<>();
//		q.add(new loc(x, y, 0, 0));
//		v[0][0][0] = true;
//		while (!q.isEmpty()) {
//			loc cur = q.poll();
//			if (cur.x == n - 1 && cur.y == m - 1)
//				return cur.dis;
//			for (int i = 0; i < 4; i++) {
//				int nx = cur.x + dx[i];
//				int ny = cur.y + dy[i];
//				if (range(nx, ny)) {
//					if (map[nx][ny] == 0) {
//						if (!v[nx][ny][cur.jump]) {
//							q.offer(new loc(nx, ny, cur.dis + 1, cur.jump));
//							v[nx][ny][cur.jump] = true;
//						}
//					}
//				}
//			}
//
//			if (cur.jump == k)
//				continue;
//			
//			for (int i = 0; i < 8; i++) {
//				int nx = cur.x + hdx[i];
//				int ny = cur.y + hdy[i];
//				if (range(nx, ny)) {
//					if (map[nx][ny] == 0) {
//						if (!v[nx][ny][cur.jump + 1]) {
//							if (cur.jump < k) {
//								q.offer(new loc(nx, ny, cur.dis + 1, cur.jump + 1));
//								v[nx][ny][cur.jump + 1] = true;
//							}
//						}
//					}
//				}
//			}
//
//		}
//
//		return -1;
//	}
//
//	static boolean range(int x, int y) {
//		return x >= 0 && x < n && y >= 0 && y < m;
//	}
//}