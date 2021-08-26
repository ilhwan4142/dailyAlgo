package day_0818;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1992 {

	static int N;
	static int[][] map;
	static Queue<String> q = new LinkedList<>();

	static void dfs(int cur, int s, int g) {
		q.offer("(");
		
		int half = cur / 2;
		
		// 1사분면
		int sum1 = 0;
		for (int i = s; i < s+half; i++) {
			for (int j = g; j < g+half; j++) {
				sum1 += map[i][j];
			}
		}
		if (sum1 == half * half) {
			q.offer("1");
		} else if (sum1 == 0) {
			q.offer("0");
		}
		else {
			dfs(half, s, g);
		}
		
		// 2사분면
		int sum2 = 0;
		for (int i = s; i < s+half; i++) {
			for (int j = g+half; j < g+cur; j++) {
				sum2 += map[i][j];
			}
		}
		if (sum2 == half * half) {
			q.offer("1");
		} else if (sum2 == 0) {
			q.offer("0");
		}
		else {
			dfs(half, s, g+half);
		}
		
		// 3사분면
		int sum3 = 0;
		for (int i = s+half; i < s+cur; i++) {
			for (int j = g; j < g+half; j++) {
				sum3 += map[i][j];
			}
		}
		if (sum3 == half * half) {
			q.offer("1");
		} else if (sum3 == 0) {
			q.offer("0");
		}
		else {
			dfs(half, s+half, g);
		}
		
		// 4사분면
		int sum4 = 0;
		for (int i = s + half; i < s+cur; i++) {
			for (int j = g + half; j < g+cur; j++) {
				sum4 += map[i][j];
			}
		}
		if (sum4 == half * half) {
			q.offer("1");
		} else if (sum4 == 0) {
			q.offer("0");
		}
		else {
			dfs(half, s+half, g+half);
		}
		
		q.offer(")");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
				sum += map[i][j];
			}
		}
		
		if (sum == N * N) {
			System.out.println("1");
			System.exit(0);
		}
		if (sum == 0) {
			System.out.println("0");
			System.exit(0);
		}
		dfs(N, 0, 0);

		while (!q.isEmpty()) {
			System.out.print(q.poll());
		}

	}
}
