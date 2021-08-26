package day_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class loc_2468{
	int sero;
	int garo;
	loc_2468(int sero, int garo){
		this.sero = sero;
		this.garo = garo;
	}
}

public class bj_2468 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		int max = 1;
		int min = 100;
		
		//입력받음
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = max>map[i][j]? max:map[i][j];
				min = min<map[i][j]? min:map[i][j];
			}
		}
		
		int maxSafe = 0;
		
		//물의 높이 1부터 max까지 반복문 돌음
		for(int h = min-1; h <= max; h++) {
			int currSafe = 0;
			boolean[][] visit = new boolean[n][n];
			
			//현재 높이 h 보다 낮은 땅은 물에 잠김
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] <= h)	visit[i][j] = true;
				}
			}
			
			Queue<loc_2468> q = new LinkedList();
			
			//bfs 첫번재 칸부터 시작
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					if(visit[i][j]) continue;
					
					currSafe++;
					q.offer(new loc_2468(i, j));
					visit[i][j] = true;
					
					while(!q.isEmpty()) {
						int s = q.peek().sero;
						int g = q.peek().garo;
							
						q.poll();
						
						if(s-1>=0) {
							if(!visit[s-1][g]) {
								visit[s-1][g] = true;
								q.offer(new loc_2468(s-1, g));
							}	
						}
						if(g-1>=0) {
							if(!visit[s][g-1]) {
								visit[s][g-1] = true;
								q.offer(new loc_2468(s, g-1));
							}
						}
						if(s+1<n) {
							if(!visit[s+1][g]) {
								visit[s+1][g] = true;
								q.offer(new loc_2468(s+1, g));
							}
						}
						if(g+1<n) {
							if(!visit[s][g+1]) {
								visit[s][g+1] = true;
								q.offer(new loc_2468(s, g+1));
							}	
						}
					}

				}
			}
			
			//가장 많은 안전구역 개수 갱신
			maxSafe = maxSafe>currSafe? maxSafe:currSafe;

		}
		
		//정답 출력
		System.out.println(maxSafe);
		   
	}

}