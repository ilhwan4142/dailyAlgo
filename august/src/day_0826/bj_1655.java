package day_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> lpq = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> hpq = new PriorityQueue<Integer>();

		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if (i == 1) {
				lpq.offer(tmp);
				sb.append(tmp);
				sb.append(System.lineSeparator());
				continue;
			}
			
			if(tmp<=lpq.peek()) lpq.offer(tmp);
			else hpq.offer(tmp);
			
			while(lpq.size()>hpq.size()) {
				hpq.add(lpq.poll());
			}
			
			while(hpq.size()>lpq.size()) {
				lpq.add(hpq.poll());
			}
			
			sb.append(lpq.peek());
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString());

	}
}
