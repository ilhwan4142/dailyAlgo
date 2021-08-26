package day_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_4963 {
	static int h;
	static int w;
	static int[][] map;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static void dfs(int r, int c) {
		map[r][c] = 0;
		for(int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= h || nc >= w)
				continue;
			if(map[nr][nc] == 0)
				continue;
			dfs(nr, nc);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(h==0&&w==0) break;
			
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for( int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			sb.append(cnt);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
		
	}

}
