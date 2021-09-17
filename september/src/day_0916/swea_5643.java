package day_0916;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class swea_5643 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int INF = 100000000;
		int N, M, ans, adj[][];

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			M = sc.nextInt();
			adj = new int[N + 1][N + 1];

			for (int i = 0; i <= N; i++) {
				Arrays.fill(adj[i], INF);
			}
			
			for (int i = 0; i < M; i++) {
				adj[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(adj[i][k]+adj[k][j] <adj[i][j])
							adj[i][j] = adj[i][k]+adj[k][j];
					}
				}
			}
			
			int[] isKnows = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adj[i][j] != INF) {
						isKnows[i]++;
						isKnows[j]++;
					}
				}
			}

			ans = 0;
			for (int i = 1; i <= N; i++) {
				if (isKnows[i] == N - 1) {
					ans++;
				}
			}
			

			System.out.println("#" + t + " " + ans);
		}
	}
}
