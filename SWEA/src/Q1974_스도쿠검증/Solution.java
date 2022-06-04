package Q1974_스도쿠검증;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1974.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int T = Integer.parseInt(br.readLine());
	for (int TC = 1; TC <= T; TC++) {
	    int ans = 1;

	    int[][] sdoku = new int[9][9];
	    int[][] sdoku2 = new int[9][9];

	    for (int i = 0; i < 9; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 9; j++) {
		    int n = Integer.parseInt(st.nextToken());
		    sdoku[i][j] = n;
		    sdoku2[j][i] = n;
		}
	    }

	    for (int i = 0; i < 9; i++) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int j = 0; j < 9; j++) {
		    set.add(sdoku[i][j]);
		    set2.add(sdoku2[i][j]);
		}

		if (set.size() != 9 || set2.size() != 9) {
		    ans = 0;
		}
	    }

	    for (int i = 0; i < 3; i += 3) {
		for (int j = 0; j < 3; j += 3) {
		    int sum = 0;
		    for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
			    sum += sdoku[i + k][j + l];
			}
		    }
		    if (sum != 45) {
			ans = 0;
			break;
		    }
		}
	    }
	    System.out.printf("#%d %d\n", TC, ans);
	}
    }
}
