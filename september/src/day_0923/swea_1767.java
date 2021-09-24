package day_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767 {

	static int n, minW, maxP;
	static int[][] map;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static List<loc> process;

	static class loc {
		int x;
		int y;

		public loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			process = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && j != 0 && i != n - 1 && j != n - 1) {
							process.add(new loc(i, j));
						}
					}
				}
			}

			minW = Integer.MAX_VALUE;
			maxP = 0;

			dfs(0, 0, 0);

			sb.append("#" + tc + " " + minW);
			sb.append(System.lineSeparator());
		}

		System.out.println(sb);
	}

	static void dfs(int idx, int pcnt, int wcnt) {
		if (idx == process.size()) {
			if (maxP < pcnt) {
				maxP = pcnt;
				minW = wcnt;
			} else if (maxP == pcnt) {
				minW = Math.min(wcnt, minW);
			}
			return;
		}

		int curx = process.get(idx).x;
		int cury = process.get(idx).y;

		for (int d = 0; d < 4; d++) {
			int count = 0;
			int nx = curx;
			int ny = cury;
			
			while (true) {
				nx += dx[d];
				ny += dy[d];

				if (range(nx, ny)) {
					break;
				}

				if (map[nx][ny] == 1) {
					count = 0;
					break;
				}

				count++;
			}

			int fx = curx;
			int fy = cury;

			for (int i = 0; i < count; i++) {
				fx += dx[d];
				fy += dy[d];
				map[fx][fy] = 1;
			}

			if (count == 0)
				dfs(idx + 1, pcnt, wcnt);
			else {
				dfs(idx + 1, pcnt + 1, wcnt + count);

				fx = curx;
				fy = cury;
				
				for (int i = 0; i < count; i++) {
					fx += dx[d];
					fy += dy[d];
					map[fx][fy] = 0;
				}
			}
		}
	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}
}
