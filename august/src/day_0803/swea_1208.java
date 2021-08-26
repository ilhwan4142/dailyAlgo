package day_0803;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1208 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <=10; tc++) {
			
			int dump = sc.nextInt();
			int[] box = new int[100];
			
			for(int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			
			for (int i = 0; i < dump; i++) {
                Arrays.sort(box);
                box[0]++;
                box[99]--;
            }
			
			Arrays.sort(box);
			
			System.out.println("#"+tc+" "+(box[99]-box[0]));
		}

	}

}