package day_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17472 {

	static int N, M;
	static int[][] map, adj;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	
	static int[] minEdge; // 섬이 연결될 수 있는 최소 다리 길이
	static boolean[] visited; // 중복체크 배열
	static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

	static class loc {
		int x;
		int y;

		public loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class Vertex implements Comparable<Vertex> {
		int no;
		int edge;

		public Vertex(int no, int edge) {
			this.no = no;
			this.edge = edge;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.edge - o.edge;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = 7;
				}
			}
		}

		// bfs로 단지 번호 붙이기
		int number = labelling();

		adj = new int[number + 1][number + 1];
		for (int i = 1; i <= number; i++) {
			Arrays.fill(adj[i], 123);
		}

		// 최소 거리 구하기
		getDistance();
		for (int i = 0; i <= number; i++) {
			for (int j = 0; j <= number; j++) {
				if (adj[i][j] == 123)
					adj[i][j] = 0;
			}
		}

		// 최소 신장 트리 구현
		visited = new boolean[number + 1]; // 섬에 대한 방문 체크

		int result = 0, nodeCount = 0; // 다리길이의 합, 연결된 섬의 개수
		minEdge = new int[number + 1]; // minEdge[A]: A섬이 다른 섬과 연결됐을 때 다리길이 최솟값
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최솟값으로 갱신하기 위해 MAX_VALUE 할당
		minEdge[1] = 0; // 섬 1부터 시작
		pq.offer(new Vertex(1, 0)); // Vertex(no: 섬의 번호,edge: 다리 길이) 섬 1과 섬 1은 다리를 연결할 수 없으므로 edge는 0

		// PRIM 시작
		while (!pq.isEmpty()) { // 모든 연결 방법을 다 살펴볼 동안
			Vertex minVertex = pq.poll(); // minVertex: 다른 섬과 연결되는 다리 길이(edge)가 제일 작은 Vertex
			if (visited[minVertex.no]) // 이미 최솟값으로 연결됐으면
				continue; // 패스

			result += minVertex.edge; // 총 다리 길이에 최솟값을 더한다.
			visited[minVertex.no] = true; // 최솟값으로 연결됐으므로 true

			if (++nodeCount == number) // 모든 섬이 연결됐으면
				break;

			for (int i = 1; i <= number; i++) { // 모든 섬을 살펴보면서
				if (!visited[i] // 최솟값으로 연결되지 않았고,
						&& adj[minVertex.no][i] != 0 // 다른 섬과 다리를 놓을 수 있으
						&& minEdge[i] > adj[minVertex.no][i]) // 다른 섬과 놓을 다리 길이가 더 작은 값이면
				{
					minEdge[i] = adj[minVertex.no][i]; // 더 작은 값으로 갱신
					pq.offer(new Vertex(i, adj[minVertex.no][i]));
				}
			}
		}

		// 출력
		if (nodeCount < number) { // 모든 섬이 연결되지 않았으면
			System.out.println(-1);
		} else { // 모든 섬이 연결됐으면
			System.out.println(result);
		}

	}

	// 섬 간의 최소 거리 구하기
	static void getDistance() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int curNum = map[i][j];
					for (int d = 0; d < 4; d++) {
						int cnt = -1;
						int nx = i;
						int ny = j;
						while (range(nx, ny, N, M)) {
							nx += dx[d];
							ny += dy[d];
							// 가능한 범위라면
							if (range(nx, ny, N, M)) {
								cnt++;
								if (map[nx][ny] == curNum)
									break;
								if (map[nx][ny] != 0) {
									if (cnt < 2)
										break;
									adj[curNum][map[nx][ny]] = Math.min(adj[curNum][map[nx][ny]], cnt);
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	// 단지 번호 붙이기 처럼 라벨링
	static int labelling() {
		Queue<loc> numbering = new LinkedList<>();

		int label = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 7) {
					label++;
					map[i][j] = label;
					numbering.add(new loc(i, j));
					while (!numbering.isEmpty()) {
						loc cur = numbering.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur.x + dx[d];
							int ny = cur.y + dy[d];
							if (range(nx, ny, N, M)) {
								if (map[nx][ny] == 7) {
									map[nx][ny] = label;
									numbering.add(new loc(nx, ny));
								}
							}
						}
					}
				}
			}
		}

		return label;
	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y, int xlimit, int ylimit) {
		return x >= 0 && x < xlimit && y >= 0 && y < ylimit;
	}
}
