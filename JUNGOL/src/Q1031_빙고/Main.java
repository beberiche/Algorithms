package Q1031_빙고;

import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int call = sc.nextInt();
				callNum(call);
			}
		}
	}

	private static void callNum(int call) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == call) {
					arr[i][j] = -1;
					ans++;
					checkLine();
				}
			}
		}
	}

	private static void checkLine() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i][0] == -1 && arr[i][1] == -1 && arr[i][2] == -1 && arr[i][3] == -1
					&& arr[i][4] == -1) {
				cnt++;
			}
			if (arr[0][i] == -1 && arr[1][i] == -1 && arr[2][i] == -1 && arr[3][i] == -1
					&& arr[4][i] == -1) {
				cnt++;
			}
		}
		
		if (arr[0][0] == -1 && arr[1][1] == -1 && arr[2][2] == -1 && arr[3][3] == -1
				&& arr[4][4] == -1) {
			cnt++;
		}
		if (arr[0][4] == -1 && arr[1][3] == -1 && arr[2][2] == -1 && arr[3][1] == -1
				&& arr[4][0] == -1) {
			cnt++;
		}
		
		if(cnt>=3) {
			System.out.println(ans);
			System.exit(0);
		}
	}
}
