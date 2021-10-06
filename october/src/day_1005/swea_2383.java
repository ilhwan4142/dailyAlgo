package day_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2383 {
	static int N, ans;
	static int[] peopleToStair;
	static int[][] map;
	static ArrayList<loc> people, stair;
	static info[] firstStair, secondStair;

	// locate 위치 저장 클래스
	static class loc {
		int r;
		int c;

		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 정보를 담고 있는 클래스
	static class info implements Comparable<info> {
		int time; // 계단까지 걸어가는 시간
		int status; // 0 : 걷는 중, 1 : 계단 타는 중, 2 : 도착 완료
		int remainStair; // 계단 타는 중에 남은 시간

		public info(int time, int status, int remainStair) {
			this.time = time;
			this.status = status;
			this.remainStair = remainStair;
		}

		@Override
		public int compareTo(info o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N]; // map 입력 받음
			people = new ArrayList<>(); // 사람 위치 저장
			stair = new ArrayList<>(); // 계단 위치 저장

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						people.add(new loc(i, j)); // 사람이면 추가
					} else if (map[i][j] > 1) {
						stair.add(new loc(i, j)); // 계단이면 추가
					}
				}
			}
			peopleToStair = new int[people.size()]; // 조합

			ans = Integer.MAX_VALUE; // 최솟값 갱신을 위한 세팅
			moveStair(0); // 계단 이동 시작
			sb.append("#" + tc + " " + ans); // 출력 예시
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString()); // 출력
	}

	public static void moveStair(int idx) {
		// 조합 다 짰으면
		if (idx == people.size()) {
			int zeroNum = 0;
			int oneNum = 0;
			// 나뉘어진 계단 수 각각 탐색
			for (int i = 0; i < idx; i++) {
				if (peopleToStair[i] == 0) {
					zeroNum++;
				} else if (peopleToStair[i] == 1) {
					oneNum++;
				}
			}

			// 계단에 배정된 사람 만큼 배열 생성
			firstStair = new info[zeroNum];
			secondStair = new info[oneNum];
			zeroNum = 0;
			oneNum = 0;
			
			for (int i = 0; i < idx; i++) {
				int pr = people.get(i).r;
				int pc = people.get(i).c;
				int sr = stair.get(peopleToStair[i]).r;
				int sc = stair.get(peopleToStair[i]).c;
				int time = Math.abs(pr - sr) + Math.abs(pc - sc); // 계단까지 거리 구하기
				if (peopleToStair[i] == 0) {
					firstStair[zeroNum++] = new info(time, 0, map[sr][sc]); // 첫번째 계단에 정보 추가
				} else if (peopleToStair[i] == 1) {
					secondStair[oneNum++] = new info(time, 0, map[sr][sc]); // 두번째 계단에 정보 추가
				}
			}
			// 편의를 위한 시간순 정렬
			Arrays.sort(firstStair);
			Arrays.sort(secondStair);
			
			// 걸리는 시간 구하기
			int totalTime = getTotalTime();
			
			// 최솟값 갱신
			ans = Math.min(ans, totalTime);
			return;
		}

		peopleToStair[idx] = 0;
		moveStair(idx + 1);
		peopleToStair[idx] = 1;
		moveStair(idx + 1);
	}

	public static int getTotalTime() {
		// 양쪽 계단의 시간 각각 구하기
		int firstTime = getTime(firstStair);
		int secondTime = getTime(secondStair);
		
		// 그 중 더 오래걸린 시간 반환
		return Math.max(firstTime, secondTime);
	}

	public static int getTime(info[] array) {
		// 이 계단에 배정된 사람이 없다면 바로 0 반환
		if (array.length == 0)
			return 0;

		int cnt = 0; // 걸린 시간
		int nowStair = 0; // 현재 계단에 있는 사람 수
		int size = array.length; // 계단에 배정된 사람 수
		while (true) {
			// 시간 경과
			cnt++;
			
			for (int i = 0; i < size; i++) {
				// 계단 내려가는 사람이라면
				if (array[i].status == 1) {
					// 계단 시간 감소
					array[i].remainStair--;
					// 다 내려갔다면
					if(array[i].remainStair == 0) {
						// 도착완료 상태 변경
						array[i].status = 2;
						// 현재 계단에 있는 사람 감소
						nowStair--;
					}
				}
				// 걷는 사람 및 기다리는 사람이라면
				else if (array[i].status == 0) {
					// 입구에 도착 안 했으면 마저 걷고
					if (array[i].time > 0) {
						array[i].time--;
					}
					// 도착했으며 현재 계단에 3명 보다 적게 있다면
					else if (array[i].time == 0 && nowStair < 3) {
						// 계단 타는 상태 변환
						array[i].status = 1;
						// 현재 계단에 있는 사람 증가
						nowStair++;
					}
				}
			}
			
			// 다 도착했는지 체크하기 위한 변수
			int check = 0;
			// 현재 도착한 사람 수를 세어
			for (int i = 0; i < array.length; i++) {
				if (array[i].status == 2)
					check++;
			}
			// 다 도착했다면 탐색 종료
			if (check == array.length)
				break;
		}

		// 걸린시간 반환
		return cnt;
	}

}
