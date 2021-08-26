package day_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class loc_15686{
	int sero;
	int garo;
	loc_15686(int sero, int garo) {
		this.sero = sero;
		this.garo = garo;
	}
	
}
public class bj_15686 {
	static int sum = 10000;
	static int n, m;
	static loc_15686[] chicken;
	static loc_15686[] home;
	static int cidx;
	static int hidx;
	static boolean[] sel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];
		
		cidx = 0;
		hidx = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2)cidx++;
				else if(map[i][j]==1) hidx++;
			}
		}
		
		chicken = new loc_15686[cidx];
		sel = new boolean[cidx];
		home = new loc_15686[hidx];
		
		cidx = 0;
		hidx = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==2)
					chicken[cidx++] = new loc_15686 (i, j);
				else if(map[i][j]==1)
					home[hidx++] = new loc_15686 (i, j);
				
			}
		}
		
		powerSet(0);
		System.out.println(sum);
	}
	
	static void powerSet(int idx) {
		
		int cnt = 0;
		if( idx == cidx) {
			for(int i = 0; i< cidx; i++) {
				if(sel[i]) {
					cnt++;
				}
			}
			if(cnt == m) {
				int[] dis = new int[hidx];
				int didx = 0;
				for(int i = 0; i< hidx; i++) {
					int min = 100;
					for (int j = 0; j < cidx; j++) {
						if (sel[j]) {
							int tmp = Math.abs(home[i].sero - chicken[j].sero)
									+ Math.abs(home[i].garo - chicken[j].garo);
							min = min > tmp ? tmp : min;
						}
					}
					dis[didx++] = min;
				}
				int tmp = 0;
				for(int i = 0; i < didx; i++) {
					tmp += dis[i];
				}
				
				sum = sum >tmp? tmp: sum;
			}
			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}

}