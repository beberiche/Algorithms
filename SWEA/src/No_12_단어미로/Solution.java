package No_12_단어미로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static BufferedReader br;
	private static UserSolution usersolution = new UserSolution();

	private final static int INIT = 0;
	private final static int ADD = 1;
	private final static int SET = 2;
	private final static int MOVE = 3;
	private final static int CHANGE = 4;

	private static final int MAX_LENGTH = 11 + 1;

	private static int dir[] = new int[3];
	private static char mWord[] = new char[MAX_LENGTH];
	private static char mRetWord[] = new char[MAX_LENGTH];

	private static void String2Char(String s, char[] b) {
		int n = s.length();
		for (int i = 0; i < n; ++i)
			b[i] = s.charAt(i);
		for (int i = n; i < MAX_LENGTH; ++i)
			b[i] = '\0';
	}

	private static boolean run() throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int cmd, ans, ret, id;

		int Q = Integer.parseInt(st.nextToken());
		boolean ok = false;

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());

			if (cmd == INIT) {
				usersolution.init();
				ok = true;
			} else if (cmd == ADD) {
				id = Integer.parseInt(st.nextToken());
				String2Char(st.nextToken(), mWord);
				dir[0] = Integer.parseInt(st.nextToken());
				dir[1] = Integer.parseInt(st.nextToken());
				dir[2] = Integer.parseInt(st.nextToken());

				usersolution.addRoom(id, mWord, dir);
			} else if (cmd == SET) {
				String2Char(st.nextToken(), mWord);

				usersolution.setCurrent(mWord);
			}
			else if (cmd == MOVE) {
				dir[0] = Integer.parseInt(st.nextToken());
				ans = Integer.parseInt(st.nextToken());

				ret = usersolution.moveDir(dir[0]);
				if (ret != ans) {
					ok = false;
				}
			}
			else if (cmd == CHANGE) {
				String2Char(st.nextToken(), mWord);
				String2Char(st.nextToken(), mRetWord);
				dir[0] = Integer.parseInt(st.nextToken());
				dir[1] = Integer.parseInt(st.nextToken());
				dir[2] = Integer.parseInt(st.nextToken());
				usersolution.changeWord(mWord, mRetWord, dir);
			}
			else ok = false;
		}
		return ok;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;

		System.setIn(new java.io.FileInputStream("src/No_12_단어미로/sample_input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(stinit.nextToken());
		MARK = Integer.parseInt(stinit.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int score = run() ? MARK : 0;
			System.out.println("#" + tc + " " + score);
		}

		br.close();
	}
}
