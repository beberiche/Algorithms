package Q1215_회문1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int N = 8;

	String[][] map = new String[N][N];

	for (int TC = 1; TC <= 10; TC++) {
	    int rot = Integer.parseInt(br.readLine());

	    for (int i = 0; i < 8; i++) {
		map[i] = br.readLine().split("");
	    }

	    System.out.printf("#%d %d\n", TC, comp(rot, N, map));
	}
    }

    public static int comp(int rot, int len, String[][] map) {

	int cnt = 0;
	for (int i = 0; i < len; i++) {
	    for (int j = 0; j < len; j++) {
		if (j + rot > len) {
		    break;
		} else {
		    String rev1 = "";
		    String rev2 = "";
		    String text1 = "";
		    String text2 = "";
		    for (int k = rot - 1; k >= 0; k--) {
			rev1 += map[i][j + k];
			rev2 += map[j + k][i];
		    }
		    for (int k = 0; k < rot; k++) {
			text1 += map[i][j + k];
			text2 += map[j + k][i];
		    }
		    if (text1.equals(rev1)) {
			cnt++;
		    }
		    if (text2.equals(rev2)) {
			cnt++;
		    }
		}

	    }
	}

	return cnt;
    }
}
