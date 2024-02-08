package Q020437_문자열_게임_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String str;
		int K, min, max;
		List<Integer> list[] = new ArrayList[26];
		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			str = br.readLine();
			K = Integer.parseInt(br.readLine());

			for (int i = 0; i < 26; i++) {
				list[i] = new ArrayList<>();
			}

			min = Integer.MAX_VALUE;
			max = -1;

			for (int i = 0; i < str.length(); i++) {
				list[str.charAt(i) - 'a'].add(i);
			}


			for (int i = 0; i < list.length; i++) {
				if (list[i].size() < K) continue;

				for (int j = 0; j + K - 1 < list[i].size(); j++) {
					min = Math.min(min, list[i].get(j + K - 1) - list[i].get(j) + 1);
					max = Math.max(max, list[i].get(j + K - 1) - list[i].get(j) + 1);
				}
			}
			sb.append(max == -1 ? max : min + " " + max).append("\n");
		}
		System.out.print(sb.toString());
	}
}
