package day_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_13913 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] time = new int[100001];
		int[] sequence = new int[100001];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		time[N] = 0;
		sequence[N] = N;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				break;
			}

			if (isRange(cur + 1) && time[cur + 1] == 0) {
				time[cur + 1] = time[cur] + 1;
				sequence[cur + 1] = cur;
				q.add(cur + 1);
			}

			if (isRange(cur - 1) && time[cur - 1] == 0) {
				time[cur - 1] = time[cur] + 1;
				sequence[cur - 1] = cur;
				q.add(cur - 1);
			}

			if (isRange(cur * 2) && time[cur * 2] == 0) {
				time[cur * 2] = time[cur] + 1;
				sequence[cur * 2] = cur;
				q.add(cur * 2);
			}

		}

		sb.append(time[K]);
		sb.append(System.lineSeparator());

		int[] tmpArray = new int[time[K]];
		int[] ans = new int[time[K]];
		int tmp = K;

		for (int i = 0; i < time[K]; i++) {
			tmpArray[i] = sequence[tmp];
			tmp = sequence[tmp];
		}

		for (int i = 0; i < time[K]; i++) {
			ans[i] = tmpArray[time[K] - (i + 1)];
		}

		for (int i = 0; i < time[K]; i++) {
			sb.append(ans[i] + " ");
		}
		
		sb.append(K);
		System.out.println(sb);

	}

	static boolean isRange(int x) {
		return x <= 100000 && x >= 0;
	}

}