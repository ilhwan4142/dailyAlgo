package day_0825;

import java.util.Scanner;

public class bj_2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int[] dir = new int[6];
		int[] dis = new int[6];
		int[] cnt = new int[5];
		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt();
			dis[i] = sc.nextInt();
			cnt[dir[i]]++;
		}
		int tm = 1;
		int mm = 1;
		
		for (int i = 0; i < 6; i++) {
			if (cnt[dir[i]] == 1) {
				tm *= dis[i];
			}
			else if (cnt[dir[i]] == 2) {
				if (i == 0) {
					if (cnt[dir[5]] == 2 && cnt[dir[1]] == 2) {
						mm *= dis[0];
					}
				}
				else if (i == 5) {
					if (cnt[dir[4]] == 2 && cnt[dir[0]] == 2) {
						mm *= dis[5];
					}
				}
				else {
					if (cnt[dir[i-1]] == 2 && cnt[dir[i+1]] == 2) {
						mm *= dis[i];
					}
				}
			}
		}
		System.out.println((tm-mm)*k);

	}

}
