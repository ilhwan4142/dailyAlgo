package day_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_17136 {
	//색종이 크기별 카운트 변수
	static int[] cp = new int[6];
	static int[][] map = new int[10][10];
	//결과값은 25 이하
	static int rst = 26;
	
	public static boolean isPossible(int r, int c, int leng) {
		 for (int i = r; i < r + leng; i++) {
	            for (int j = c; j < c + leng; j++) {
	                if (i < 0 || i >= 10 || j < 0 || j >= 10) return false;
	                if (map[i][j] != 1) return false;
	            }
	        }
	        return true;
	}
	
	public static void back(int r, int c, int cnt) {
		//끝점 도달
		if( r==9 && c==10) {
			rst = rst<cnt? rst:cnt;
			return;
		}
		
		//cnt값이 rst보다 커지면 의미 없으므로 가지치기
		if(cnt >= rst) return;
		
		//열의 끝에 달하면 다음 행으로 이동
		if(c==10) {
			back(r+1, 0, cnt);
			return;
		}
		
		//1이면 시작
		if(map[r][c] == 1) {
			//5~1 길이의 색종이 for문
			for (int i = 5; i >= 1; i--) {
				//5장 이하 사용 및 가능한지 판별
                if (cp[i] < 5 && isPossible(r, c, i)) {
                	//i사이즈 색종이 붙이고 호출
                	for (int a = r; a < r + i; a++) {
                        for (int b = c; b < c + i; b++) {
                            map[a][b] = 0;
                        }
                    }
                    cp[i]++;
                    back(r, c + 1, cnt + 1);
                    //붙인 색종이 회수
                    for (int a = r; a < r + i; a++) {
                        for (int b = c; b < c + i; b++) {
                            map[a][b] = 1;
                        }
                    }
                    cp[i]--;
                }
            }
		}
		//1이 아니면 열 이동
		else back(r, c+1, cnt);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		back(0, 0, 0);
		
		rst = rst==26? -1:rst;
		System.out.println(rst);
	}

}
