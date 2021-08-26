package day_0810;

import java.util.Scanner;

public class swea_1233 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = 10;
		   
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			String dump = sc.next();
			int rst = 0;
			for(int i = 0; i < n; i++) {
				String[] s = sc.nextLine().split(" ");
				if(i < n / 2) {
					if(s[1].equals("+")||s[1].equals("-")||s[1].equals("*")||s[1].equals("/")) {
						rst = 1;
					}
					else {
						rst = 0;
					}
				}
				else {
					if(s[1].equals("+")||s[1].equals("-")||s[1].equals("*")||s[1].equals("/")) {
						rst = 0;
					}
				}
			}
			System.out.println("#"+tc+" "+rst);
		}
		   
	}
}