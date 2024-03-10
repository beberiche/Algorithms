package Q19339_숫자조각게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static BufferedReader br;
	private static UserSolution usersolution = new UserSolution();

	private final static int MAX_ROW = 40;
	private final static int MAX_COL = 30;

	private static int[][] mCells = new int[MAX_ROW][MAX_COL];
	private static int[][] mPuzzle = new int[3][3];

	private final static int CMD_INIT = 1;
	private final static int CMD_PUT = 2;
	private final static int CMD_CLR = 3;

	static class Result {
		int row;
		int col;

		Result(int r, int c) {
			row = r;
			col = c;
		}
	}

	private static boolean run() throws Exception {

		StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");
		int query_num = Integer.parseInt(stdin.nextToken());
		boolean ok = false;

		for (int q = 0; q < query_num; q++) {
			stdin = new StringTokenizer(br.readLine(), " ");
			int query = Integer.parseInt(stdin.nextToken());

			if (query == CMD_INIT) {
				int mRows = Integer.parseInt(stdin.nextToken());
				int mCols = Integer.parseInt(stdin.nextToken());
				for (int i = 0; i < mRows; i++) {
					stdin = new StringTokenizer(br.readLine(), " ");
					for (int j = 0; j < mCols; j++) {
						mCells[i][j] = Integer.parseInt(stdin.nextToken());
					}
				}
				usersolution.init(mRows, mCols, mCells);
				ok = true;
			} else if (query == CMD_PUT) {
				char strPuzzle[] = stdin.nextToken().toCharArray();
				int cnt = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mPuzzle[i][j] = strPuzzle[cnt] - '0';
						cnt++;
					}
				}
				int ans_row = Integer.parseInt(stdin.nextToken());
				int ans_col = Integer.parseInt(stdin.nextToken());
				Result ret = usersolution.putPuzzle(mPuzzle);
				if (ans_row != ret.row || ans_col != ret.col) {
					ok = false;
				}
			} else if (query == CMD_CLR) {
				usersolution.clearPuzzles();
			}
		}
		return ok;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;

		System.setIn(new java.io.FileInputStream("src/Q19339_숫자조각게임/sample_input.txt"));
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