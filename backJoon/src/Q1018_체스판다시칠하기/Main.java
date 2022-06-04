package Q1018_체스판다시칠하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			board[i] = arr;
		}

		int min = 1250;

		// 8칸씩 잡고 1칸씩 전진하며 해결하기
		char[][] t1 = template('B', 'W'); // 왼쪽이 W인 경우
		char[][] t2 = template('W', 'B'); // 왼쪽이 B인 경우
		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				int cnt1 = 0;
				int cnt2 = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (board[i + r][j + c] != t1[i][j])
							cnt1++;
						if (board[i + r][j + c] != t2[i][j])
							cnt2++;
					}
				}
				min = Math.min(min, Math.min(cnt1, cnt2));
			}
		}
		System.out.println(min);
	}

	// 템플릿 만들기
	public static char[][] template(char c1, char c2) {
		char[][] templates = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j % 2 == 0) {
					templates[i][j] = c1;
				} else {
					templates[i][j] = c2;
				}
			}
			char tmp = c1;
			c1 = c2;
			c2 = tmp;
		}
		return templates;
	}

}
