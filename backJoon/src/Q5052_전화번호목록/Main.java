package Q5052_전화번호목록;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			List<String> textList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				textList.add(br.readLine());
			}

			Collections.sort(textList);

//			System.out.println(textList);
			boolean flag = true;
			for (int i = 0; i < N - 1; i++) {
				int currLen = textList.get(i).length();

				if (currLen < textList.get(i + 1).length()) {
					if (prefix(textList.get(i + 1), currLen).equals(textList.get(i))) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static String prefix(String text, int len) {
		return text.substring(0, len);
	}
}
