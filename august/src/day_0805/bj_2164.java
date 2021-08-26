package day_0805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if( n == 1) {
			System.out.println("1");
		}
		else {
			
			int value = 0;
			
			for(int i = 1; i<= 18; i++) {
				
				double tmp = Math.pow(2.0, (double)i);
				if(n>=tmp) {
					value = (int)tmp;
				}
				else break;
			}
			if(n - value == 0) {
				System.out.println(n);
			}
			else {
				n -= value;
				System.out.println(2*n);
			}
			
		}
		
	}

}