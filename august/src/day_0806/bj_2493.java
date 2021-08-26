package day_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class top {
	int num;
	int height;
		
	top(int num, int height){
		this.num = num;
		this.height = height;
	}
}

public class bj_2493 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		Stack<top> s = new Stack();
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		//첫번째 입력 처리
		int tmp = Integer.parseInt(st.nextToken());
		
		s.push(new top(1, tmp));
		sb.append("0 ");
		
		for (int i = 2; i <= n; i++) {
			
			tmp = Integer.parseInt(st.nextToken());
			
			if (tmp < s.peek().height) {
				sb.append(s.peek().num + " ");
				s.push(new top(i, tmp));
				continue;
			}
			
			else {
				while (!s.empty() && tmp > s.peek().height) {
					s.pop();
				}
				if (s.empty()) {
					s.push(new top(i, tmp));
					sb.append("0 ");
					continue;
				}
				
				sb.append(s.peek().num + " ");
				s.push(new top(i, tmp));
			}
			
			
		
		}
		System.out.println(sb.toString());
		

	}
	

}