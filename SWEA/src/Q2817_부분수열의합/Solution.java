package Q2817_부분수열의합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int ans = 0;
    static int[] arr;
    static boolean[] sel;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input2817.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int TC = Integer.parseInt(br.readLine());

	for (int t = 1; t <= TC; t++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());

	    ans = 0;
	    arr = new int[N];
	    sel = new boolean[N];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
	    }
	    subsequence(0, K);
	    System.out.printf("#%d %s\n", t, ans);
	}
    }

    public static void subsequence(int idx, int K) {
	if (arr.length == idx) {
	    int sum = 0;
	    for (int i = 0; i < sel.length; i++) {
		if (sel[i]) {
		    sum += arr[i];
		}
	    }
	    if (sum == K) {
		ans++;
	    }
	    return;
	}

	sel[idx] = true;
	subsequence(idx + 1, K);
	sel[idx] = false;
	subsequence(idx + 1, K);
    }

}
