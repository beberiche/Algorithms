package Q1210_ladder1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();

	for (int tc = 1; tc <= 10; tc++) {
	    int T = Integer.parseInt(br.readLine());
	    int[][] ladder = new int[100][100];

	    for (int i = 0; i < 100; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 100; j++) {
		    ladder[i][j] = Integer.parseInt(st.nextToken());
		}
	    }

	    // 도착점 찾기
	    int goal = 0;
	    for (int i = 0; i < 100; i++) {
		if (ladder[99][i] == 2) {
		    goal = i;
		}
	    }

	    // 끝에서 부터 탐색
	    int r = 99;
	    int c = goal;
	    int dir = 1;
	    // dir = 1 // 위로 이동
	    // dir = 2 // 좌로 이동
	    // dir = 3 // 우로 이동

	    while (true) {
		if (r == 0) {
		    sb.append("#").append(T).append(" ").append(c).append("\n");
		    break;
		}

		// 기본 예측 방향설정 (1~98)
		if (c - 1 >= 0 && c + 1 < 100) {
		    if (dir == 1 && ladder[r][c - 1] == 1) {
			dir = 2;
		    } else if (dir == 1 && ladder[r][c + 1] == 1) {
			dir = 3;
		    } else if (ladder[r - 1][c] == 1)
			dir = 1;
		}

		// 열의 끝에 도달 할 시 설정 (0,99)
		if (c == 0) {
		    if (dir == 1 && ladder[r][c + 1] == 1) {
			dir = 3;
		    } else {
			dir = 1;
		    }
		}

		if (c == 99) {
		    if (dir == 1 && ladder[r][c - 1] == 1) {
			dir = 2;
		    } else {
			dir = 1;
		    }
		}

		// 위로 이동
		if (dir == 1 && r - 1 >= 0) {
		    r--;
		    continue;
		}

		// 좌로 이동
		if (dir == 2 && c - 1 >= 0) {
		    c--;
		    continue;
		}

		// 우로 이동
		if (dir == 3 && c + 1 < 100) {
		    c++;
		    continue;
		}

	    }

	}
	System.out.println(sb);
    }
}
