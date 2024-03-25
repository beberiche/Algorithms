package Q13022_조각맞추기게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	private final static int CMD_INIT = 100;
	private final static int CMD_MAKEWALL = 200;
	private final static int CMD_MATCHPIECE = 300;

	private final static int BAR_LEN = 5;

	private static UserSolution usersolution = new UserSolution();

	private static boolean run(BufferedReader br) throws Exception {

		int N;
		int cmd;
		int heights[] = new int[BAR_LEN];
		int ret = 0;
		int ans = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		cmd = Integer.parseInt(st.nextToken());
		boolean okay = false;
		if (cmd == CMD_INIT){
			usersolution.init();
			okay = true;
		}

		for (int turn = 0; turn < N - 1; turn++) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			for (int i = 0; i < BAR_LEN; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			switch (cmd) {
				case CMD_MAKEWALL:
					usersolution.makeWall(heights);
					break;
				case CMD_MATCHPIECE:
					ret = usersolution.matchPiece(heights);
					ans = Integer.parseInt(st.nextToken());
					if (ans != ret)
						okay = false;
					break;
			}
		}
		return okay;
	}

	public static void main(String[] args) throws Exception {

		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");

		int TC = Integer.parseInt(line.nextToken());
		int MARK = Integer.parseInt(line.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}
		br.close();
	}
}
