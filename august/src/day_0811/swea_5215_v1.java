package day_0811;

import java.util.Scanner;

public class swea_5215_v1 {
	static int[] tas;
	static int[] kal;
	static boolean[] sel;
	static int N;
	static int K;
	static int score;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			tas = new int[N];
			kal = new int[N];
			sel = new boolean[N];
			K = sc.nextInt();
			score = 0;
			for(int i = 0; i < N; i++) {
				tas[i] = sc.nextInt();
				kal[i] = sc.nextInt();		}
			powerSet(0);
			System.out.println("#" + tc + " " + score);
		}
		
	}
	
	static void powerSet(int idx) {
		
		int tsum = 0;
		int ksum = 0;
		if( idx == N) {
			for(int i = 0; i< N; i++) {
				if(sel[i]) {
					tsum +=tas[i];
					ksum +=kal[i];
				}
			}
			if (ksum < K) {
				score = tsum>score? tsum:score;
			}
			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
}