package Q2805_농작물수확하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    static int ans;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input2805.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int TC = Integer.parseInt(br.readLine());

	for (int T = 1; T <= TC; T++) {
	    int N = Integer.parseInt(br.readLine());

	    int[][] farm = new int[N][N];

	    for (int i = 0; i < N; i++) {
		char[] temp = br.readLine().toCharArray();
		for (int j = 0; j < N; j++) {
		    farm[i][j] = temp[j] - '0';
		}
	    }

	    int mid = N / 2;
	    int sum = 0;
	    for (int i = 0; i <= mid; i++) {
		for (int j = mid - i; j <= mid + i; j++) {
		    sum += farm[i][j];
		}
	    }

	    int temp = 1;
	    for (int i = mid + 1; i < N; i++) {
		for (int j = temp; j <= N - 1 - temp; j++) {
		    sum += farm[i][j];
		}
		temp++;
	    }

	    System.out.printf("#%d %d\n", T, sum);
	}
    }
}
