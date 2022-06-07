package Q7682_틱택토;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			map = new char[3][3];
			String str = br.readLine();
			if (str.equals("end"))
				return;

			char[] temp = str.toCharArray();

			int idx = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = temp[idx++];
				}
			}
			detailMap();
		}
	}

	private static void detailMap() {
		int x = 0;
		int o = 0;
		int comma = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == 'X')
					x++;
				else if (map[i][j] == 'O')
					o++;
				else
					comma++;
			}
		}

		boolean checkO = checkLine('O');
		boolean checkX = checkLine('X');
		// 빈칸이 없는 경우
		if (comma == 0) {
			// 맵이 꽉차있는 경우에는
			// 1. x-1 == o 와 x+o== 9가 성립해야한다.
			// 2. x는  라인이 있는데 o가 라인이 없거나 혹은 x,o 모두 라인이 없는 상태여야한다.
			if (x - 1 == o && x + o == 9) {
				if ((checkX && !checkO) || (!checkX && !checkO))
					System.out.println("valid");
				else {
					System.out.println("invalid");
				}
			} else {
				System.out.println("invalid");
			}
		} else {
			if (x == o) {
				// 현재 o의 플레이인 경우
				// 1. o가 라인이 있는 경우 -> 최종 -> valid
				// 2. x가 라인이 있는 경우 -> 있을 수가 없음 그전판에 끝났어야 한다. -> invalid
				// 3. o가 라인이 없는 경우 -> 아직 최종 아님 -> invalid
				// 4. x가 라인이 없는 경우 -> 아직 최종 아님 -> invalid;
				if (checkO) {
					if (!checkX)
						System.out.println("valid");
					else
						System.out.println("invalid");
				} else
					System.out.println("invalid");

			} else if (x - 1 == o) {
				// 현재 x의 플레이인 경우
				// 1. o가 라인이 있는 경우 -> 있을 수가 없음 그전판에 끝났어야 한다. -> invalid
				// 2. x가 라인이 있는 경우 -> 최종 -> valid
				// 3. o가 라인이 없는 경우 -> 아직 최종 아님 -> invalid
				// 4. x가 라인이 없는 경우 -> 아직 최종 아님 -> invalid
				if (!checkO) {
					if (checkX)
						System.out.println("valid");
					else
						System.out.println("invalid");

				} else
					System.out.println("invalid");
			} else
				// 아예 o와 x의 개수가 서로 안맞는 경우이다.
				System.out.println("invalid");
		}
	}

	private static boolean checkLine(char ch) {
		// 가로
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == ch && map[i][0] == map[i][1] && map[i][1] == map[i][2])
				return true;
		}

		// 세로
		for (int i = 0; i < 3; i++) {
			if (map[0][i] == ch && map[0][i] == map[1][i] && map[1][i] == map[2][i])
				return true;
		}

		// 대각선 ↘
		if (map[0][0] == ch && map[0][0] == map[1][1] && map[1][1] == map[2][2])
			return true;

		// 대각선 ↙
		if (map[0][2] == ch && map[0][2] == map[1][1] && map[1][1] == map[2][0])
			return true;

		return false;
	}
}
