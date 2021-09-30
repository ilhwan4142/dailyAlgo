package day_0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_16235 {

	static int N, M, K;
	static int[][] map, s2d2;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static PriorityQueue<Loc> spring, autumn, die;

	static class Loc implements Comparable<Loc> {
		int r;
		int c;
		int age;

		public Loc(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Loc o) {
			return age - o.age;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		s2d2 = new int[N + 1][N + 1];
		spring = new PriorityQueue<>();
		autumn = new PriorityQueue<>();
		die = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
				s2d2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			spring.add(new Loc(x, y, z));
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}

		System.out.println(spring.size());

	}

	// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
	// 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
	// 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
	// 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
	static void spring() {
		while (!spring.isEmpty()) {
			Loc loc = spring.poll();
			int curR = loc.r;
			int curC = loc.c;
			int curA = loc.age;

			// 양분이 부족하지 않다면
			if (map[curR][curC] >= curA) {
				map[curR][curC] -= curA;
				autumn.add(new Loc(curR, curC, curA + 1));
			}
			// 양분이 부족해 죽는다면
			else {
				die.add(new Loc(curR, curC, curA));
			}

		}
	}

	// 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
	// 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
	static void summer() {
		while (!die.isEmpty()) {
			Loc loc = die.poll();
			int curR = loc.r;
			int curC = loc.c;
			int curA = loc.age;

			map[curR][curC] += curA / 2;
		}
	}

	// 가을에는 나무가 번식한다.
	// 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
	// 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
	static void autumn() {
		while (!autumn.isEmpty()) {
			Loc loc = autumn.poll();
			int curR = loc.r;
			int curC = loc.c;
			int curA = loc.age;

			if (curA % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = curR + dx[d];
					int nc = curC + dy[d];

					// 범위에 포함되면 8방에 나이 1인 나무 추가
					if (range(nr, nc)) {
						spring.add(new Loc(nr, nc, 1));
					}
				}
			}
			spring.add(new Loc(curR, curC, curA));
		}
	}

	// 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
	// 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += s2d2[i][j];
			}
		}
	}

	// 범위 탐색해주는 함수
	static boolean range(int x, int y) {
		return x > 0 && x <= N && y > 0 && y <= N;
	}
}
