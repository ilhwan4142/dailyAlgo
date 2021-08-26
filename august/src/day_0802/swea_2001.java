package day_0802;

import java.util.Scanner;

public class swea_2001 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) map[i][j] = sc.nextInt();
			}
			int max = 0;
			for(int i = 0; i<n-(m-1); i++) {
				for(int j = 0; j<n-(m-1); j++) {
					int tmp = 0;
					for(int sero = 0; sero<m; sero++) {
						for(int garo =0; garo<m; garo++) {
							tmp += map[i+sero][j+garo];
						}
					}
					if(tmp>max) max = tmp;
				}
			}
			
			System.out.println("#" + tc + " "+ max);
			
		}

	}

}
