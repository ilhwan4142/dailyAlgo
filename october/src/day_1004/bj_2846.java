package day_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2846 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		
		int prev = Integer.parseInt(st.nextToken());
		int diff = 0;
		for(int i = 1; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if(now > prev) {
				diff += now - prev;
			}
			else {
				diff = 0;
			}
			prev = now;
			max = Math.max(max, diff);
			
		}
		
		
		System.out.println(max);
	}
}
