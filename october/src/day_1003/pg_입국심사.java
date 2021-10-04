package day_1003;

import java.util.Arrays;

public class pg_입국심사 {
	public static void main(String[] args) {

		int n = 6;
		int[] times = { 7, 10 };
		long ans = solution(n, times);
		System.out.println(ans);
	}

	// 1. 무엇(left, mid, right)을 이분 탐색할 것이고 어떤 걸(위의 BinarySearch 코드의 target) 비교하여 다음 탐색 구간을 정할지 먼저 찾음
	// => 이분 탐색할 것: 심사를 받는데 걸리는 시간(mid)
	// => 비교대상(target) : n(입국 심사를 기다리는 사람)
	// 2. 심사를 받는데 최소로 걸리는 시간(answer)을 구하므로 심사를 받는데 걸리는 시간(mid)을 이분 탐색함
	// 3. Input에서 비교 대상으로 n(입국 심사를 기다리는 사람)명이 주어지므로 n명을 target으로 정해 다음 탐색 구간을 정함
	// 4. n과 비교하기위해 주어진 mid 시간동안 검사할 수 있는 사람 수(people)을 구하는 알고리즘이 포함되어야함
	// 5. answer를 구하기 위해 최소 시간을 찾아내야함
	
	public static long solution(int n, int[] times) {

		// 이분 탐색을 하기 위해 정렬
		Arrays.sort(times);

		long left, mid, right;
		
		left = 0;
		right = Long.MAX_VALUE;
		
		long people;
		
		// 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
		// mid : 심사를 받는데 주어진 시간
		// people : 주어진 시간(mid)동안 심사를 받을 수 있는 사람 수
		
		while (left <= right) {

			mid = (left + right) / 2;

			people = 0;
			// 주어진 시간동안 몇명 검사 할 수 있는지 누적합
			for (int i = 0; i < times.length; i++) {
				people += mid / times[i];

				// 프루닝
				if (people >= n)
					break;
			}

			// 비교 대상(사람 수)
			// 검사 다 못할 때(시간 부족)
			if (n > people) {
				left = mid + 1;
			}
			// 검사 다 했을 때 (시간이 남음)
			else {
				right = mid - 1;
			}
		}

		return left;
	}
}