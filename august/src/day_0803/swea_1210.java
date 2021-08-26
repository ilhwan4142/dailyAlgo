package day_0803;

import java.util.Scanner;

public class swea_1210 {

	public static int[][] map;
	public static int dest;
	
	public static void move(int sero, int garo) {
		map[sero][garo]=2;
		if(sero == 0) {
			dest = garo;
			return;		
		}
		else {
			if(garo-1>=0) {
				if(map[sero][garo-1]==1) {
					move(sero,garo-1);
					return;
				}
			}
			if(garo+1<100) {
				if(map[sero][garo+1]==1) {
					move(sero,garo+1);
					return;
				}
			}
			
			move(sero-1,garo);
			return;
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		for(int tc =1; tc<=10; tc++) {
			
			int T = sc.nextInt();
			map = new int[100][100];
			int start = 0;
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						start = j;
					}
				}
			}
			move(99,start);
			System.out.println("#"+tc+" "+dest);
		}
		
	}

}