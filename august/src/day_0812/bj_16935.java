package day_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int max = n>m? n:m;
		int min = n>m? m:n;
		
		int[][] arr = new int[max][max];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		while (st.hasMoreTokens()) {
			
			int c = Integer.parseInt(st.nextToken());
			int ntmp = n;
			int[][] tmp = new int[max][max];

			switch (c) {
			
			case 1:
				
				for (int i = 0; i < n; i++) {
					int idx = n - (1 + i);
					for (int j = 0; j < m; j++) {
						tmp[i][j] = arr[idx][j];
					}
				}
				arr = tmp;
				break;

			case 2:
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						int idx = m - (1 + j);
						tmp[i][j] = arr[i][idx];
					}
				}
				arr = tmp;
				break;

			case 3:
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						tmp[j][n-(1+i)] = arr[i][j];
					}
				}
				arr = tmp;
				n = m;
				m = ntmp;
				break;

			case 4:
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						tmp[m-(1+j)][i] = arr[i][j];
					}
				}
				arr = tmp;
				n = m;
				m = ntmp;
				break;
				
			case 5:
				for (int i = 0; i < n/2; i++) {
					for (int j = 0; j < m/2; j++) {
						tmp[i][j+m/2] = arr[i][j];
					}
				}
				for (int i = 0; i < n/2; i++) {
					for (int j = m/2; j < m; j++) {
						tmp[i+n/2][j] = arr[i][j];
					}
				}
				for (int i = n/2; i < n; i++) {
					for (int j = m/2; j < m; j++) {
						tmp[i][j-m/2] = arr[i][j];
					}
				}
				for (int i = n/2; i < n; i++) {
					for (int j = 0; j < m/2; j++) {
						tmp[i-n/2][j] = arr[i][j];
					}
				}
				arr = tmp;
				break;
				
			case 6:
				for (int i = 0; i < n/2; i++) {
					for (int j = 0; j < m/2; j++) {
						tmp[i+n/2][j] = arr[i][j];
					}
				}
				for (int i = 0; i < n/2; i++) {
					for (int j = m/2; j < m; j++) {
						tmp[i][j-m/2] = arr[i][j];
					}
				}
				for (int i = n/2; i < n; i++) {
					for (int j = m/2; j < m; j++) {
						tmp[i-n/2][j] = arr[i][j];
					}
				}
				for (int i = n/2; i < n; i++) {
					for (int j = 0; j < m/2; j++) {
						tmp[i][j+m/2] = arr[i][j];
					}
				}
				arr = tmp;
				break;

			}
			
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if(arr[i][j]!=0) sb.append(arr[i][j] + " ");
			}
			sb.append(System.getProperty("line.separator"));
		}

		System.out.println(sb.toString());
	}
}