package day_0811;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1697 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList();
		int cnt  = 0;
		int max = n<k? 2*k:n;
		boolean[] v = new boolean[max+1];
		q.offer(n);
		v[n] = true;
		out:while(!q.isEmpty()) {
			
			int size = q.size();
			
			for (int i = 0; i < size; i++) {

				int curr = q.peek();

				q.poll();

				if (curr == k)
					break out;

				if (curr - 1 >= 0) {
					if (!v[curr - 1]) {
						v[curr - 1] = true;
						q.offer(curr - 1);
					}
				}
				if (curr + 1 <= k) {
					if (!v[curr + 1]) {
						v[curr + 1] = true;
						q.offer(curr + 1);
					}
				}
				if (2 * curr <= max) {
					if (!v[2 * curr]) {
						v[2 * curr] = true;
						q.offer(2 * curr);
					}
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
}
