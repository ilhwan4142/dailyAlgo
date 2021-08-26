package day_0817;

import java.util.Scanner;

public class bj_2954 {
	//main 함수
	public static void main(String[] args) {
		
		//TestCase 입력을 받기 위한 Scanner 선언
		Scanner sc = new Scanner(System.in);
		
		//input 값을 저장할 String 변수 선언
		String input = sc.nextLine();
		
		// apa를 a로 변경해서 input에 저장
		input = input.replace("apa", "a");
		// epe를 e로 변경해서 input에 저장
		input = input.replace("epe", "e");
		// ipi를 i로 변경해서 input에 저장
		input = input.replace("ipi", "i");
		// opo를 o로 변경해서 input에 저장
		input = input.replace("opo", "o");
		// upu를 u로 변경해서 input에 저장
		input = input.replace("upu", "u");
		
		//변경된 input 값 출력
		System.out.println(input);
	}
}