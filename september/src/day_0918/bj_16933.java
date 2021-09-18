package day_0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16933 {

	static int n, m, k;
	static int[][] map;
	static boolean[][][] v;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class loc {
		int x;
		int y;
		int dis;
		int w;

		public loc(int x, int y, int dis, int w) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[k + 1][n][m];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		int ans = bfs(0, 0);

		System.out.println(ans);
	}

	static int bfs(int x, int y) {

		Queue<loc> q = new LinkedList<>();
		// Queue에 기본 값 삽입 및 방문 체크
		q.add(new loc(0, 0, 1, 0));
		v[0][0][0] = true;

		// Queue가 빌 때까지 반복
		while (!q.isEmpty()) {
			// Queue 가장 최근 값 poll
			loc cur = q.poll();

			// 끝에 도달하면 값 반환
			if (cur.x == n - 1 && cur.y == m - 1) {
				return cur.dis;
			}

			// 4방 탐색 시작
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				// 가능한 범위라면
				if (range(nx, ny)) {

					// 방문한 적이 없고 이동가능하다면
					if (!v[cur.w][nx][ny] && map[nx][ny] == 0) {
						q.add(new loc(nx, ny, cur.dis + 1, cur.w));
						v[cur.w][nx][ny] = true;
					}

					// 아직 벽을 부술 수 있다면
					if (cur.w < k) {
						if (!v[cur.w + 1][nx][ny] && map[nx][ny] == 1) {
							// 밤이라면
							if (cur.dis % 2 == 0) {
								q.add(new loc(cur.x, cur.y, cur.dis + 1, cur.w));
								continue;
							}
							q.add(new loc(nx, ny, cur.dis + 1, cur.w + 1));
							v[cur.w + 1][nx][ny] = true;
						}
					}

				}

			}

		}

		//
		return -1;
	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

}
