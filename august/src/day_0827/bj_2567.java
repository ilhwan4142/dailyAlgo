package day_0827;

import java.util.Scanner;

public class bj_2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] map = new int[100][100];
		
		int[] dx = {1,0,0,-1};
		int[] dy = {0,1,-1,0};
		
		int ans = 0;
		
		for(int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					map[x+j][y+k] = 1;
				}
			}
		}
		
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(map[j][k]==0) continue;
				if(j==0&&k==0) ans++;
				if(j==0&&k==99) ans++;
				if(j==99&&k==99) ans++;
				if(j==99&&k==0) ans++;
				if(j==0||k==0||j==99||k==99)
					ans++;
				for(int i = 0; i < 4; i++) {
					if(j+dx[i]>=0&&j+dx[i]<100&&k+dy[i]>=0&&k+dy[i]<100) {
						if(map[j+dx[i]][k+dy[i]]==0)
							ans++;
					}
				}
			}
		}
		System.out.println(ans);
		
	}

}
