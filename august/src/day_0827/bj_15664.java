package day_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_15664 {

	public static int n;
	public static int m;
	public static int[] map;
	public static boolean[] visit;
	public static int[] rst;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n];
		visit = new boolean[n];
		rst = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(map);
		dfs(0, 0);
		System.out.println(sb.toString());

	}

	public static void dfs(int start, int cnt) {

		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(rst[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int save = 0;
		for (int i = start; i < n; i++) {
			if (visit[i])
				continue;
			if (save == map[i])
				continue;
			visit[i] = true;
			rst[cnt] = map[i];
			dfs(i + 1, cnt + 1);
			visit[i] = false;
			save = map[i];
		}


	}

}
