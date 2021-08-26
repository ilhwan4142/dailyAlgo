package day_0813;

import java.util.Scanner;

public class swea_1247_v2 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static Point[] arr;
	static boolean[] sel;
	static int[] result;
	static Point home, company;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 987654321;
			company = new Point(sc.nextInt(), sc.nextInt());
			home = new Point(sc.nextInt(), sc.nextInt());
			arr = new Point[N];
			sel = new boolean[N];
			result = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = new Point(sc.nextInt(), sc.nextInt());
			perm(0, 0, company);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void perm(int idx, int dist, Point cur) {
		if (idx == N) {
			dist += (Math.abs(cur.x - home.x) + Math.abs(cur.y - home.y));
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (sel[i])
				continue;
			sel[i] = true;
			result[idx] = i;
			perm(idx + 1, dist + (Math.abs(cur.x - arr[i].x) + Math.abs(cur.y - arr[i].y)), arr[i]);
			sel[i] = false;
		}
	}
}