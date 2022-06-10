package Q1593_문자해독;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		char[] W = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();

		int[] wAbc = new int[52];
		int[] sAbc = new int[52];

		for (char ch : W) {
			if ('a' <= ch && ch <= 'z')
				wAbc[ch - 'a']++;
			else
				wAbc[ch - 'A' + 26]++;

		}

		for (int i = 0; i < W.length-1; i++) {
			if ('a' <= S[i] && S[i] <= 'z')
				sAbc[S[i] - 'a']++;
			else
				sAbc[S[i] - 'A' + 26]++;
		}
		
		int st = 0;
		int ans = 0;
		for (int i = W.length-1; i < S.length; i++) {
			if ('a' <= S[i] && S[i] <= 'z')
				sAbc[S[i] - 'a']++;
			else
				sAbc[S[i] - 'A' + 26]++;

			if (Arrays.equals(wAbc, sAbc))
				ans++;
			
			if ('a' <= S[st] && S[st] <= 'z')
				sAbc[S[st] - 'a']--;
			else
				sAbc[S[st] - 'A' + 26]--;
			st++;
		}
		System.out.println(ans);
	}
}