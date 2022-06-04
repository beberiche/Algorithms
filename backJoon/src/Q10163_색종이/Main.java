package Q10163_색종이;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();

	int[][] map = new int[1001][1001]; // 맵 설정
	for (int TC = 1; TC <= T; TC++) {
	    int y = sc.nextInt(); // 시작좌표 r
	    int x = sc.nextInt(); // 시작좌표 c
	    int dy = sc.nextInt(); // y에서 부터 이동할 거리
	    int dx = sc.nextInt(); // x에서 부터 이동할 거리

	    for (int i = y; i < y + dy; i++) {
		for (int j = x; j < x + dx; j++) {
		    // 테스트 케이스 인덱스가 측정되게 한다.
		    // 색종이 1에는 1, 색종이 2에는 2...
		    map[i][j] = TC;
		}
	    }
	}

	for (int TC = 1; TC <= T; TC++) {
	    int cnt = 0;
	    for (int i = 0; i < 1001; i++) {
		for (int j = 0; j < 1001; j++) {
		    if (map[i][j] == TC) // 해당 테스트케이스의 idx를 가진 부분만 카운트 누적하면 그게 해당 색종이의 총 영역
			cnt++;
		}
	    }
	    System.out.println(cnt);
	}
    }
}
