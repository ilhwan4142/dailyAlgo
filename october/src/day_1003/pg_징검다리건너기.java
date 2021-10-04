package day_1003;

public class pg_징검다리건너기 {
	public static void main(String[] args) {

		int k = 3;
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int ans = solution(stones, k);
		System.out.println(ans);
	}

	public static int solution(int[] stones, int k) {
		int left = 1;
		int right = 200000000; // 돌의 내구성 최댓값, 이 이상 친구들이 건너지 못함 
		int mid = 0;

		while(left <= right){
			mid = (left + right) / 2; 

			// mid 명의 친구가 건널 수 있다면
			if(cross(stones, k, mid)) {
				left = mid + 1; // 인원 수 증가
			}
			// 건널 수 없다면
			else {
				right = mid - 1; // 인원 수 감소
			}
		}

		return right;
	}
	
	public static boolean cross(int[] stones, int k, int mid) {
		
		// skip 횟수
		int cnt = 0;

		for (int i = 0; i < stones.length; i++) {
			
			// 돌의 내구성이 모든 친구들이 건너가는 것을 버틸 수 없다면
			if (stones[i] - mid < 0) { 
				// skip cnt 증가
				cnt++;
			}
			// 돌의 내구성이 모든 친구들이 건너가는 것을 버틸 수 있다면
			else {
				// skip 초기화
				cnt = 0;
			}

			// skip 횟수가 건너 뛸 수 있는 거리랑 같아지면 불가능 반환
			if (cnt == k) 
				return false;
		}

		return true; 
	}
}
