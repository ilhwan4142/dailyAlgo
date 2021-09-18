package day_0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1557 {
	static long limit = 1000000;
	static long[] arr = new long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long start = 0;
		long end = n * 2;

		setup();

		// n 번째를 찾기 위한 이분 탐색
		while (start < end - 1) {
			long mid = (start + end) / 2;
			if (getCnt(mid) < n)
				start = mid;
			else
				end = mid;
		}

		System.out.println(end);
	}

	// 포함 배제의 원리로 기본 세팅
	static void setup() {
		arr[1] = 1;
		for (int i = 1; i <= limit; i++) {
			for (int j = 2 * i; j <= limit; j += i) {
				arr[j] -= arr[i];
			}
		}
	}

	// 뫼비우스 함수의 원리로 갯수를 카운트 해줌
	static long getCnt(long k) {
		long ans = 0;
		for (long i = 1; i * i <= k; i++)
			ans += arr[(int) i] * k / (i * i);
		return ans;
	}
}
