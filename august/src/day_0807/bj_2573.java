package day_0807;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class iceberg{
	int sero;
	int garo;
	
	iceberg(int sero, int garo){
		this.sero = sero;
		this.garo = garo;
	}
	
}

public class bj_2573 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		Queue<iceberg> q = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];

		//map 배열에 빙산정보 입력
		for(int i = 0; i < n; i++) {
			st =  new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		//전체 반복문
		//반복 될 때마다 시간이 흐름
		while(true) {
			
			//먼저 현재 상태 검사
			
			out:for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j]>0) {
						q.offer(new iceberg(i, j));
						break out;
					}
				}
			}
			
			boolean[][] visit = new boolean[n][m];
			
			if(!q.isEmpty()) visit[q.peek().sero][q.peek().garo] = true;
			while(!q.isEmpty()) {
				int s = q.peek().sero;
				int g = q.peek().garo;
				
				q.poll();
				
				//4방탐색
				if(!visit[s-1][g]&&map[s-1][g]>0) {
					visit[s-1][g] = true;
					q.offer(new iceberg(s-1,g));
				}

				if(!visit[s+1][g]&&map[s+1][g]>0) {
					visit[s+1][g] = true;
					q.offer(new iceberg(s+1,g));
				}


				if(!visit[s][g-1]&&map[s][g-1]>0) {
					visit[s][g-1] = true;
					q.offer(new iceberg(s,g-1));
				}

				if(!visit[s][g+1]&&map[s][g+1]>0) {
					visit[s][g+1] = true;
					q.offer(new iceberg(s,g+1));
				}

				
			}//bfs while문
			
			int bfsCnt = 0;
			int rmIce = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j]>0) {
						rmIce++;
						if(!visit[i][j])
							bfsCnt++;
					}
				}
			}

			if(bfsCnt > 0) break;
			if(rmIce == 0) {
				cnt = 0;
				break;
			}
			
			//시간 흐름
			cnt++;
			
			int[][] tmp = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			//q에 offer
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(tmp[i][j]>0) {
						//4방탐색
						if(tmp[i-1][j]==0) {
							if(map[i][j]>0)
								map[i][j]--;
						}
						if(tmp[i+1][j]==0) {
							if(map[i][j]>0)
								map[i][j]--;
						}
						if(tmp[i][j-1]==0) {
							if(map[i][j]>0)
								map[i][j]--;
						}
						if(tmp[i][j+1]==0) {
							if(map[i][j]>0)
								map[i][j]--;
						}
					}
				}
			}
			
		}//전체 while문
		
		
		sb.append(cnt);
		System.out.println(sb.toString());
	}

}