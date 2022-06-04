package Q2563_색종이;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int[][] map = new int[101][101];
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    int row = sc.nextInt();
	    int column = sc.nextInt();
	    for (int r = row + 1; r <= row + 10; r++) {
		for (int c = column + 1; c <= column + 10; c++) {
		    map[r][c] += 1; // 해당 색종이 영역을 1씩 높여준다.
				    // 추가
				    // 생각해보니 그냥 1로 표현하고
				    // 1에 해당하는 것만 카운트 해도 될 듯...
		}
	    }
	}

	// 색종이는 총 3장,
	// 누적된 카운트가 2,3 인곳은 색종이가 2장 3장 겹쳐졌다는 것이다.
	// 0이 아닌 모든 수(1,2,3)을 체크하여 카운트 하면
	// 그게 색종이 전체의 넓이일 것이다.

	int cnt = 0;
	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map.length; j++) {
		if (map[i][j] != 0)
		    cnt++;
	    }
	}
	System.out.println(cnt);
    }
}
