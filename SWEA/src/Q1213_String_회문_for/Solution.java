package Q1213_String_회문_for;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
//    public static void main(String[] args) throws Exception {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	for (int i = 1; i <= 10; i++) {
//	    int TC = Integer.parseInt(br.readLine());
//	    char[] P = br.readLine().toString().toCharArray();
//	    char[] T = br.readLine().toString().toCharArray();
//	    System.out.printf("#%d %d\n", TC, pCompT(P, T));
//	}
//    }
//
//    public static int pCompT(char[] p, char[] t) {
//	int N = p.length;
//	int M = t.length;
//
//	int cnt = 0;
//	for (int i = 0; i < M - N + 1; i++) {
//	    boolean flag = true;
//	    for (int j = 0; j < N; j++) {
//		if (p[j] != t[i + j]) {
//		    flag = false;
//		    break;
//		}
//	    }
//	    if (flag)
//		cnt++;
//	}
//	cnt = cnt == 0 ? -1 : cnt;
//	return cnt;
//    }

    static int ans;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1213.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	for (int TC = 1; TC <= 10; TC++) {
	    br.readLine();
	    String P = br.readLine();
	    String T = br.readLine();

	    int cnt = 0;
	    for (int i = 0; i < T.length() - P.length() + 1; i++) {
		for (int j = 0; j < P.length(); j++) {
		    if (P.charAt(j) != T.charAt(i + j)) {
			break;
		    }
		    if (j == P.length() - 1) {
			cnt++;
		    }
		}

	    }
	    System.out.printf("#%d %d\n", TC, cnt);
	}
    }
}