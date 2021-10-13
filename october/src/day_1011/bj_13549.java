package day_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_13549 {

	static class info implements Comparable<info>{
		int loc;
		int time;

		public info(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}

		@Override
		public int compareTo(info o) {
			return time - o.time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<info> q = new PriorityQueue<>();
		boolean[] visit = new boolean[100001];

		q.add(new info(N, 0));
		visit[N] = true;

		int ans = 0;

		while (!q.isEmpty()) {

			info cur = q.poll();

			visit[cur.loc] = true;
			
			if (cur.loc == K) {
				ans = cur.time;
				break;
			}

			// *2
			if (isRange(cur.loc * 2)) {
				if (!visit[cur.loc * 2]) {
					q.add(new info(cur.loc * 2, cur.time));
				}
			}
			// +1
			if (isRange(cur.loc + 1)) {
				if (!visit[cur.loc + 1]) {
					q.add(new info(cur.loc + 1, cur.time + 1));
				}
			}
			// -1
			if (isRange(cur.loc - 1)) {
				if (!visit[cur.loc - 1]) {
					q.add(new info(cur.loc - 1, cur.time + 1));
				}
			}

		}

		System.out.println(ans);

	}

	static boolean isRange(int x) {
		return x <= 100000 && x >= 0;
	}

}