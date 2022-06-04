package Q7964_부먹왕국의차원관문;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input7964.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 도시 수
			int move = Integer.parseInt(st.nextToken()); // 이동칸

			// 줄간격 없애기
			String str = br.readLine().replace(" ", "");

			StringBuilder sb = new StringBuilder();

			// 이동칸 누적
			for (int i = 0; i < move; i++)
				sb.append('0');

			// replace가 되지 않은 곳은 제외
			String strR = str.replace(sb, "a");

			// replace된 마을을 하나로 보고 세보자.
			int cnt = 0;
			for (int i = 0; i < strR.length(); i++) {
				if (strR.charAt(i) == 'a')
					cnt++;
			}

			System.out.printf("#%d %d\n", TC, cnt);
		}
	}
}
