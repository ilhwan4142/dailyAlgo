package day_0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_12738 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now > list.get(list.size() - 1)) {
				list.add(now);
			} else {
				int start = 0;
				int end = list.size() - 1;

				while (start < end - 1) {
					int mid = (start + end) / 2;
					if (list.get(mid) < now) {
						start = mid;
					} else {
						end = mid;
					}
				}
				 list.set(end, now);
			}
		}

		System.out.println(list.size() - 1);
	}

}