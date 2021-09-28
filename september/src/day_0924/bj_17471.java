package day_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17471 {

	static int n, ans = Integer.MAX_VALUE;
	static int[] population;
	static ArrayList<Integer>[] adj;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());

		population = new int[n + 1];
		adj = new ArrayList[n + 1];
		check = new boolean[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int number = Integer.parseInt(st.nextToken());
			for (int j = 0; j < number; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		sel(1);

		if (ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(ans);

	}

	static void sel(int idx) {
		// 부분집합을 다 짰으면
		if (idx == n + 1) {
			// 연결되어 있는지 확인
			if (connectCheck()) {
				int numA = 0, numB = 0;
				for (int i = 1; i <= n; i++) {
					if (check[i])
						numA += population[i];
					else
						numB += population[i];
				}
				
				// answer 값 차이로 갱신
				ans = Math.min(ans, Math.abs(numA - numB));
			}
			return;
		}

		// 포함
		check[idx] = true;
		sel(idx + 1);
		// 미포함
		check[idx] = false;
		sel(idx + 1);
	}

	static boolean connectCheck() {
		// 방문 체크 배열
		boolean[] v = new boolean[n + 1];

		// A와 B중 첫 도시 확인
		// check 값 true가 A, false가 B
		int A = 0, B = 0;
		for (int i = 1; i <= n; i++) {
			if (check[i]) {
				A = i;
				break;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				B = i;
				break;
			}
		}

		// 한 선거구 쪽으로 쏠렸는지 확인
		if (A == 0 || B == 0)
			return false;

		Queue<Integer> q = new LinkedList<>();

		// A 지역
		q.add(A);
		v[A] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < adj[cur].size(); i++) {
				// 방문 안했다면
				if (!v[adj[cur].get(i)]) {
					// A 지역이라면
					if (check[adj[cur].get(i)]) {
						q.add(adj[cur].get(i));
						v[adj[cur].get(i)] = true;
					}
				}
			}
		}

		// B 지역
		q.add(B);
		v[B] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < adj[cur].size(); i++) {
				// 방문 안했다면
				if (!v[adj[cur].get(i)]) {
					// B 지역이라면
					if (!check[adj[cur].get(i)]) {
						q.add(adj[cur].get(i));
						v[adj[cur].get(i)] = true;
					}
				}
			}
		}

		// 방문 안 된 곳이 있다면 연결이 안된 것이므로
		for (int i = 1; i <= n; i++) {
			if (!v[i])
				return false;
		}

		return true;
	}

}
