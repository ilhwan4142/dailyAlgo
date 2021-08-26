package day_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_16926 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rot = Math.min(n, m)/2;
		
		for (int i = 0; i < r; i++) {

			for (int j = 0; j < rot; j++) {
				int temp = arr[j][j];
				
				//윗면
				for (int k = j + 1; k < m - j; k++)
					arr[j][k - 1] = arr[j][k];
				
				//우측
				for (int k = j + 1; k < n - j; k++)
					arr[k - 1][m - 1 - j] = arr[k][m - 1 - j];
				
				//아랫면
				for (int k = m - 2 - j; k >= j; k--)
					arr[n - 1 - j][k + 1] = arr[n - 1 - j][k];
				
				//좌측
				for (int k = n - 2 - j; k >= j; k--)
					arr[k + 1][j] = arr[k][j];

				arr[j + 1][j] = temp;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(arr[i][j] +" ");
			}
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb.toString());
	}

}