package Q1216_회문2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    static int ans;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1216.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	for (int TC = 1; TC <= 10; TC++) {
	    int t = Integer.parseInt(br.readLine());
	    char[][] map1 = new char[101][101];
	    char[][] map2 = new char[101][101];
	    ans = 0;

	    for (int i = 1; i < 101; i++) {
		String str = br.readLine();
		for (int j = 1; j < 101; j++) {
		    map1[i][j] = map2[j][i] = str.charAt(j - 1);
		}
	    }

	    for (int palinLen = 100; palinLen > 1; palinLen--) {
		int half = palinLen / 2;
		int rest = palinLen % 2;

		for (int i = 1; i <= 100; i++) {
		    outer: for (int j = half + rest; j <= 100 - half; j++) {
			for (int k = 0; k < half; k++) {
			    if (map1[i][j - rest - k] != map1[i][j + 1 + k]) {
				continue outer;
			    }
			}
			if (palinLen > ans) {
			    ans = palinLen;
			} else {
			    return;
			}
		    }
		}
	    }

	    for (int palinLen = 100; palinLen > 1; palinLen--) {
		int half = palinLen / 2;
		int rest = palinLen % 2;

		for (int i = 1; i <= 100; i++) {
		    outer: for (int j = half + rest; j <= 100 - half; j++) {
			for (int k = 0; k < half; k++) {
			    if (map2[i][j - rest - k] != map2[i][j + 1 + k]) {
				continue outer;
			    }
			}
			if (palinLen > ans) {
			    ans = palinLen;
			} else {
			    return;
			}
		    }
		}
	    }

	    System.out.printf("#%d %d\n", t, ans);
	}

    }
}
