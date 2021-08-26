package day_0805;

import java.util.Scanner;
import java.util.Stack;

public class swea_1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <=10; tc++) {
			
			
			Stack<Character> s = new Stack<>();
			
			int n = sc.nextInt();
			String tmp = sc.next();
			boolean judgement = true;
			for(int i = 0; i<n; i++ ) {
				char cur = tmp.charAt(i);
				
				if(cur == '(' || cur == '[' || cur == '{' || cur == '<') {
					s.push(cur);
				}
				else if(cur == ')'||cur == ']'||cur == '}'||cur == '>') {
					if(s.isEmpty()) {
						judgement = false;
						break;
					}
					
					char sPeek = s.peek();
					if(sPeek == '('&& cur == ')') {
						s.pop();
						continue;
					}
					else if(sPeek == '['&& cur == ']') {
						s.pop();
						continue;
					}
					else if(sPeek == '{'&& cur == '}') {
						s.pop();
						continue;
					}
					else if(sPeek == '<'&& cur == '>') {
						s.pop();
						continue;
					}
					
					judgement = false;
					break;
				}	
			}
			
			if(judgement) System.out.println("#" + tc + " 1");
			else System.out.println("#" + tc + " 0");
		}
		
		
	}

}