package day_0811;

import java.util.Scanner;

public class swea_2817 {
	static int[] num;
	static boolean[] sel;
	static int N;
	static int K;
	static int cnt = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			num = new int[N];
			sel = new boolean[N];
			K = sc.nextInt();
			cnt = 0;
			for(int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			powerSet(0);
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	static void powerSet(int idx) {
		
		int sum = 0;
		if( idx == num.length) {
			for(int i = 0; i< num.length; i++) {
				if(sel[i]) {
					sum +=num[i];
				}
			}
			if (sum == K) cnt++;
			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
}
