package Q1213_String_회문_while;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
//    public static void main(String[] args) throws Exception {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	for (int i = 0; i < 10; i++) {
//	    int TC = Integer.parseInt(br.readLine());
//	    char[] P = br.readLine().toString().toCharArray();
//	    char[] T = br.readLine().toString().toCharArray();
//	    System.out.printf("#%d %d\n", TC, pCompT(T, P));
//	}
//    }
//
//    public static int pCompT(char[] t, char[] p) {
//	int N = t.length;
//	int M = p.length;
//
//	int i = 0, j = 0, cnt = 0;
//	while (j < M && i < N) {
//	    if (t[i] != p[j]) {
//		i -= j;
//		j = -1;
//	    }
//	    i++;
//	    j++;
//	    if (j == M) {
//		j = 0;
//		cnt++;
//	    }
//	}
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

	    int lenp = P.length();
	    int lent = T.length();
	    int p = 0;
	    int t = 0;

	    int cnt = 0;
	    while (lenp > p && lent > t) {
		if (P.charAt(p) != T.charAt(t)) {
		    t -= p;
		    p = -1;
		}
		t++;
		p++;
		if (p == lenp) {
		    p = 0;
		    cnt++;
		}
	    }
	    System.out.printf("#%d %d\n", TC, cnt);

	}

    }
}
