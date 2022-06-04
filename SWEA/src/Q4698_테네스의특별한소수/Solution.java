package Q4698_테네스의특별한소수;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input4698.txt"));
		Scanner sc = new Scanner(System.in);

		// 10^6 최대
		// 일단 최대로 많이 소수를 찾아보자.
		boolean[] checkPrime = new boolean[1000001];
		checkPrime[0] = true; // 0은 소수 아님
		checkPrime[1] = true; // 1도 소수 아님

		for (int i = 2; i < 1000001; i++) {
			if (!checkPrime[i]) {
				// 보통은 i*i를 많이쓰는 편인데 (i*i는 i로 나눠지니까 소수가 아니기 때문에)
				// 최대 수가 워낙 크다보니 int값을 넘어서 안된다.
				// i * 2로 하니 가능 했다.
				for (int j = i * 2; j < 1000001; j += i) {
					checkPrime[j] = true;
				}
			}
		}

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {

			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();

			int cnt = 0;
			for (int i = A; i < B; i++) {
				// A~B 가운데 D를 가진 숫자를 찾자
				// A,B를 문자로 바꾼후, D를 포함하고 있는 지 확인
				if (!checkPrime[i] && String.valueOf(i).contains(D + ""))
					cnt++;
			}

			System.out.printf("#%d %d\n", TC, cnt);
		}
	}
}
