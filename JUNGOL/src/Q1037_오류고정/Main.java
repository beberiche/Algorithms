package Q1037_오류고정;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 배열생성
		int[][] map = new int[N][N];
		// 세로 전용 배열
		int[][] mapC = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = mapC[j][i] = sc.nextInt();
			}
		}

		int error = 0; // 행에대한 에러
		int errorC = 0; // 열에 대한 에러
		int y = 0; // 에러 시 row좌표
		int x = 0; // 에러 시 column좌표
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int sumC = 0;
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
				sumC += mapC[i][j];
			}
			// 해당 sum이 짝수가 아니라면 에러 있음
			if (sumC % 2 != 0) {
				errorC++;
				x = i; // 해당 column 값 전달
			}
			if (sum % 2 != 0) {
				error++;
				y = i; // 해당 row 값 전달
			}

		}

		if (error == 0 && errorC == 0) { // 에러가 없다면 ok!
			System.out.println("OK");
		} else if (error == 1 && errorC == 1) { // 에러가 column, row 1개씩 존재한다면 고칠 수 있다!
			System.out.printf("Change bit (%d,%d)\n", y + 1, x + 1);
		} else { // 그 이외에는 모두 못 고친다!
			System.out.println("Corrupt");
		}
	}
}
