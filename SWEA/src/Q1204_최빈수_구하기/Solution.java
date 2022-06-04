package Q1204_최빈수_구하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int ans;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1204.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	br.readLine();
	for (int TC = 1; TC <= 10; TC++) {
	    int T = Integer.parseInt(br.readLine());

	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int[] countArr = new int[101];

	    while (st.hasMoreTokens()) {
		countArr[Integer.parseInt(st.nextToken())]++;
	    }

	    int max = 0;
	    int result = 0;
	    for (int i = 1; i < 101; i++) {
		if (max <= countArr[i]) {
		    max = countArr[i];
		    result = i;
		}
	    }

	    System.out.printf("#%d %d\n", T, result);
	}

    }
}
