package Q17696_블록_쌓기_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static BufferedReader br;
	private static UserSolution usersolution = new UserSolution();

	private final static int CMD_INIT = 100;
	private final static int CMD_DROP = 200;


	public static final class Result{
		int top;
		int count;

		Result(){
			top = 0;
			count = 0;
		}
	}

	private static boolean run() throws Exception {

		StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");

		int query_num = Integer.parseInt(stdin.nextToken());
		int ans_top, ans_count;
		boolean ok = false;

		for (int q = 0; q < query_num; q++) {
			stdin = new StringTokenizer(br.readLine(), " ");
			int query = Integer.parseInt(stdin.nextToken());

			if (query == CMD_INIT) {
				int C = Integer.parseInt(stdin.nextToken());
				usersolution.init(C);
				ok = true;
			} else if (query == CMD_DROP) {
				int mCol = Integer.parseInt(stdin.nextToken());
				int mHeight = Integer.parseInt(stdin.nextToken());
				int mLength = Integer.parseInt(stdin.nextToken());

				Result ret = usersolution.dropBlocks(mCol, mHeight, mLength);
				ans_top = Integer.parseInt(stdin.nextToken());
				ans_count = Integer.parseInt(stdin.nextToken());

				if (ans_top != ret.top || ans_count != ret.count) {
					ok = false;
				}
			}
		}
		return ok;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;

		 System.setIn(new java.io.FileInputStream("src/Q17696_블록_쌓기_게임/sample_input.txt"));
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