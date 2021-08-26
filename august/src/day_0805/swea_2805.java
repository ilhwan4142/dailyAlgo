package day_0805;

import java.util.Scanner;

public class swea_2805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++) {
			
			int n = sc.nextInt();
			
			int[][] map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				String stmp = sc.next();
				for(int j = 0; j < n; j++) {
					int itmp = stmp.charAt(j) - '0';
					map[i][j] = itmp;
				}
			}
			
			int midS = n/2;
			int sum = 0;
			int change = 0;
			while(midS >= change) {
				if(change == 0) {
					for(int i = 0; i < n; i++) {
						sum += map[midS][i];
					}
				}
				else {
					for(int i = 0+change; i <n-change; i++) {
						sum += map[midS-change][i];
						sum += map[midS+change][i];
					}
				}
				change++;
			}
			
			System.out.printf("#"+tc+" "+sum);
            System.out.println();
		}
		
	}

}