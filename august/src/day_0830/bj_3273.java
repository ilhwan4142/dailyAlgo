package day_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];

		int ans = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		int val = Integer.parseInt(br.readLine());

		for (int i = 0; i < n - 1; i++) {
			if (num[i] > val) break;
			for (int j = i + 1; j < n; j++) {
				if (num[i] + num[j] == val)
					ans++;
				else if (num[i] + num[j] > val)
					break;
			}
		}

		System.out.println(ans);
	}

}
