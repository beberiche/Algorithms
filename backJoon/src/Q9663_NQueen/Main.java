package Q9663_NQueen;

import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static int[] queen;
	static int N;

	public static void main(String[] args) {
		N = new Scanner(System.in).nextInt();
		queen = new int[N+1];
		findNoAttackQueens(1);
		System.out.println(cnt);
	}

	private static void findNoAttackQueens(int idx) {
		// TODO Auto-generated method stub
		if(idx == N+1) {
			cnt++;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			queen[idx]=i;
			if(isValid(idx))
				findNoAttackQueens(idx+1);
		}
	}

	private static boolean isValid(int idx) {
		// TODO Auto-generated method stub
		for(int i=1; i<idx; i++) {
			if(queen[i] == queen[idx])
				return false;
			if(idx-i ==Math.abs(queen[idx]-queen[i]))
				return false;
		}
		return true;
	}
}