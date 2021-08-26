package day_0804;

import java.util.Scanner;
import java.util.Stack;

class loc {
	int sero;
	int garo;
	
	loc(){
		this.sero = 0;
		this.garo = 0;
	}
	
	loc(int sero, int garo){
		this.sero = sero;
		this.garo = garo;
	}
}


public class bj_9205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++) {
			//편의점 수
			int beer = sc.nextInt();
			//집위치
			int homS = sc.nextInt();
			int homG = sc.nextInt();
			//편의점위치, 페스티벌 위치
			loc[] gs = new loc[++beer];
			Stack<loc> s= new Stack();
			boolean[] jud = new boolean[beer];
			
			for(int i = 0; i < beer; i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				gs[i] = new loc(tmp1, tmp2);

			}
			
			s.push(new loc(homS, homG));
			int curS, curG;
			
			while(!s.isEmpty()) {
				
				curS = s.peek().sero;
				curG = s.peek().garo;
				s.pop();
				for(int i = 0; i < beer; i++) {
					int tmp1 = (curS - gs[i].sero)>0? curS - gs[i].sero:gs[i].sero-curS;
					int tmp2 = (curG - gs[i].garo)>0? curG - gs[i].garo:gs[i].garo-curG;
					if(tmp1+tmp2>1000) continue;
					
					if(!jud[i]) {
						s.push(gs[i]);
						jud[i] = true;
						continue;
					}
						
				}
				
			}
			
			if(jud[beer-1]) System.out.println("happy");
			else System.out.println("sad");
		
		}
	}

}