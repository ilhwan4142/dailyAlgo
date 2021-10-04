package day_1003;

import java.util.Arrays;

public class pg_징검다리 {
	public static void main(String[] args) {

		int distance = 25;
		int n = 3;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int ans = solution(distance, rocks, n);
		System.out.println(ans);
	}

	public static int solution(int distance, int[] rocks, int n) {

		Arrays.sort(rocks);

		long left = 0;
		long right = distance;
		long mid = 0;

		while (left <= right) {
			int cnt = 0; // 돌 제거하는 횟수
			int prev = 0; // 전 돌을 위치를 저장하는 변수, 초기 값은 0

			mid = (left + right) / 2; // mid는 돌 사이의 최소 거리

			// 각 돌들의 위치를 다 비교 해주기 위해 rocks 배열 전체 탐색
			for (int i = 0; i < rocks.length; i++) {
				// 돌 사이의 거리가 최소 거리(mid) 보다 작은 거리면 돌 제거 횟수(cnt++) 증가
				if (rocks[i] - prev < mid) {
					cnt++; // 거리가 최소 거리 보다 안 되므로 prev 갱신 안 해줌
				}
				// 돌 사이의 거리가 최소 거리(mid) 보다 큰 거리면
				else {
					prev = rocks[i]; // prev 갱신
				}
			}

			// 마지막 돌과 도착점 사이의 거리도 확인
			if (distance - prev < mid)
				cnt++;

			// 돌 제거 횟수가 n보다 작으면 돌 사이의 최소 거리(mid)를 늘려줌
			if (cnt <= n) {
				left = mid + 1;
			}
			// 돌 제거 횟수가 n보다 크면 돌 사이의 최소 거리(mid)를 줄여줌
			else {
				right = mid - 1;
			}
		}
		return (int) right;
	}
}