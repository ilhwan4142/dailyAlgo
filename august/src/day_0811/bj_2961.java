package day_0811;

import java.util.Scanner;

public class bj_2961 {
	static int[] s;
	static int[] ss;
	static boolean[] sel;
	static int N;
	static int score;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		s = new int[N];
		ss = new int[N];
		sel = new boolean[N];
		score =1000000000;
		for (int i = 0; i < N; i++) {
			s[i] = sc.nextInt();
			ss[i] = sc.nextInt();
		}
		powerSet(0);
		System.out.println(score);
		
	}
	
	static void powerSet(int idx) {
		
		int ssum = 1;
		int sssum = 0;
		if( idx == N) {
			for(int i = 0; i< N; i++) {
				if(sel[i]) {
					ssum *=s[i];
					sssum +=ss[i];
				}
			}
			if (ssum==1&&sssum==0)return;
			int tmp = Math.abs(sssum-ssum);
			score = tmp<score? tmp:score;

			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
}