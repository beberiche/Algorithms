package 거리두기_확인하기;

import java.util.*;

class Solution {
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		Arrays.fill(answer, 1);
		final int[] dr = new int[] { 1, 0, 0, -1, -1, -1, 1, 1 };
		final int[] dc = new int[] { 0, 1, -1, 0, -1, 1, -1, 1 };

		for (int i = 0; i < 5; i++) {
			char[][] temp = new char[5][5];
			for (int j = 0; j < 5; j++) {
				temp[j] = places[i][j].toCharArray();
			}
			outer: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (temp[r][c] == 'P') {
						boolean[] check = new boolean[4];

						for (int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
								continue;
							}
							if (d < 4) {
								if (check[d]) {
									continue;
								}
								if (temp[nr][nc] == 'X') {
									check[d] = true;
								}
								if (temp[nr][nc] == 'P') {
									answer[i] = 0;
									break outer;
								}
							} else {
								if (temp[nr][nc] == 'P') {
									if (temp[nr][c] != 'X' || temp[r][nc] != 'X') {
										answer[i] = 0;
										break outer;
									}
								}
							}
						}
						for (int ds = 0; ds < 4; ds++) {
							if (check[ds])
								continue;

							int nr = r + dr[ds] * 2;
							int nc = c + dc[ds] * 2;
							if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
								continue;
							}
							if (temp[nr][nc] == 'P') {
								answer[i] = 0;
								break outer;
							}

						}
					}
				}
			}
		}
		return answer;
	}
}