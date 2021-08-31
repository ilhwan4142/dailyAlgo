package day_0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10819 {

	static int n;
	static int max = 0;
	static int[] input, rst;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		input = new int[n];
		rst = new int[n];
		v = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		perm(0);

		System.out.println(max);

	}

	static void perm(int cnt) {
		if (cnt == n) {
			int tmp = calc(rst);
			max = Math.max(max, tmp);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			rst[cnt] = input[i];
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}

	static int calc(int[] rst) {
		int val = 0;
		for (int i = 0; i < n - 1; i++) {
			val += Math.abs(rst[i] - rst[i + 1]);
		}
		return val;
	}
}
