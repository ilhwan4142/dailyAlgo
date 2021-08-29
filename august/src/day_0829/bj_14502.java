package day_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14502 {
	static int n, m;
	static int[][] map;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// 값 입력 받기위한 작업
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		wall(0, 0, 0);

		System.out.println(ans);
	}

	// 벽 만드는 함수
	static void wall(int x, int y, int cnt) {

		// 3개 이상이면 종료
		if (cnt > 3)
			return;

		// 3개 만들었으면 스탑
		if (cnt == 3) {
			simul();
			return;
		}
		for (int i = x; i < n; i++) {
			for (int j = y; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wall(i, y + 1, cnt + 1);
					map[i][j] = 0;
				}
			}
			y = 0;
		}
	}

	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, 1, -1, 0 };

	static class loc {
		int r;
		int c;

		loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 바이러스가 퍼지는 시뮬레이션
	static void simul() {
		// 임시 맵 생성
		int[][] mm = new int[n][m];
		// 맵 복붙
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mm[i][j] = map[i][j];
			}
		}
		// 바이러스 bfs 시작
		Queue<loc> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mm[i][j] == 2) {
					q.offer(new loc(i, j));
				}
			}
		}
		// 4방탐색
		while (!q.isEmpty()) {
			loc l = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = l.r + dx[d];
				int nc = l.c + dy[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if (mm[nr][nc] == 0) {
						mm[nr][nc] = 2;
						q.offer(new loc(nr, nc));
					}
				}

			}

		}

		// 안전지역 카운트
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mm[i][j] == 0)
					cnt++;
			}
		}

		// 값이 크면 갱신
		ans = ans < cnt ? cnt : ans;
	}

}
