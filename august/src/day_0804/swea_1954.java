package day_0804;
import java.util.Scanner;

public class swea_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			
			int idx = 1;
			
			//처음 가로줄 n만큼 채워넣기
			for(int i = 0; i<n; i++) {
				map[0][i] = idx++;
			}
			
			int tmp = n-1;
			int pastS = 0, pastG = tmp;
			int pm = 1;
			
			while(tmp!=0) {
				// 그 다음 세로줄 n-1만큼 채워넣기
				for(int i = 1; i<=tmp; i++) {
					map[pastS + (i*pm)][pastG] = idx++;		
				}
				//다음에 이어가기위해 세로 위치 저장
				pastS = pastS + (pm)*(tmp);
				
				// 그 다음 가로줄 n-1만큼 채워넣기
				for(int i = 1; i<=tmp; i++) {
					map[pastS][pastG - (i*pm)] = idx++;
				}
				//다음에 이어가기위해 가로 위치 저장
				pastG = pastG - (pm)*(tmp);
				
				//방향 바뀌는 것을 위한 변수
				pm *= -1;
				tmp--;
			}
			
			System.out.println("#"+tc);
			for(int i = 0; i<n;i++) {
				for(int j=0; j<n; j++) {
					System.out.printf("%d ", map[i][j]);
				}
				System.out.println();
			}
			
		}

	}

}