package day_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
		
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int half = n%2==1? n/2 +1: n/2;
			
			String[] s1 = new String[half];
			String[] s2 = new String[half];

			for(int i = 0; i < half; i++) {
				s1[i] = st.nextToken();
			}
			
			for(int i = 0; i < half; i++) {
				if(n%2==1&&i==half-1)	break;
				s2[i] = st.nextToken();
			}
			
			System.out.printf("#" + tc + " ");
			
			for(int i = 0; i < half-1; i++) {
				System.out.printf(s1[i] + " " + s2[i] + " ");
			}
			System.out.printf(s1[half-1] + " ");
			if(s2[half-1] !=null)
				System.out.printf(s2[half-1]);
			System.out.println();
		}
	}

}