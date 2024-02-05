package Q14707_단어검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private final static int MAX_LEN = 30;
	private final static int CMD_INIT = 1;
	private final static int CMD_ADD = 2;
	private final static int CMD_REMOVE = 3;
	private final static int CMD_SEARCH = 4;

	private final static UserSolution usersolution = new UserSolution();

	private static void String2Char(char[] buf, String str) {
		for (int i = 0; i < str.length(); ++i)
			buf[i] = str.charAt(i);
		buf[str.length()] = '\0';
	}

	private static boolean run(BufferedReader br) throws Exception {
		int q = Integer.parseInt(br.readLine());

		char[] str = new char[MAX_LEN + 1];
		int cmd, ans, ret = 0;
		boolean okay = false;

		for (int i = 0; i < q; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
				case CMD_INIT:
					usersolution.init();
					okay = true;
					break;
				case CMD_ADD:
					String2Char(str, st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					ret = usersolution.add(str);
					if (ret != ans)
						okay = false;
					break;
				case CMD_REMOVE:
					String2Char(str, st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					ret = usersolution.remove(str);
					if (ret != ans)
						okay = false;
					break;
				case CMD_SEARCH:
					String2Char(str, st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					ret = usersolution.search(str);
					if (ret != ans)
						okay = false;
					break;
				default:
					okay = false;
					break;
			}
		}
		return okay;
	}

	public static void main(String[] args) throws Exception {
		int TC, MARK;

		System.setIn(new java.io.FileInputStream("/Users/gimjonghyeon/Desktop/Algorithms/SWEA/src/Q14707_단어검색/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}