package day_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea_1249 {

	static int N;
	static int[][] map, dij;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static class Loc {
		int r;
		int c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			dij = new int[N][N];

			// 값 입력 받기 및 dij에 최댓값 채우기
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp.charAt(j) - '0';
					dij[i][j] = Integer.MAX_VALUE;
				}
			}

			// 초기값 동기화
			dij[0][0] = map[0][0];

			// bfs 시작
			bfs();

			// 출력을 위해 StringBuffer에 출력내용 저장
			sb.append("#" + tc + " " + dij[N - 1][N - 1]);
			sb.append(System.lineSeparator());
		}

		// 출력
		System.out.println(sb.toString());

	}

	public static void bfs() {

		Queue<Loc> q = new LinkedList<>();

		// 초기 값 삽입
		q.add(new Loc(0, 0));

		while (!q.isEmpty()) {
			Loc loc = q.poll();
			int curR = loc.r;
			int curC = loc.c;

			for (int i = 0; i < 4; i++) {

				int nr = curR + dx[i];
				int nc = curC + dy[i];

				// 범위 충족 확인
				if (range(nr, nc)) {

					// 다익스트라 알고리즘
					if (dij[nr][nc] > dij[curR][curC] + map[nr][nc]) {
						dij[nr][nc] = dij[curR][curC] + map[nr][nc];
						q.add(new Loc(nr, nc));
					}
				}
			}
		}
	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
