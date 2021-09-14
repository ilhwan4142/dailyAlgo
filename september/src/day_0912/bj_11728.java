package day_0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		// 우선순위 큐 선언
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 크기 입력 받음
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 배열 값 입력 받음
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			pq.add(tmp);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			pq.add(tmp);
		}
		
		// StringBuilder에 값 append
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+ " ");
		}
		
		//출력
		System.out.println(sb.toString());
		
	}

}