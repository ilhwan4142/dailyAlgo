package day_0817;

import java.util.LinkedList;
import java.util.Scanner;

class chemi{
	int low;
	int high;
	chemi(int low, int high){
		this.low = low;
		this.high = high;
	}
}
public class jo_1828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		chemi[] c = new chemi[N];
		boolean[] check = new boolean[N];
		int lmax = -270;
		int hmin = 10000;
		int cnt = 1;
		int ltmp = 0;
		int htmp = 0;
		for(int i = 0; i < N; i++) {
			c[i] = new chemi(sc.nextInt(),sc.nextInt());
			if(hmin>c[i].high) {
				hmin = c[i].high;
				htmp = i;
			}
			if(lmax<c[i].low) {
				lmax = c[i].low;
				ltmp = i;
			}
		}
		if(hmin>lmax) {
			System.out.println(cnt);
			System.exit(0);
		}
		check[htmp] = true;
		check[ltmp] = true;
		
		
		
		
	}

}
