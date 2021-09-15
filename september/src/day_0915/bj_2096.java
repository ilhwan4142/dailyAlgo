package day_0915;

import java.util.Scanner;

public class bj_2096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] stair = new int[n + 1][3];
		int[][] dp1 = new int[n + 1][3];
		int[][] dp2 = new int[n + 1][3];
		int max = 0;
		int min = 1000000;
		for (int i = 1; i <= n; i++) {
			stair[i][0] = sc.nextInt();
			stair[i][1] = sc.nextInt();
			stair[i][2] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			dp1[1][i] = stair[1][i];
			dp1[1][i] = stair[1][i];
			dp1[1][i] = stair[1][i];
			dp2[1][i] = stair[1][i];
			dp2[1][i] = stair[1][i];
			dp2[1][i] = stair[1][i];
		}

		for (int i = 2; i <= n; i++) {
			dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]) + stair[i][0];
			dp1[i][1] = Math.max(Math.max(dp1[i - 1][0], dp1[i - 1][1]), dp1[i - 1][2]) + stair[i][1];
			dp1[i][2] = Math.max(dp1[i - 1][1], dp1[i - 1][2]) + stair[i][2];
		}
		
		for (int i = 2; i <= n; i++) {
			dp2[i][0] = Math.min(dp2[i - 1][0], dp2[i - 1][1]) + stair[i][0];
			dp2[i][1] = Math.min(Math.min(dp2[i - 1][0], dp2[i - 1][1]), dp2[i - 1][2]) + stair[i][1];
			dp2[i][2] = Math.min(dp2[i - 1][1], dp2[i - 1][2]) + stair[i][2];
		}

		for (int i = 0; i < 3; i++) {
			max = dp1[n][i] > max ? dp1[n][i] : max;
			min = dp2[n][i] < min ? dp2[n][i] : min;
		}

		System.out.println(max + " " + min);
	}
}
