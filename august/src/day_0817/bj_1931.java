package day_0817;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class time{
	int start;
	int end;
	time(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class bj_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int tmp = 0;
		
		int N = sc.nextInt();
		time[] times = new time[N];
		for(int i = 0; i < N; i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			times[i] = new time(tmp1, tmp2);
		}
		Arrays.sort(times, new Comparator<time>() {
			@Override
		    public int compare(time a, time b) {
				if(a.end == b.end)
					return a.start-b.start;
		        return a.end-b.end;
		    }
		});
		for (int i = 0;i < N; i++) {
			if (tmp<=times[i].start) {
				tmp = times[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
