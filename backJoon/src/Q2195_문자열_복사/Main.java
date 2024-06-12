package Q2195_문자열_복사;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String P = br.readLine();

		int idx_p = 0;
		int ans = 0;
		while (idx_p < P.length()) {
			ans++;
			char ch_p = P.charAt(idx_p);

			int max = 0;
			for (int i = 0; i < S.length(); i++) {
				char ch_s = S.charAt(i);
				if (ch_p == ch_s) {
					int tmp = idx_p;
					for (int j = i; j < S.length() && tmp < P.length(); j++) {
						if (S.charAt(j) != P.charAt(tmp)) break;
						tmp++;
					}
					max = Math.max(max, tmp);
				}
			}
			idx_p = max;
		}
		System.out.println(ans);
	}
}
