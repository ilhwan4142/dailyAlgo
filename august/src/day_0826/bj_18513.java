package day_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_18513 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] N = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			N[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			q.offer(N[i]);
			set.add(N[i]);
		}

		long ans = 0;
		int dist = 1;

		out: while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				int left = cur - 1;
				int right = cur + 1;

				if (!set.contains(left)) {
					q.offer(left);
					ans += dist;
					set.add(left);
					if (k + n == set.size())
						break out;
				}

				if (!set.contains(right)) {
					q.offer(right);
					ans += dist;
					set.add(right);
					if (k + n == set.size())
						break out;
				}

			}
			dist++;
		}

		System.out.println(ans);
	}
}
