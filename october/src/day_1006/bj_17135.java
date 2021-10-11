package day_1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_17135 {

	// locate 위치 저장 클래스
	static class Loc {
		int r;
		int c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, D, ans;
	static int[][] map;
	static ArrayList<Loc> Enemy;
	static int[] archerLoc;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		Enemy = new ArrayList<>();
		archerLoc = new int[M];
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					// 적 위치 저장
					Enemy.add(new Loc(i, j)); // 사람이면 추가
				}
			}
		}
		// 조합 및 답 구하기
		setArcher(0, 0);

		System.out.println(ans);
	}

	static void setArcher(int idx, int cnt) {
		// 조합 다 짜면
		if (idx == M) {
			// 궁수 3명인 경우만
			if (cnt == 3) {
				ArrayList<Loc> archer = new ArrayList<>();
				// 궁수 추가
				for (int j = 0; j < M; j++) {
					if (archerLoc[j] == 1) {
						archer.add(new Loc(N, j));
					}
				}
				// 적 위치 저장한 리스트 복사
				ArrayList<Loc> enemy = new ArrayList<>();
				for(int i = 0; i < Enemy.size(); i++) {
					enemy.add(Enemy.get(i));
				}
				// 제거한 적 수
				int tmp = killEnemy(archer, enemy);
				
				// 최댓값 갱신
				ans = Math.max(ans, tmp);
			}
			return;
		}
		// 프루닝
		if (cnt > 3) {
			return;
		}

		archerLoc[idx] = 1;
		setArcher(idx + 1, cnt + 1);
		archerLoc[idx] = 0;
		setArcher(idx + 1, cnt);
	}

	static int killEnemy(ArrayList<Loc> archer, ArrayList<Loc> enemy) {
		
		// 죽인 적의 수
		int cnt = 0;

		// 적이 더 없을 때까지
		while (enemy.size() != 0) {
			ArrayList<Loc> kill = new ArrayList<>();

			// 모든 궁수로 확인
			for (int i = 0; i < 3; i++) {
				int[] dis = new int[enemy.size()];
				int min = Integer.MAX_VALUE;
				ArrayList<Loc> hold = new ArrayList<>();

				// 거리 계산해서 최소 거리 구함
				for (int j = 0; j < enemy.size(); j++) {
					dis[j] = getDis(archer.get(i), enemy.get(j));
					min = Math.min(min, dis[j]);
					
				}
				
				// 최소 거리인 적 보류
				for (int j = 0; j < enemy.size(); j++) {
					if (dis[j] == min) {
						if (dis[j] <= D) {
							hold.add(enemy.get(j));
						}
					}
				}
				
				// 보류인 적이 하나면 죽임
				if(hold.size() == 1) {
					kill.add(hold.get(0));
				}
				// 2명 이상이면 계산해줘야함
				else if(hold.size() > 1) {
					min = Integer.MAX_VALUE;
					
					// 가장 왼쪽의 적부터 죽임
					for (int j = 0; j < hold.size(); j++) {
						min = Math.min(hold.get(j).c, min);
					}
					for (int j = 0; j < hold.size(); j++) {
						if (hold.get(j).c == min) {
							kill.add(hold.get(j));
						}
					}
				}	
			}

			// 죽이는 리스트에 저장된 친구 판별 후 죽임
			for(int i = 0; i < kill.size(); i++) {
				for(int j = 0; j < enemy.size(); j++) {
					if(kill.get(i).r == enemy.get(j).r && kill.get(i).c == enemy.get(j).c) {
						enemy.remove(j);
						cnt++;
						break;
					}
				}
			}
			
			// 적들 이동
			int size = enemy.size();
			int idx = 0;
			while(size-->0) {
				if(enemy.get(idx).r + 1 != N) {
					enemy.add(new Loc(enemy.get(idx).r + 1, enemy.get(idx).c));
				}
				enemy.remove(idx);
			}
		}

		return cnt;
	}

	// 거리 구하기 식
	static int getDis(Loc loc1, Loc loc2) {
		return Math.abs(loc1.r - loc2.r) + Math.abs(loc1.c - loc2.c);
	}
}
