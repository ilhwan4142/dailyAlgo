package day_0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_14003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1000000001);
		
		int[] arr = new int[N];
		int[] idx = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int num = arr[i];
			int start = 1;
			int end = list.size() - 1;
            
			if(num > list.get(list.size() - 1)){
				list.add(num);
				idx[i] = list.size() - 1;
			}else{
				while(start < end){
					int mid = (start + end) / 2;

					if(list.get(mid) >= num) end = mid;
					else start = mid + 1;
				}
				list.set(end, num);
				idx[i] = end;
			}
		} 
		
		sb.append(list.size() - 1);
		sb.append(System.lineSeparator());
		
		Stack<Integer> stack = new Stack<>();
        
		int index = list.size() - 1;
        
		for(int i = N - 1; i >= 0; i--) {
			if(idx[i] == index){
				index--;
				stack.push(arr[i]);
			}
		}
        
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb);
	}

}
