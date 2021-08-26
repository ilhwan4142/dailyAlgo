package day_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3289 {
	
	static int[] narr;
	
	// a가 속한 집합의 대표자 찾기
	private static int find( int a) {
		if (a == narr[a])
			return a; // 자신이 대표자
		return narr[a] = find(narr[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		narr[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			narr = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				narr[i] = i;
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				if (c == 1) {
					if (find(f) == find(s))
						sb.append("1");
					else
						sb.append("0");
				} else {
					union(f, s);
				}
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}
}
