package day_0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_4485 {

	static int N;
	static int[][] map, rupee;
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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int cnt = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());

			// N이 0이면 종료
			if (N == 0)
				break;

			map = new int[N][N];
			rupee = new int[N][N];

			// 값 입력 받기 및 rupee에 최댓값 채우기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					rupee[i][j] = Integer.MAX_VALUE;
				}
			}

			// 초기값 동기화
			rupee[0][0] = map[0][0];

			// bfs 시작
			bfs();

			// 출력을 위해 StringBuffer에 출력내용 저장
			sb.append("Problem " + cnt++ + ": " + rupee[N - 1][N - 1]);
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
					if (rupee[nr][nc] > rupee[curR][curC] + map[nr][nc]) {
						rupee[nr][nc] = rupee[curR][curC] + map[nr][nc];
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
