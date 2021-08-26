package day_0802;

import java.util.Scanner;

public class bj_1244 {
	
	public static int[] s;
	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		s = new int[n];
		
		for(int i =0; i<n; i++) {
			s[i] = sc.nextInt();
		}
		
		int student = sc.nextInt();
		for(int i =0; i<student; i++) {
			int sexual = sc.nextInt();
			int num = sc.nextInt();
			changeS(sexual, num);
		}
		
		for(int i=0; i<s.length; i++) {
	         if(i>0 && i%20 == 0)
	            System.out.println();
	         System.out.print(s[i] + " ");
	      }
	}
	
	public static void changeS(int sexual, int num) {
		if(sexual == 1) {
			int tmp = n/num;
			for(int i =1; i<=tmp; i++) {
				if(s[i*num-1] == 1) s[i*num-1] = 0;
				else s[i*num-1] = 1;
			}
		}
		else if(sexual == 2) {
			if(s[num-1] == 1) s[num-1] = 0;
			else s[num-1] = 1;
			int cnt=1;
			while((num-1-cnt)>=0&&(num-1+cnt<n)) {
				if(s[num-1-cnt] != s[num-1+cnt]) break;
				if(s[num-1-cnt] == 1) {
					s[num-1-cnt] = 0;
					s[num-1+cnt] = 0;
				}
				else {
					s[num-1-cnt] = 1;
					s[num-1+cnt] = 1;
				}
				cnt++;
			}	
		}
	}

}