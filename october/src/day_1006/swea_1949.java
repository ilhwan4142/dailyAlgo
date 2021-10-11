package day_1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1949 {

	static int N, K, ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visit;

	// locate 위치 저장 클래스
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

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			Queue<Loc> q = new LinkedList<>();
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max)
						q.add(new Loc(i, j));
				}
			}
			while (!q.isEmpty()) {
				Loc cur = q.poll();
				solution(cur.r, cur.c, 1, true);
			}

			sb.append("#" + tc + " " + ans); // 출력 예시
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString()); // 출력
	}

	static void solution(int r, int c, int cnt, boolean possible) {
		ans = Math.max(ans, cnt);
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 범위 및 방문 체크
			if (isRange(nr, nc) && !visit[nr][nc]) {
				// 낮으면 그냥 dfs
				if (map[nr][nc] < map[r][c]) {
					solution(nr, nc, cnt + 1, possible);
				}
				// 다음 지형이 높다면
				else {
					// 아직 공사를 안했다면
					if (possible) {
						// K 이하의 차이가 난다면
						if (map[nr][nc] - map[r][c] < K) {
							
							int tmp = map[nr][nc];
							
							map[nr][nc] = map[r][c] - 1;
							solution(nr, nc, cnt + 1, false);
							map[nr][nc] = tmp; // 원상복귀
						}
					}
				}
			}
		}
		// 방문 체크
		visit[r][c] = false;
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
