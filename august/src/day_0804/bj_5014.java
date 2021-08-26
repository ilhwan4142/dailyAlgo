package day_0804;

import java.util.Scanner;

public class bj_5014 {
		
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static boolean[] jud;
	static int cnt = 0;
	
	public static void dfs(int cur) {
		//현재 칸 비활성화
		jud[cur] = true;
		cnt++;
		//도착했으면 종료
		if(cur == g) return;
		
		//목표보다 낮으면
		if(cur<g) {
			//u 더한 값이 전체 층을 초과한다면
			if(cur+u>f) {
				if(cur-d>0) {
					if(!jud[cur-d]) {
						dfs(cur-d);
						return;
					}
					return;
				}
			}
			else{
				if(!jud[cur+u])
					dfs(cur+u);
			}
			return;
		}
		
		//목표보다 높으면
		
		//d 뺀 값이 0보다 크면
		if(cur-d>0) {
			if(!jud[cur-d]) {
				dfs(cur-d);
				return;
			}
			return;
		}
		if(cur+u<=f) {
			if(!jud[cur+u])
				dfs(cur+u);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		
		
		jud = new boolean[f+1];
		
		dfs(s);
		if(jud[g]) System.out.println(cnt-1);
		else System.out.println("use the stairs");

	}

}