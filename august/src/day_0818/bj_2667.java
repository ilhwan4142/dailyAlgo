package day_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//강사님 dfs
//public class 단지번호붙이기 {
//    static int[][] map;
//    static int N;
//    static int[] cnt;
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        map = new int[N][N];
//        cnt = new int[N * N];
//        for(int i = 0; i < N; i++) {
//            String str = sc.next();
//            for(int j = 0; j < N; j++)
//                map[i][j] = str.charAt(j) - '0';
//        }
//
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                if( map[i][j] == 1 ) {
//                    dfs(i, j);
//                    idx++;
//                }
//            }
//        }
//        Arrays.sort(cnt, 0, idx);
//        System.out.println(idx);//단지의 수
//        for(int i = 0; i < idx; i++)
//            System.out.println(cnt[i]);
//    }
//    static int idx;
//    static void dfs(int r, int c) {
//        map[r][c] = 0;
//        cnt[idx]++;
//        for(int d = 0; d < 4; d++) {
//            int nr = r + dr[d];
//            int nc = c + dc[d];
//            if(nr < 0 || nc < 0 || nr >= N || nc >= N)
//                continue;
//            if(map[nr][nc] == 0)
//                continue;
//
//            dfs(nr, nc);
//        }
//    }
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//}

class loc {
	int sero;
	int garo;
	loc (int sero, int garo){
		this.sero = sero;
		this.garo = garo;
	}
}
public class bj_2667 {
	static Queue<loc> q = new LinkedList<>();
	static boolean[][] visit;
	static int[] ds = { 1,0,-1,0 };
	static int[] dg = { 0,1,0,-1 };
	static int n;
	static int num = 0;
	static int[][] map;
	static int[] count = new int[320];
	
	static boolean range(int a, int b) {
		return a >= 0 && a < n &&b >= 0 && b < n;
	}
	static void bfs(int n) {
		while (!q.isEmpty()) {
			int s = q.peek().sero;
			int g = q.peek().garo;
			visit[s][g] = true;
			count[num]++;
			q.poll();
			for (int i = 0, ns, ng;i < 4;i++) {
				ns = s + ds[i];
				ng = g + dg[i];
				if (range(ns, ng) && map[ns][ng] == 1 && !visit[ns][ng]) {
					map[ns][ng] = map[s][g] + 1;
					q.offer(new loc(ns, ng));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String stmp = st.nextToken();
			for( int j = 0; j < n; j++) {
				char tmp = stmp.charAt(j);
				map[i][j] = tmp - '0';
			}
		}
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				if (!visit[i][j] && map[i][j]==1) {
					q.offer(new loc (i, j));
					bfs(num);
					num++;
				}
			}
		}
		sb.append(num);
		sb.append(System.lineSeparator());
		Arrays.sort(count, 0, num);
		for(int i = 0; i < num; i++) {
			sb.append(count[i]);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

}
