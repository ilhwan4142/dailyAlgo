package day_0928;

import java.util.Scanner;
 
public class swea_8458 {
 
    static int N, point[];
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
        	
            N = sc.nextInt();
             
            point = new int[N];
            
            int max = 0;
             
            for(int i = 0; i < N; i++) {
                point[i] += Math.abs(sc.nextInt()); // x좌표
                point[i] += Math.abs(sc.nextInt()); // y좌표
                // 전체 원점으로 움직여야하는 횟수 중 가장 큰 값을 구함
                max = Math.max(max, point[i]);
            }
 
            System.out.println("#" + tc + " " + solution(max));
             
        }
    }
     
    static int solution(int max) {
 
        int res = point[0] % 2; // 짝수면 0, 홀수면 1
         
        for(int i = 1; i < N; i++) {
            if(res != point[i]%2)
                return -1; // 홀짝이 섞인 경우
        }
 
        int ans = 0;
        int sum = 0;
         
        while(true) {
 
            if(sum % 2 == res && max <= sum)
                break;
             
            ans++;
            sum += ans;
             
        }
         
        return ans;
    }
}