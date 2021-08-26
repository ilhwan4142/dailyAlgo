package day_0802;

import java.util.Scanner;

public class swea_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			long rst = 0;
			int tot = sc.nextInt();
			int[] day = new int[tot+1];
			for(int i = 1; i <= tot; i++) {
				day[i] = sc.nextInt();
			}
			int max = day[tot];
			for(int i = tot-1; i >= 1; i--) {
				if(day[i] < max) {
					rst += max - day[i];
				}
				else max = Math.max(day[i], max);
			}

			System.out.println("#" + tc + " " + rst);
		}	
		
	}

}