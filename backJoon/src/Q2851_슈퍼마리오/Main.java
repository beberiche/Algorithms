package Q2851_슈퍼마리오;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = 10; // 버섯수는 10개로 고정
	int sum = 0; // 버섯을 통해 얻은 점수를 합치기
	// 반복문 시작
	while (--n >= 0) {
	    int N = sc.nextInt();

	    if (sum + N > 100) { // 더해지는 값이 이제 한번만 더 더하면 100을 넘는 경우
		int num1 = 100 - sum; // 지금까지 더해온 것(100미만)과 100과 거리
		int num2 = sum + N - 100; // 미래에 더해진 양(100초과)과 100과의 거리
		if (num2 < num1 || num2 == num1) // 미래에 더해지는 것이 더 거리가 가깝거나 혹은
						 // 두 수 모두 거리가 동일하다면
		    sum += N; // 더한 뒤 브레이크!!!
		break;
	    }
	    sum += N; // 아직 조건문에 도달하지 않았으므로 더해주고 다시 반복
	}
	System.out.println(sum);
    }
}
