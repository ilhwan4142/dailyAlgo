package day_0803;

import java.math.BigInteger;
import java.util.Scanner;

public class bj_1914 {
	

	public static void hanoi(int n, int start, int temp, int dest) {
		if(n==0) return;
		
		hanoi(n-1,start,dest,temp);
		
		System.out.println(start + " " + dest);
		
		hanoi(n-1,temp,start,dest);

	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		BigInteger result=new BigInteger("1");
        if(n==1) System.out.println(1);
        else {
            for(int i=0;i<n;i++) {
                result=result.multiply(new BigInteger("2"));
            }
            result=result.subtract(new BigInteger("1"));
            System.out.println(result);
        }


		if(n<=20) {
			hanoi(n, 1, 2, 3);
		}		
		
	}

}
