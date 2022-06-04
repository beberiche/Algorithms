package Q7087_문제제목붙이기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input7087.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();

			// 어짜피 앞에 있는 대문자 하나만 보고 판단하니
			// char를 통해 대문자 하나만 받아주자.
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().charAt(0);
			}

			char st = 65; // A = 65
			int ans = 0;
			while (st <= 90) { // Z까지 돌린다.
				int cnt = 0;
				// 반복문을 돌면서 같은 값이 있는지 찾아
				// 카운트 해준다.
				for (int i = 0; i < N; i++) {
					if (arr[i] != st)
						continue;
					cnt++;
				}
				// 카운트가 안되었다면
				// 더이상 제목을 쓸 수 없다는 얘기
				if (cnt == 0)
					break;

				// 쓸수있는게 있다면
				// 정답을 추가해주고 다음 문자로 넘어간다.
				ans++;
				st++;
			}

			System.out.printf("#%d %d\n", TC, ans);
		}
	}
}
