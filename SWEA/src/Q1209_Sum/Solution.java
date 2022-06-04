package Q1209_Sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	for (int tc = 1; tc <= 10; tc++) {
	    int T = Integer.parseInt(br.readLine());
	    int[][] arr = new int[100][100];

	    for (int i = 0; i < 100; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 100; j++) {
		    arr[i][j] = Integer.parseInt(st.nextToken());
		}
	    }

	    int max = Integer.MIN_VALUE;

	    StringBuilder sb = new StringBuilder();
	    sb.append("#").append(T + " ");
	    for (int i = 0; i < 100; i++) {
		int sumR = 0;
		int sumCl = 0;
		int sumCr = 0;
		int revSumCr = 0;
		for (int j = 0; j < 100; j++) {
		    sumR += arr[i][j];
		    sumCl += arr[j][i];
		    max = Math.max(max, Math.max(sumR, sumCl));
		}
		revSumCr += arr[i][99 - i];
		sumCr += arr[i][i];
		max = Math.max(max, Math.max(sumCr, revSumCr));
	    }

	    sb.append(max);
	    System.out.println(sb);
	}
    }
}
