package day_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList();
		
		for(int i = 1; i <= n; i++)	q.offer(i);
		int cnt = 1;
		
		sb.append("<");
		
		while(q.size()!=1) {
			if(cnt == k) {
				sb.append(q.poll()+", ");
				cnt = 1;
			}
			else {
				q.offer(q.poll());
				cnt++;
			}
		}
		sb.append(q.poll());
		sb.append(">");
		
		System.out.println(sb.toString());	   
	}

}