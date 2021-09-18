package day_0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1194 {

	static int n, m;
	static char[][] map;
	static boolean[][][] v;
	static loc start;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class loc {
		int x;
		int y;
		int dis;
		int key;

		public loc(int x, int y, int dis, int key) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.key = key;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		v = new boolean[n][m][64];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '0') {
					start = new loc(i, j, 0, 0);
				}
			}
		}

		int ans = bfs(start.x, start.y);

		System.out.println(ans);
	}

	static int bfs(int x, int y) {

		Queue<loc> q = new LinkedList<>();
		// Queue에 기본 값 삽입 및 방문 체크
		q.add(new loc(x, y, 0, 0));
		v[x][y][0] = true;

		// Queue가 빌 때까지 반복
		while (!q.isEmpty()) {
			// Queue 가장 최근 값 poll
			loc cur = q.poll();

			// 끝에 도달하면 값 반환
			if (map[cur.x][cur.y] == '1') {
				return cur.dis;
			}

			// 4방 탐색 시작
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				// 가능한 범위라면
				if (range(nx, ny)) {
					// 벽이 아니고 방문하지 않았다면
					if (map[nx][ny] != '#' && !v[nx][ny][cur.key]) {
						// 열쇠를 만난다면
						if (map[nx][ny] - 'a' >= 0 && map[nx][ny] - 'a' < 6) {
							// 해당 열쇠를 챙김
							int stateKey = (1 << (map[nx][ny] - 'a')) | cur.key;
							
							// 가본 적이 없다면
							if (!v[nx][ny][stateKey]) {
								v[nx][ny][stateKey] = true;
		                        q.add(new loc(nx, ny, cur.dis + 1, stateKey));
		                    }
							
						}
						// 문을 만난다면
						else if (map[nx][ny] - 'A' >= 0 && map[nx][ny] - 'A' < 6) {
							// 해당 문의 열쇠 갖고 있는지 판별
							int stateDoor = (1 << (map[nx][ny] - 'A')) & cur.key;
							
							// 해당 문의 열쇠가 있다면
							if (stateDoor > 0) {
								v[nx][ny][cur.key] = true;
		                        q.add(new loc(nx, ny, cur.dis + 1, cur.key));
		                    }
						}
						// 그냥 땅이라면
						else {
							v[nx][ny][cur.key] = true;
							q.add(new loc(nx, ny, cur.dis + 1, cur.key));
						}

					}
				}
			}

		}

		return -1;
	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}