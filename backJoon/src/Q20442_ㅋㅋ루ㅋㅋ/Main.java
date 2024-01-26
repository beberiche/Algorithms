package Q20442_ㅋㅋ루ㅋㅋ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();


		int rCnt = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'R') rCnt++;
		}

		int[] lk = new int[rCnt];
		int[] rk = new int[rCnt];
		int idxL = 0;
		int idxR = rCnt;
		int kCntL = 0;
		int kCntR = 0;
		for (int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
			if (str.charAt(i) == 'K') kCntL++;
			else lk[idxL++] = kCntL;

			if (str.charAt(j) == 'K') kCntR++;
			else rk[--idxR] = kCntR;
		}

		int l = 0;
		int r = rCnt-1;
		int mid = 0;
		while (l <= r) {
			mid = Math.max(mid, (r - l + 1) + 2 * (Math.min(lk[l], rk[r])));
			if (lk[l] < rk[r]) l++;
			else r--;
		}
		System.out.println(mid);
	}
}
