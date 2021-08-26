package day_0801;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2352 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] port = new int[n];
		int[] tailTable = new int[n];
		
		for(int i = 0; i<n; i++) {
			port[i] = sc.nextInt();	
		}
		tailTable[0] = port[0];
		int length = 1;
		for(int i = 0; i<n; i++) {
			if(tailTable[0] > port[i]) tailTable[0] = port[i];
			
			else if(tailTable[length-1] < port[i]) tailTable[length++] = port[i];
			
			else {
				int idx = Arrays.binarySearch(tailTable, 0, length, port[i]);
				idx = idx<0? -idx-1:idx;
				tailTable[idx]=port[i];
			}
			
		}
		
		System.out.println(length);
		
		
	}

}