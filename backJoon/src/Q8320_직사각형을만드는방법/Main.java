package Q8320_직사각형을만드는방법;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 제곱근 활용
		// 만약 블럭을 총 9개 가지고 있다고 치자면
		// 가로를 기준으로 한다면 총 3까지이다.
		// ex) 2,4 / 4,2 사각형은 중복되기 때문에 3까지만 하면 되는 것!!
		int sqrt = (int) Math.sqrt(N);
		int cnt = 0;

		for (int i = 1; i <= sqrt; i++) {
			for (int j = i; j <= N / i; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
