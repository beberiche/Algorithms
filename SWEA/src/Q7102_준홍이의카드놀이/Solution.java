package Q7102_준홍이의카드놀이;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input7102.txt"));
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	for (int TC = 1; TC <= T; TC++) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int[] count = new int[n + m + 1];

	    for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
		    count[i + j]++;
		}
	    }

	    int max = 0;
	    for (int i = 0; i < count.length; i++) {
		if (max < count[i])
		    max = count[i];
	    }

	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < count.length; i++) {
		if (count[i] == max) {
		    sb.append(i + " ");
		}
	    }

	    System.out.println("#" + TC + " " + sb.toString());
	}
    }
}
