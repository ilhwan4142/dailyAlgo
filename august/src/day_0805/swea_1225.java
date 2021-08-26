package day_0805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_1225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc =1; tc<=10; tc++) {
			int dump = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
		
			for(int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			int cnt = 0;
			while(true) {
				if(cnt<5)	cnt++;
				else	cnt=1;
				
				int tmp = q.poll();
				tmp -= cnt;
				if(tmp <= 0) {
					q.offer(0);
					break;
				}
				q.offer(tmp);
				
			}
			
			System.out.printf("#"+tc+" ");
			
			while(!q.isEmpty()) {
				System.out.printf("%d ", q.poll());
			}
			System.out.println();
		}	
	}

}