package day_0809;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea_9229 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int max = 0;
			for(int i = 0; i < n-1; i++) {
				for(int j = i + 1; j < n; j++) {
					if(i == j) continue;
					if(a[i]+a[j]<=m&&max<a[i]+a[j]) {
						max = a[i]+a[j];
					}
				}
			}

			max = max==0? -1:max;

			System.out.println("#"+tc+" "+ max);
		}
	}

}
