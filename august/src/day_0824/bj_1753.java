package day_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end;
	int weight;

	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

}

public class bj_1753 {
	static int v, e, k;
	static List<Node>[] list;
	static int[] dis;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		list = new ArrayList[v + 1];
		dis = new int[v + 1];

		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dis, INF);

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}

		dijkstra(k);

		for (int i = 1; i <= v; i++) {
			if (dis[i] == INF)
				sb.append("INF");
			else
				sb.append(dis[i]);
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString());

	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visit = new boolean[v + 1];

		q.add(new Node(start, 0));
		dis[start] = 0;

		while (!q.isEmpty()) {
			Node curNode = q.poll();

			if (visit[curNode.end])
				continue;

			visit[curNode.end] = true;

			for (Node node : list[curNode.end]) {
				if (dis[node.end] > dis[curNode.end] + node.weight) {
					dis[node.end] = dis[curNode.end] + node.weight;
					q.add(new Node(node.end, dis[node.end]));
				}
			}

		}

	}
}
