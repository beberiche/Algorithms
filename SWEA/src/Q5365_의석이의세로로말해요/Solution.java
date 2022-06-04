package Q5365_의석이의세로로말해요;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input5365.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans = 0;
		for (int TC = 1; TC <= T; TC++) {
			// 총길이는 15이므로 15까지 포함하기 위해 N+1
			char[][] board = new char[5][16];

			for (int i = 0; i < 5; i++) {
				StringBuilder sb = new StringBuilder(sc.next());
				int len = sb.length();
				// 길이가 부족한 글들의 경우
				// 부족한 만큼 채워주기
				for (int j = 1; j < 16 - len; j++) {
					sb.append("#"); // "#"으로 채움 어떤 거든 괜춘
				}
				// 채운뒤 배열에 집어넣기
				board[i] = sb.toString().toCharArray();
			}

			System.out.printf("#%d ", TC);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					// 부족하다고 나온 부분들 제외 하고 출력
					if (board[j][i] != '#') {
						sb.append(board[j][i]);
					}
				}
			}
			sb.append("\n");
			System.out.print(sb.toString());
		}
	}
}
