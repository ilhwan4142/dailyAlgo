package day_0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2138 {

	static int n, ans;
	static int[] cur, pur, tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		cur = new int[n];
		pur = new int[n];
		tmp = new int[n];
		String temp;

		temp = br.readLine();
		for (int i = 0; i < n; i++) {
			cur[i] = temp.charAt(i) - '0';
			tmp[i] = cur[i];
		}

		temp = br.readLine();
		for (int i = 0; i < n; i++) {
			pur[i] = temp.charAt(i) - '0';
		}

		sw(cur, 1, 0);
		tmp[0] = tmp[0] == 0 ? 1 : 0;
		tmp[1] = tmp[1] == 0 ? 1 : 0;
		sw(tmp, 1, 1);
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
	}

	static void ch(int[] arr, int idx) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (i >= 0 && i < n) {
				arr[i] = arr[i] == 0 ? 1 : 0;
			}
		}
	}

	public static void sw(int[] arr, int now, int cnt) {
		if (now == n) {
			if (arr[now - 1] == pur[now - 1])
				ans = Math.min(ans, cnt);
			return;
		}
		if (arr[now - 1] != pur[now - 1]) {
			ch(arr, now);
			sw(arr, now + 1, cnt + 1);
		} else
			sw(arr, now + 1, cnt);
	}

}