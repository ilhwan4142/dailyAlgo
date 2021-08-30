package day_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1197 {

	static class Edge implements Comparable<Edge> {
		int v;
		long w;

		public Edge(int v, long w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Edge>[] alist = new ArrayList[V + 1];
		boolean[] visit = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			alist[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			alist[start].add(new Edge(end, weight));
			alist[end].add(new Edge(start, weight));
		}

		long rst = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(1);
		while (!dq.isEmpty()) {
			int cidx = dq.poll();
			visit[cidx] = true;
			for (int i = 0; i < alist[cidx].size(); i++) {
				int nv = alist[cidx].get(i).v;
				long nw = alist[cidx].get(i).w;
				if (!visit[nv]) {
					pq.offer(new Edge(nv, nw));
				}
			}
			while (!pq.isEmpty()) {
				int next = pq.peek().v;
				long nv = pq.peek().w;
				pq.poll();
				if (!visit[next]) {
					visit[next] = true;
					dq.add(next);
					rst += nv;
					break;
				}
			}
		}
		System.out.println(rst);
	}

}
