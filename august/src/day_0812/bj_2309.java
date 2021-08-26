package day_0812;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2309 {
	static int[] height = new int[9];
	static int[] answer = new int[7];
	static boolean[] sel = new boolean[9];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
		powerSet(0);
		Arrays.sort(answer);
		for(int i = 0; i < 7; i++) {
			System.out.println(answer[i]);
		}
		
	}
	
	static void powerSet(int idx) {
		
		int sum = 0;
		int cnt = 0;
		if( idx == 9) {
			for(int i = 0; i< 9; i++) {
				if(sel[i]) {
					cnt++;
					sum += height[i];
				}
			}
			if(sum==100&&cnt==7) {
				int aidx = 0;
				for(int i = 0; i< 9; i++) {
					if(sel[i]) {
						answer[aidx++] = height[i]; 
					}
				}
			}
			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
}
