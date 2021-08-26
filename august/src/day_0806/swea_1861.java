package day_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pos{
	int sero;
	int garo;
	
	pos(int sero, int garo){
		this.sero = sero;
		this.garo = garo;
	}
	
}

public class swea_1861 {

	   
	   public static void main(String[] args) throws NumberFormatException, IOException {
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		   int T = Integer.parseInt(br.readLine());
		   StringBuilder sb = new StringBuilder();
		   
		   for(int tc = 1; tc <= T; tc++) {
			   int n = Integer.parseInt(br.readLine());
			   
			   int[][] map = new int[n][n];
			   
			   for(int i = 0; i < n; i++) {
				   StringTokenizer st = new StringTokenizer(br.readLine()," ");
				   for(int j = 0; j < n; j++) {
					   map[i][j] = Integer.parseInt(st.nextToken());   
				   }
			   }
			   
			   int maxV = 0;
			   int maxC = 0;
			   
			   for(int i = 0; i < n; i++) {
				   for(int j = 0; j < n; j++) {
					   boolean[][] visit = new boolean[n][n];
					   Queue<pos> q = new LinkedList();
					   q.add(new pos(i, j));
					   int cnt = 0;
					   
					   visit[i][j] = true;
					   
					   while(!q.isEmpty()) {
						   int curS = q.peek().sero;
						   int curG = q.peek().garo;
						   q.poll();
						   cnt++;
						   
						   if(curS-1>=0) {
							   if(!visit[curS-1][curG]) {
								   //절대값 Math 함수
								   if(Math.abs(map[curS-1][curG]-map[curS][curG])<2) {
									   visit[curS-1][curG] = true;
									   q.offer(new pos(curS-1, curG));
								   }
							   }
						   }
						   
						   if(curS+1<n) {
							   if(!visit[curS+1][curG]) {
								   //절대값 Math 함수
								   if(Math.abs(map[curS+1][curG]-map[curS][curG])<2) {
									   visit[curS+1][curG] = true;
									   q.offer(new pos(curS+1, curG));
								   }
							   }
						   }
						   
						   if(curG-1>=0) {
							   if(!visit[curS][curG-1]) {
								   //절대값 Math 함수
								   if(Math.abs(map[curS][curG-1]-map[curS][curG])<2) {
									   visit[curS][curG-1] = true;
									   q.offer(new pos(curS, curG-1));
								   }
							   }
						   }
						   
						   if(curG+1<n) {
							   if(!visit[curS][curG+1]) {
								   //절대값 Math 함수
								   if(Math.abs(map[curS][curG+1]-map[curS][curG])<2) {
									   visit[curS][curG+1] = true;
									   q.offer(new pos(curS, curG+1));
								   }
							   }
						   }
   
					   }
					   
					   if(cnt > maxC) {
						   maxC = cnt;
						   maxV = map[i][j];
					   }
					   if(cnt == maxC) {
						   maxV = maxV < map[i][j]? maxV : map[i][j];
					   }
					   
					   
				   }
			   }
			   
			   sb.append("#"+tc+" "+ maxV + " " + maxC);
			   
			   System.out.println(sb.toString());
			   sb.setLength(0);
		   }
		   
	   }

}
