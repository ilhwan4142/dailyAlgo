package day_0813;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea_1247_v1 {
	static int n;
	static int min;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n + 2][2];
			check = new boolean[n + 2];
			int[] rst = new int[n + 2];
			min = 1000000000;

			map[0][0] = sc.nextInt();
			map[0][1] = sc.nextInt();

			map[n + 1][0] = sc.nextInt();
			map[n + 1][1] = sc.nextInt();

			for (int i = 1; i < n + 1; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}

			permutation(1, rst);
			System.out.println("#" + tc + " " + min);
		}
	}

	public static void permutation(int idx, int[] rst) {
		if (idx == n + 1) {
			int sum = 0;
			for (int i = 0; i < n + 1; i++) {
				sum += Math.abs(map[rst[i]][0] - map[rst[i + 1]][0]) + Math.abs(map[rst[i]][1] - map[rst[i + 1]][1]);
			}
			min = sum < min ? sum : min;
			return;
		}
		rst[0] = 0;
		check[0] = true;

		rst[n + 1] = n + 1;
		check[n + 1] = true;

		for (int i = 1; i < n + 1; i++) {
			if (check[i])
				continue;
			rst[idx] = i;
			check[i] = true;
			permutation(idx + 1, rst);
			check[i] = false;
		}

	}

}
