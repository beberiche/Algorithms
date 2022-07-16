package Q6978_월드컵;

import java.util.Scanner;

public class Main {
	static final int[] home = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static final int[] away = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	static int[][] score;
	static boolean check;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		score = new int[6][3];
		
		int N = 4;
		while (--N >= 0) {
			int win = 0;
			int lose = 0;
			int draw = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					score[i][j] = sc.nextInt();
					if (j == 0) {
						win += score[i][j];
					} else if (j == 1) {
						draw += score[i][j];
					} else {
						lose += score[i][j];
					}
				}
			}

			ans = 1;
			if (win + lose + draw != 30 || win != lose || draw % 2 !=0) {
				ans = 0;
			} else {
				check = false;
				DFS(0);
				ans = check ? 1: 0;
			}
			System.out.print(ans + " ");
		}
	}

	private static void DFS(int idx) {
		// TODO Auto-generated method stub
		if(idx == 15) {
			check = true;
			return;
		}
		
		int currH = home[idx];
		int currA = away[idx];
		
		// home팀이 이기고 away팀이 지는 경우
		if(score[currH][0] > 0 && score[currA][2] > 0) {
			score[currH][0]--;
			score[currA][2]--;
			DFS(idx+1);
			score[currH][0]++;
			score[currA][2]++;
		} 
		// away팀이 이기고 home팀이 지는 경우
		if(score[currH][2] > 0 && score[currA][0] > 0) {
			score[currH][2]--;
			score[currA][0]--;
			DFS(idx+1);
			score[currH][2]++;
			score[currA][0]++;
		}
		
		// 무승부인 경우
		if(score[currH][1] > 0 && score[currA][1] > 0) {
			score[currH][1]--;
			score[currA][1]--;
			DFS(idx+1);
			score[currH][1]++;
			score[currA][1]++;
		}
	}
}
