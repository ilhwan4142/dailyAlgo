package day_1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_18115 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> dq = new ArrayDeque<>(); 
		
		int nowNum = 1;
		dq.add(nowNum++);
		for (int i = N-2; i >= 0; i--) {
			if(A[i] == 1) {
				dq.addFirst(nowNum++);
			} else if(A[i] == 2) {
				int tmp = dq.removeFirst();
				dq.addFirst(nowNum++);
				dq.addFirst(tmp);
			} else if(A[i] == 3) {
				dq.addLast(nowNum++);
			}
		}
		
		while(!dq.isEmpty()) {
			sb.append(dq.removeFirst() + " ");
		}
		System.out.println(sb.toString());
	}

}
