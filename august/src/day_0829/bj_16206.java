package day_0829;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj_16206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int b = sc.nextInt();
			// 빵이 10보다 작으면
			if (b <= 10) {
				// 빵이 10일때만 ans++
				if (b == 10)
					ans++;
			}
			// 빵이 10보다 크면
			else {
				// 10으로 나뉘면 우선순위 큐
				if (b % 10 == 0) {
					pq.offer(b);
				}
				// 10으로 안 나뉘면 그냥 큐
				else {
					q.offer(b);
				}
			}
		}
		while (m > 0 && !pq.isEmpty()) {
			int cur = pq.poll();
			if (cur == 20) {
				m--;
				ans += 2;
				continue;
			}
			cur -= 10;
			m--;
			ans++;
			pq.offer(cur);
		}

		while (m > 0 && !q.isEmpty()) {
			int cur = q.poll();

			cur -= 10;
			m--;
			ans++;
			if (cur > 10)
				q.add(cur);
		}
		
		System.out.println(ans);
	}
}
