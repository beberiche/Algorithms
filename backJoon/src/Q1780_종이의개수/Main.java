package Q1780_종이의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int minOne, zero, one;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		power(0, 0, N);
		System.out.println(minOne);
		System.out.println(zero);
		System.out.println(one);
	}

	public static void power(int r, int c, int size) {
		if (size == 1) {
			// 최소값까지 오면 쪼개기
			if (map[r][c] == -1) {
				minOne++;
			} else if (map[r][c] == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}

		if (check(r, c, size)) {
			if (map[r][c] == -1) {
				minOne++;
			} else if (map[r][c] == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}

		size /= 3;

		power(r, c, size);
		power(r + size, c, size);
		power(r, c + size, size);

		power(r, c + size * 2, size);
		power(r + size, c + size, size);
		power(r + size, c + size * 2, size);

		power(r + size * 2, c, size);
		power(r + size * 2, c + size, size);
		power(r + size * 2, c + size * 2, size);

	}

	private static boolean check(int r, int c, int size) {
		for (int i = r; i < size + r; i++) {
			for (int j = c; j < size + c; j++) {
				if (map[i][j] != map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

}
