package day_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] ans = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1; i >= 0; i--) {
			while(!stack.isEmpty() && stack.peek() <= arr[i])
				stack.pop();
			
			if(stack.isEmpty()) ans[i] = -1;
			else ans[i] = stack.peek();
			
			stack.add(arr[i]);
		}
			
		for(int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
