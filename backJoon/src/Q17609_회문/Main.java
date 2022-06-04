package Q17609_회문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력
		int N = Integer.parseInt(br.readLine());

		StringBuilder ans = new StringBuilder();
		// 지금 문자가 회문인지 아닌지 확인
		outer: for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String strRe = new StringBuilder(str).reverse().toString();

			if (str.equals(strRe)) {
				ans.append(0).append("\n");
				continue outer;
			}

			int diff = 0;
			// 하나 지우는 걸로 회문이 될 수 있는지 확인
			// 1. 글자가 안 맞는 곳을 우선 찾자
			// 2. 가장 먼저 확인되는 그곳을 지우자.
			// 3. 뒤집었을 때 맞는 지 확인해보자.
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) != strRe.charAt(j)) {
					diff = j;
					break;
				}
			}

			// xabba : abbax 는 diff가 1이 나오니까 앞의 문장을 지우면 회문이 된다.
			// summuus : suummus 는 diff가 2가 나오니까 뒤위 문장을 지우면 회문이 된다.
			// 이처럼 주어지는 텍스트마다 어떤 문장을 수정하냐에 따라 회문이 되기도 안되기도 하기 때문에
			// 꼭꼭 둘다 확인해주자.
			StringBuilder sb = new StringBuilder(str);
			StringBuilder sb2 = new StringBuilder(str).reverse();
			sb.deleteCharAt(diff);
			sb2.deleteCharAt(diff);

			// 둘중 하나라도 맞는 경우가 있다면 회문이 될 수 있다.
			// 둘다 아니라면 1개의 수정으로는 회문이 될 수 없는 경우이다.
			if (sb.toString().equals(sb.reverse().toString()) || sb2.toString().equals(sb2.reverse().toString())) {
				ans.append(1).append("\n");
				continue outer;
			}

			ans.append(2).append("\n");
		}
		bw.write(ans.toString());
		bw.flush();
	}
}
