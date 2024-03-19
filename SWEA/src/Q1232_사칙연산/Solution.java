package Q1232_사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine());
			// op용 배열
			String[] op = new String[N + 1];
			// node[][0] = data
			// node[][1] = left
			// node[][2] = right
			int[][] node = new int[N + 1][3];

			// 노드 생성
			for (int i = 1; i <= N; i++) {
				String[] temp = br.readLine().split(" ");
				if ("/*+-".contains(temp[1])) {
					op[i] = temp[1];
					node[i][1] = Integer.parseInt(temp[2]);
					node[i][2] = Integer.parseInt(temp[3]);
				} else {
					node[i][0] = Integer.parseInt(temp[1]);
				}
			}

			// 연산시작
			// 자식을 가지고 있다면 연산자를 가지고 있다.
			// 우선 레프트 라이트가 0이 아닌 값이 있는 지 확인하고
			// 0이 아닌 값이 있다면 해당 인덱스의 data를 가져와
			// 연산과 함께 계산한 후 자신의 data로 가져온다.

			// 뒤에서 부터 시작
			// 아래에서 부터 차곡차곡 연산해서 data를 채운다.
			int idx = N;
			while (idx != 0) {
				// 0이면 그냥 넘어간다.
				if (node[idx][1] != 0) {
					// 소수점 계산해야하니 double
					double ln = node[node[idx][1]][0];
					double rn = node[node[idx][2]][0];

					String oper = op[idx];
					double data = node[idx][0];

					switch (oper) {
						case "+":
							data = ln + rn;
							break;
						case "-":
							data = ln - rn;
							break;
						case "*":
							data = ln * rn;
							break;
						case "/":
							data = ln / rn;
							break;

					}

					node[idx][0] = (int) data;
				}
				idx--;
			}

			System.out.println("#" + T + " " + node[1][0]);
		}
	}
}
