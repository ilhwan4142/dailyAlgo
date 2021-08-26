package day_0823;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class swea_1238 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            Queue<Integer> q = new LinkedList<>();
            int n = sc.nextInt();
            int s = sc.nextInt();
            int ans = 0;
            int max = 0;
            int[] v = new int[101];
            int[][] map = new int[101][101];
            for (int i = 0; i < n / 2; i++) {
                int tmp1 = sc.nextInt();
                int tmp2 = sc.nextInt();
                map[tmp1][tmp2] = 1;
            }
            q.offer(s);
            v[s]=1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i = 1; i <= 100; i++) {
                    if (map[cur][i] == 1 && v[i] == 0) {
                        v[i] = v[cur] + 1;
                        q.offer(i);
                    }
                }
                max = v[cur];
            }
            for(int i = 1 ; i<= 100; i++) {
                if(max != v[i]) continue;
                ans = ans > i ? ans : i;
            }
            System.out.println("#" + tc + " " + ans);
        }
 
    }
 
}
