package day_0807;

import java.util.Scanner;

public class bj_1783 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if(n  == 1) System.out.println("1");
        else if(n == 2) {
        	if(m<7)
        	System.out.println((m+1)/2);
        	else System.out.println(4);
        }
        else {
        	if(m<7) {
        		if(m<4) {
        		System.out.println(m);
        	    }
                else{
                    System.out.println(4);
                }
        	}
        	else System.out.println(m-2);
        }
        
    }
}
