package day_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder ssb = new StringBuilder();
		String str = br.readLine();
		boolean tag = false;
		
		for(int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			
			if(tag) {
				sb.append(tmp);
				if(tmp=='>') {
					tag = false;
				}
			}
			else {
				if(tmp=='<') {
					tag = true;
					sb.append(ssb.reverse().toString()+'<');
					ssb.setLength(0);
				}
				else if(tmp==' ') {
					sb.append(ssb.reverse().toString()+' ');
					ssb.setLength(0);
				}
				else {
					ssb.append(tmp);
				}
			}
			
		}
		sb.append(ssb.reverse().toString());
		System.out.println(sb.toString());
		
	}

}
