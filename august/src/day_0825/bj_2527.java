package day_0825;

import java.util.Scanner;

public class bj_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			String tmp;

			if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)
				tmp = "d";
			else if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2)
					|| (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2))
				tmp = "c";
			else if ((p1 == x2 && q1 != y2) || (x1 == p2 && q1 != y2)
					|| (p1 != x2 && y1 == q2) || (x1 != p2 && y1 == q2))
				tmp = "b";
			else
				tmp = "a";
			System.out.println(tmp);
		}

	}
}
