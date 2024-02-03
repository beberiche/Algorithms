package pattern_matching;

public class 브루트포스 {
	public static void main(String[] args) {
		char[] text = "This iss a book".toCharArray();
		char[] pattern = "iss".toCharArray();
		System.out.println(bruteForceFor(text, pattern));
	}

	public static int bruteForceWhile(char[] t, char[] p) {
		int i = 0; // t의 인덱스
		int j = 0; // p의 인덱스

		int N = t.length; // t의 길이
		int M = p.length; // p의 길이

		while (j < M && i < N) {
			if (t[i] != p[j]) {
				i -= j;
				j = -1;
			}
			i++;
			j++;
		}
		if (j == M) {
			return i - M;
		}
		return -1;
	}

	public static int bruteForceFor(char[] t, char[] p) {
		int N = t.length;
		int M = p.length;

		for (int i = 0; i < N - M + 1; i++) {
			boolean flag = true;

			for (int j = 0; j < M; j++) {
				if (p[j] != t[i + j]) {
					flag = false;
					break;
				}
			}
			// 아직까지 flag가 true라는 소리는 패턴을 찾았다 i번째 시작하는 자리에서
			if (flag)
				return i;

		}
		// 찾지 못했다면
		return -1;
	}
}
