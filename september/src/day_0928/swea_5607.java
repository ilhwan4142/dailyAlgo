package day_0928;

import java.util.Scanner;

public class swea_5607 {
	
	static final long P = 1234567891;

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		long[] facto = new long[1000001];
		facto[1] = 1;
		for (int i = 2; i <= 1000000; i++)
			facto[i] = facto[i - 1] * i % P;
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long ans = (facto[N] * power((facto[N - R] * facto[R] % P), P - 2)) % P;
			sb.append("#" + tc + " " + ans);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

	static long power(long n, long m) {
		if (m == 1)
			return n;
		long tmp = power(n, m / 2);
		if (m % 2 == 1)
			return tmp * tmp % P * n % P;
		else
			return tmp * tmp % P;
	}
}
