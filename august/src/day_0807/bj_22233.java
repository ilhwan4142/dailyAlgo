package day_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_22233 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		Set<String> keyword = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			keyword.add(br.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(),",");
			while(st.hasMoreTokens()) {
				String stmp = st.nextToken();
				if(keyword.contains(stmp)) {
					keyword.remove(stmp);
				}
			}
			
			sb.append(keyword.size());
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb.toString());
	}

}