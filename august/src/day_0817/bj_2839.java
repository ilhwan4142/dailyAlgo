package day_0817;

import java.util.Scanner;

public class bj_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 100000000;
		for(int a = 0; a <=N/5; a++) {
			for(int b = 0; b <=N/3; b++) {
				if( a*5 + b*3 ==N) {
					ans = Math.min(ans,  a+b);
				}
			}
		}
		ans = ans == 100000000 ? -1 : ans;
		System.out.println(ans);
	}
}
