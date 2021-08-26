package day_0809;

import java.util.Scanner;
import java.util.StringTokenizer;

public class swea_7102 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		   
		for(int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(m == n) {
				System.out.println("#"+tc+" "+(n+1));
			}
			else if( n > m ) {
				System.out.printf("#"+tc+" ");
				for(int i = 1; i <= n-m+1; i++) {
					System.out.printf("%d ",m+i);
				}
				System.out.println();
			}
			else if( m > n ){
				System.out.printf("#"+tc+" ");
				for(int i = 1; i <= m-n+1; i++) {
					System.out.printf("%d ",n+i);
				}
				System.out.println();
			}
			
		}
	}

}
