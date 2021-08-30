package day_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1107 {

	static int dest, rst;
	static boolean[] key;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		dest = Integer.parseInt(br.readLine());
		int but = Integer.parseInt(br.readLine());

		key = new boolean[10];
		if (but != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < but; i++)
				key[Integer.parseInt(st.nextToken())] = true;
		}
		// 초기값은 100번에서 + - 버튼으로만 간 횟수
		rst = Math.abs(dest - 100);

		dfs(0, "");

		System.out.println(rst);
	}

	// 완전 탐색
	static void dfs(int idx, String num) {

		// 500,000 보다 큰 경우가 없으므로 종료
		if (idx > 5)
			return;

		for (int i = 0; i < 10; i++) {
			// 고장난 버튼은 패스
			if (key[i])
				continue;
			String nowNum = num + Integer.toString(i);
			int cnt = Math.abs(dest - Integer.parseInt(nowNum)) + nowNum.length();
			rst = Math.min(rst, cnt);
			dfs(idx + 1, nowNum);
		}
	}
}
