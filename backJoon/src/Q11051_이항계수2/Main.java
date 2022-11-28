package Q11051_이항계수2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int ans = 0;
		int[][] dp = new int[N+1][N+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=i; j<dp[i].length; j++) {
				if(i==j || i==0) {
					dp[i][j] =1;
					continue;
				} 
				dp[i][j] = (dp[i][j-1] + dp[i-1][j-1])%10007;
			}
		}
		System.out.println(dp[K][N]);
	}
}
