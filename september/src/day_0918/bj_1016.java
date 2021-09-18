package day_0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1016 {
	static long limit = 1000000;
	static long[] arr = new long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		setup();

		System.out.println(getCnt(max) - getCnt(min - 1));
	}

	static void setup() {
		arr[1] = 1;
		for (int i = 1; i <= limit; i++) {
			for (int j = 2 * i; j <= limit; j += i) {
				arr[j] -= arr[i];
			}
		}
	}

	static long getCnt(long k) {
		long ans = 0;
		for (long i = 1; i * i <= k; i++)
			ans += arr[(int) i] * k / (i * i);
		return ans;
	}
}
