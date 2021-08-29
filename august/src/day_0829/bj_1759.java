package day_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1759 {

	static int l, c;
	static char[] total;
	static char[] pass;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		total = new char[c];
		pass = new char[l];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < c; i++) {
			String tmp = st.nextToken();
			total[i] = tmp.charAt(0);
		}
		Arrays.sort(total);
		per(0, 0);
		System.out.println(sb.toString());
	}

	public static void per(int cnt, int start) {
		if (cnt == l) {
			int cnta = 0;
			int cntb = 0;
			for (int i = 0; i < l; i++) {
				if (pass[i] == 'a' || pass[i] == 'e' || pass[i] == 'i' || pass[i] == 'o' || pass[i] == 'u')
					cnta++;
				else
					cntb++;
			}
			if (cnta < 1 || cntb < 2)
				return;

			for (int i = 0; i < l; i++) {
				sb.append(pass[i]);
			}
			sb.append(System.lineSeparator());
			return;
		}
		for (int i = start; i < c; i++) {
			pass[cnt] = total[i];
			per(cnt + 1, i + 1);
		}

	}

}
