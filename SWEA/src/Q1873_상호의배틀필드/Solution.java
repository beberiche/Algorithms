package Q1873_상호의배틀필드;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static String cmds;
	static char[][] battleField;
	static int[] stIdx;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1873.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans = 0;
		for (int TC = 1; TC <= T; TC++) {
			N = sc.nextInt();
			M = sc.nextInt();

			// 입력
			battleField = new char[N][M];
			stIdx = new int[2]; // 시작좌표 찾기
			for (int i = 0; i < N; i++) {
				battleField[i] = sc.next().toCharArray();
				for (int j = 0; j < M; j++) {
					if (battleField[i][j] == '^' || battleField[i][j] == '>' || battleField[i][j] == 'v'
							|| battleField[i][j] == '<') {
						stIdx[0] = i;
						stIdx[1] = j;
					}
				}
			}

			// 명령 수행
			int cmdsLen = sc.nextInt();
			cmds = sc.next();

			for (int i = 0; i < cmdsLen; i++) {
				char curDir = battleField[stIdx[0]][stIdx[1]];
				if (cmds.charAt(i) == 'U' || cmds.charAt(i) == 'R' || cmds.charAt(i) == 'L' || cmds.charAt(i) == 'D') {
					rotate(cmds.charAt(i));
				} else {
					command(curDir, stIdx[0], stIdx[1]);
				}
			}

			System.out.printf("#%d ", TC);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(battleField[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static void command(char curDir, int y, int x) {
		switch (curDir) {
		case '^': {
			int idx = 0;
			while (true) {
				if (stIdx[0] - 1 + idx < 0) {
					break;
				}
				if (battleField[stIdx[0] - 1 + idx][stIdx[1]] == '.'
						|| battleField[stIdx[0] - 1 + idx][stIdx[1]] == '-') {
					idx--;
					continue;
				}
				if (battleField[stIdx[0] - 1 + idx][stIdx[1]] == '#') {
					break;
				}
				if (battleField[stIdx[0] - 1 + idx][stIdx[1]] == '*') {
					battleField[stIdx[0] - 1 + idx][stIdx[1]] = '.';
					break;
				}
			}
			break;
		}
		case 'v': {
			int idx = 0;
			while (true) {
				if (stIdx[0] + 1 + idx >= N) {
					break;
				}
				if (battleField[stIdx[0] + 1 + idx][stIdx[1]] == '.'
						|| battleField[stIdx[0] + 1 + idx][stIdx[1]] == '-') {
					idx++;
					continue;
				}
				if (battleField[stIdx[0] + 1 + idx][stIdx[1]] == '#') {
					break;
				}
				if (battleField[stIdx[0] + 1 + idx][stIdx[1]] == '*') {
					battleField[stIdx[0] + 1 + idx][stIdx[1]] = '.';
					break;
				}
			}
			break;
		}
		case '>': {
			int idx = 0;
			while (true) {
				if (stIdx[1] + 1 + idx >= M) {
					break;
				}
				if (battleField[stIdx[0]][stIdx[1] + 1 + idx] == '.'
						|| battleField[stIdx[0]][stIdx[1] + 1 + idx] == '-') {
					idx++;
					continue;
				}
				if (battleField[stIdx[0]][stIdx[1] + 1 + idx] == '#') {
					break;
				}
				if (battleField[stIdx[0]][stIdx[1] + 1 + idx] == '*') {
					battleField[stIdx[0]][stIdx[1] + 1 + idx] = '.';
					break;
				}
			}
			break;
		}
		case '<': {
			int idx = 0;
			while (true) {
				if (stIdx[1] - 1 + idx < 0) {
					break;
				}
				if (battleField[stIdx[0]][stIdx[1] - 1 + idx] == '.'
						|| battleField[stIdx[0]][stIdx[1] - 1 + idx] == '-') {
					idx--;
					continue;
				}
				if (battleField[stIdx[0]][stIdx[1] - 1 + idx] == '#') {
					break;
				}
				if (battleField[stIdx[0]][stIdx[1] - 1 + idx] == '*') {
					battleField[stIdx[0]][stIdx[1] - 1 + idx] = '.';
					break;
				}
			}

		}
		}
	}

	public static void rotate(char c) {
		switch (c) {
		case 'U':
			battleField[stIdx[0]][stIdx[1]] = '^';
			if (stIdx[0] - 1 < 0) {
				break;
			}
			if (battleField[stIdx[0] - 1][stIdx[1]] == '.') {
				char temp = battleField[stIdx[0]][stIdx[1]];
				battleField[stIdx[0]][stIdx[1]] = battleField[stIdx[0] - 1][stIdx[1]];
				battleField[stIdx[0] - 1][stIdx[1]] = temp;
				stIdx[0] -= 1;
			}
			break;
		case 'D':
			battleField[stIdx[0]][stIdx[1]] = 'v';
			if (stIdx[0] + 1 >= N) {
				break;
			}
			if (battleField[stIdx[0] + 1][stIdx[1]] == '.') {
				char temp = battleField[stIdx[0]][stIdx[1]];
				battleField[stIdx[0]][stIdx[1]] = battleField[stIdx[0] + 1][stIdx[1]];
				battleField[stIdx[0] + 1][stIdx[1]] = temp;
				stIdx[0] += 1;
			}
			break;
		case 'L':
			battleField[stIdx[0]][stIdx[1]] = '<';
			if (stIdx[1] - 1 < 0) {
				break;
			}
			if (battleField[stIdx[0]][stIdx[1] - 1] == '.') {
				char temp = battleField[stIdx[0]][stIdx[1]];
				battleField[stIdx[0]][stIdx[1]] = battleField[stIdx[0]][stIdx[1] - 1];
				battleField[stIdx[0]][stIdx[1] - 1] = temp;
				stIdx[1] -= 1;
			}
			break;
		case 'R':
			battleField[stIdx[0]][stIdx[1]] = '>';
			if (stIdx[1] + 1 >= M) {
				break;
			}
			if (battleField[stIdx[0]][stIdx[1] + 1] == '.') {
				char temp = battleField[stIdx[0]][stIdx[1]];
				battleField[stIdx[0]][stIdx[1]] = battleField[stIdx[0]][stIdx[1] + 1];
				battleField[stIdx[0]][stIdx[1] + 1] = temp;
				stIdx[1] += 1;
			}
			break;
		}
	}
}
