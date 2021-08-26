package day_0804;

import java.util.Scanner;

public class swea_1873 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int tankS = 0, tankG = 0;
		for(int tc =1; tc<=T; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] map = new char[h][w];
			for(int i = 0; i < h; i++) {
				String tmp = sc.next();
				for(int j = 0; j < w; j++) {
					map[i][j] = tmp.charAt(j);
					if(map[i][j] == '<'|| map[i][j] == '^'||map[i][j] == 'v'||map[i][j] == '>') {
						tankS = i;
						tankG = j;
					}
				}
			}
			int n = sc.nextInt();
			String com;
			com = sc.next();
			for(int i = 0; i< n; i++) {
				char c = com.charAt(i);
				
				//위로 이동
				if(c == 'U') {
					//탱크가 맨 위가 아닌 경우
					if(tankS-1>=0) {
						//위가 평지인 경우
						if(map[tankS-1][tankG]=='.') {
							map[tankS-1][tankG]= '^';
							map[tankS][tankG]= '.';
							tankS--;
						}
						//아닌 경우
						else map[tankS][tankG]= '^';
						
					}
					//탱크가 맨 위에 있는 경우
					else {
						map[tankS][tankG] = '^';
					}
					
					continue;
				}
				//아래로 이동
				else if(c == 'D') {
					//탱크가 맨 아래가 아닌 경우
					if(tankS+1<h) {
						//아래가 평지인 경우
						if(map[tankS+1][tankG]=='.') {
							map[tankS+1][tankG]= 'v';
							map[tankS][tankG]= '.';
							tankS++;
						}
						//아닌 경우
						else map[tankS][tankG]= 'v';
						
					}
					//탱크가 맨 아래에 있는 경우
					else {
						map[tankS][tankG] = 'v';
					}
					
					continue;
				}
				else if(c == 'L') {
					//탱크가 맨 왼쪽이 아닌 경우
					if(tankG-1>=0) {
						//왼쪽이 평지인 경우
						if(map[tankS][tankG-1]=='.') {
							map[tankS][tankG-1]= '<';
							map[tankS][tankG]= '.';
							tankG--;
						}
						//아닌 경우
						else map[tankS][tankG]= '<';
						
					}
					//탱크가 맨 왼쪽에 있는 경우
					else {
						map[tankS][tankG] = '<';
					}
					
					continue;
					
				}
				else if(c == 'R') {
					//탱크가 맨 오른쪽이 아닌 경우
					if(tankG+1<w) {
						//오른쪽이 평지인 경우
						if(map[tankS][tankG+1]=='.') {
							map[tankS][tankG+1]= '>';
							map[tankS][tankG]= '.';
							tankG++;
						}
						//아닌 경우
						else map[tankS][tankG]= '>';
						
					}
					//탱크가 맨 오른쪽에 있는 경우
					else {
						map[tankS][tankG] = '>';
					}
					
					continue;
					
				}
				else if(c == 'S') {
					int curS = tankS;
					int curG = tankG;
					
					switch(map[tankS][tankG]) {
					
					case '^':
						while(curS!=0) {
							curS--;
							if(map[curS][curG]=='#') break;
							if(map[curS][curG]=='*') {
								map[curS][curG]='.';
								break;
							}
						}
						break;
						
					case 'v':
						while(curS+1<h) {
							curS++;
							if(map[curS][curG]=='#') break;
							if(map[curS][curG]=='*') {
								map[curS][curG]='.';
								break;
							}
						}
						break;
						
					case '<':
						while(curG!=0) {
							curG--;
							if(map[curS][curG]=='#') break;
							if(map[curS][curG]=='*') {
								map[curS][curG]='.';
								break;
							}
						}
						break;
						
					case '>':
						while(curG+1<w) {
							curG++;
							if(map[curS][curG]=='#') break;
							if(map[curS][curG]=='*') {
								map[curS][curG]='.';
								break;
							}
						}
						break;
					}
					
				}
				
			}
			
			System.out.printf("#"+tc+" ");
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					System.out.printf("%c",map[i][j]);
				}
				System.out.println();
			}
			
			
		}
		
	}

}