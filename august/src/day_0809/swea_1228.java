package day_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			LinkedList<Integer> num = new LinkedList<Integer>();
			
			for(int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				num.add(tmp);
			}
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i < m; i++) {
				String dump = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int j = 0; j< y; j++) {
					int s = Integer.parseInt(st.nextToken());
					num.add(x+j, s);
				}
			}
			sb.append("#"+tc+" ");
			
			for(int i = 0; i < 10; i++) {
				sb.append(num.get(i) + " ");
			}
			
			System.out.println(sb.toString());
			sb.setLength(0);
		}
		   
	}

}