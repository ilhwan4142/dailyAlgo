package day_0817;

import java.util.Scanner;

public class bj_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int _2_n = (int)Math.pow(2.0, N); //2의 n 제곱
		int region = _2_n*_2_n/4; //1/4한 구역의 개수
		int dis = _2_n/2; //한 변의 길이
		int cnt = 0; //카운트 개수
		while(region>0) {
			//1사분면
			if(r<dis&&c<dis) {
				cnt += 0;
			}
			//2사분면
			else if(r<dis&&c>=dis) {
				cnt += region;
				c-= dis;
			}
			//3사분면
			else if(r>=dis&&c<dis) {
				cnt += 2*region;
				r -= dis;
			}
			//4사분면
			else if(r>=dis&&c>=dis) {
				cnt += 3*region;
				r -= dis;
				c -= dis;
			}
			region = region/4;
			dis = dis/2;
		}
		System.out.println(cnt);
	}

}
