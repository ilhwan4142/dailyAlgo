package day_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_1251 {
	public static class Edge implements Comparable<Edge> {
		int idx;
		long cost;

		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static int N;
	public static double E;
	public static long dis[][];
	public static List<Integer> X;
	public static List<Integer> Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			X = new ArrayList<>();
			Y = new ArrayList<>();

			StringTokenizer x = new StringTokenizer(br.readLine(), " ");
			StringTokenizer y = new StringTokenizer(br.readLine(), " ");

			for(int i = 0; i < N; i++) {
				X.add(Integer.parseInt(x.nextToken()));
				Y.add(Integer.parseInt(y.nextToken()));
			}
			
			E = Double.parseDouble(br.readLine());
			
			dis = new long[N][N];
			
			for(int i = 0; i < N; i++) {
				long x1 = X.get(i);
				long y1 = Y.get(i);
				for(int j = i + 1; j < N; j++) {
					long x2 = X.get(j);
					long y2 = Y.get(j);
					dis[i][j] = (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
					dis[j][i] = (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				}
			}
			double ans = Prim(0) * E;
			
			sb.append("#" + tc + " " + Math.round(ans));
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString());
	}

	private static double Prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] graph = new Edge[N];
		for (int n = 0; n < graph.length; n++) {
			graph[n] = new Edge(n, Long.MAX_VALUE);
			if (n == start) graph[start].cost = 0;
			pq.add(graph[n]);
		}
		long cost = 0;
		while (!pq.isEmpty()) {
			Edge front = pq.poll();
			cost += front.cost;
			for (int i = 0; i < graph.length; i++) {
				Edge child = graph[i];
				if (pq.contains(child)) {
					long tmpCost = dis[front.idx][child.idx];
					if (tmpCost < child.cost) {
						child.cost = tmpCost;
						pq.remove(child);
						pq.add(child);
					}
				}
			}
		}
		return cost;
	}
}
