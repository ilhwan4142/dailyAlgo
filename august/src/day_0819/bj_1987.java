package day_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1987 {
	
	static char[][] alpha;
	static char[] done;
	static int R;
	static int C;
	static int totalCnt = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean isPossible(int curR, int curC, int cnt) {
		for(int i = 0; i <= cnt; i++) {
			if(done[i]==alpha[curR][curC])
				return false;
		}
		return true;
	}
	
	public static void back(int curR, int curC, int cnt) {
		done[++cnt] = alpha[curR][curC];
		for(int i = 0; i < 4; i++) {
			if(curR+dr[i]>=0&&curR+dr[i]<R&&curC+dc[i]>=0&&curC+dc[i]<C) {
				if(isPossible(curR+dr[i], curC+dc[i], cnt)) {
					back(curR+dr[i], curC+dc[i], cnt);
				}
			}
		}
		totalCnt = cnt>totalCnt? cnt:totalCnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[R][C];
		done = new char[27]; //알파벳 26개까지인데 안 겹치기 때문
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for(int j = 0; j < C; j++) {
				alpha[i][j] = tmp.charAt(j);
			}
		}
		back(0, 0, -1);
		System.out.println(totalCnt+1);
	}
}
