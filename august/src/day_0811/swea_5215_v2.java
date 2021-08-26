package day_0811;

import java.util.Scanner;

public class swea_5215_v2 {
	static int[] tas;
	static int[] kal;
	static int N;
	static int K;
	static int score;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			tas = new int[N];
			kal = new int[N];
			K = sc.nextInt();
			score = 0;
			for (int i = 0; i < N; i++) {
				tas[i] = sc.nextInt();
				kal[i] = sc.nextInt();
			}
			powerSum(0, 0, 0);
			System.out.println("#" + tc + " " + score);
		}
	}

	static void powerSum(int idx, int tsum, int ksum) {
		if (ksum > K)
			return;

		if (idx == N) {
			score = score > tsum ? score : tsum;

			return;
		}
		powerSum(idx + 1, tsum + tas[idx], ksum + kal[idx]);
		powerSum(idx + 1, tsum, ksum);
	}
}