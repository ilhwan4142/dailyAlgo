package day_0809;

import java.util.Scanner;

public class bj_9663 {
	
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		backtrack(0);
		System.out.println(cnt);
	}

	static int cnt = 0;

	// idx번째 행의 퀸의 위치를 정하는 함수
	static void backtrack(int idx) {
		if (idx == map.length) {
			cnt++;
			// 다골랐다
			return;
		}
		// 모든 열을 검사하면서
		for (int i = 0; i < map[idx].length; i++) {
			// 퀸을 놓으면 안되면
			if (!isPossible(idx, i))
				continue;
			// 퀸을 배치하고
			map[idx][i] = 1;
			// 다음 라인으로 이동
			backtrack(idx + 1);
			// 퀸을 다시 제거
			map[idx][i] = 0;
		}
	}

	static boolean isPossible(int r, int c) {
		// 내 위로 퀸이 있는지 검사. 퀸을 만나면 return false
		for (int i = r; i >= 0; i--) {
			if (map[i][c] == 1)
				return false;
		}
		// 내 왼쪽 위로 퀸이 있는지 검사.
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		// 내 오른쪽 위로 퀸이 있는지 검사.
		for (int i = r, j = c; i >= 0 && j < map[i].length; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}
		return true;
	}

}