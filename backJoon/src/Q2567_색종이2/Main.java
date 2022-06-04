package Q2567_색종이2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int[][] map = new int[101][101];
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    int row = sc.nextInt();
	    int column = sc.nextInt();
	    for (int r = row; r < row + 10; r++) {
		for (int c = column; c < column + 10; c++) {
		    map[r][c] = 1; // 해당 색종이 영역을 모두 1로 표시
		}
	    }
	}

	// 4방 탐색
	// 둘레는 해당 지역 중 상하좌우 가운데 1곳이라도 0이라면
	// 색종이의 겉면에 해당하는 곳이 된다.
	// 만약 상하좌우 가운데 0인 곳이 2곳이라면 그곳이 색종이의 꼭지점이고 가로 및 세로 둘레
	// 모두 카운트해야하므로, 카운트 중복이 가능하도록 조건을 설정한다.
	int round = 0;
	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map.length; j++) {
		if (map[i][j] == 1) {
		    // 중복이 가능하도록 continue break는 쓰지 말자.
		    if (map[i - 1][j] == 0)
			round++;
		    if (map[i][j - 1] == 0)
			round++;
		    if (map[i + 1][j] == 0)
			round++;
		    if (map[i][j + 1] == 0)
			round++;
		}
	    }
	}
	System.out.println(round);
    }
}
