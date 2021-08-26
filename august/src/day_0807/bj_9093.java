package day_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9093 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		   int T = Integer.parseInt(br.readLine());
		   StringBuilder sb = new StringBuilder();
		   
		   
		   for(int tc = 0; tc < T; tc++) {
			   
			   StringTokenizer st = new StringTokenizer(br.readLine());
			   
			   while(st.hasMoreTokens()) {
				   sb.append(" " + st.nextToken());
				   System.out.printf(sb.reverse().toString());
				   sb.setLength(0);
			   }

			   System.out.println();
		   }
		
		
	}

}