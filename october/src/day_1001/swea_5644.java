package day_1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_5644 {

	static int M, A;
	static int[] moveA, moveB;
	static int dx[] = { 0, 0, 1, 0, -1 };
	static int dy[] = { 0, -1, 0, 1, 0 };
	static ArrayList<BC> bcInfo;

	static class BC {
		int x;
		int y;
		int C;
		int P;

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			moveA = new int[M];
			moveB = new int[M];

			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
				moveB[i] = Integer.parseInt(st2.nextToken());
			}

			bcInfo = new ArrayList<BC>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				bcInfo.add(new BC(x, y, c, p));
			}

			int ans = sol();
			sb.append("#" + tc + " " + ans);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);
	}

	static int sol() {
		int x1 = 1;
		int y1 = 1;
		int x2 = 10;
		int y2 = 10;

		int sum = 0;

		sum += getCharge(x1, y1, x2, y2);

		for (int i = 0; i < M; i++) {
			x1 += dx[moveA[i]];
			y1 += dy[moveA[i]];
			x2 += dx[moveB[i]];
			y2 += dy[moveB[i]];

			sum += getCharge(x1, y1, x2, y2);
		}

		return sum;
	}

	static int getCharge(int x1, int y1, int x2, int y2) {

		int[] chargeA = new int[A];
		int[] chargeB = new int[A];

		for (int i = 0; i < A; i++) {

			if (range(x1, y1, i))
				chargeA[i] = bcInfo.get(i).P;
			if (range(x2, y2, i))
				chargeB[i] = bcInfo.get(i).P;;
		}

		int max = 0;

		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = chargeA[i] + chargeB[j];
				if (i == j && chargeA[i] == chargeB[j])
					sum /= 2;
				max = Math.max(max, sum);
			}
		}

		return max;
	}

	static boolean range(int x, int y, int bc) {

		int diffx = Math.abs(x - bcInfo.get(bc).x);
		int diffy = Math.abs(y - bcInfo.get(bc).y);

		if (diffx + diffy <= bcInfo.get(bc).C)
			return true;

		return false;
	}

}
