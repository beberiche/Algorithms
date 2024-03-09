package Q19344_물품보관;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static BufferedReader br;
	private static UserSolution usersolution = new UserSolution();


	private final static int CMD_INIT = 100;
	private final static int CMD_STOCK = 200;
	private final static int CMD_SHIP = 300;
	private final static int CMD_GET_HEIGHT = 400;


	private static boolean run() throws Exception {

		StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");
		int query_num = Integer.parseInt(stdin.nextToken());
		int N, mLoc, mBox, ans;
		boolean ok = false;

		for (int q = 0; q < query_num; q++) {
			stdin = new StringTokenizer(br.readLine(), " ");
			int query = Integer.parseInt(stdin.nextToken());

			if (query == CMD_INIT) {
				N = Integer.parseInt(stdin.nextToken());
				usersolution.init(N);
				ok = true;
			} else if (query == CMD_STOCK) {
				mLoc = Integer.parseInt(stdin.nextToken());
				mBox = Integer.parseInt(stdin.nextToken());
				ans = Integer.parseInt(stdin.nextToken());
				int ret = usersolution.stock(mLoc, mBox);
				if (ret != ans) {
					ok = false;
				}
			} else if (query == CMD_SHIP) {
				mLoc = Integer.parseInt(stdin.nextToken());
				mBox = Integer.parseInt(stdin.nextToken());
				ans = Integer.parseInt(stdin.nextToken());
				int ret = usersolution.ship(mLoc, mBox);
				if (ret != ans) {
					ok = false;
				}
			} else if(query == CMD_GET_HEIGHT) {
				mLoc = Integer.parseInt(stdin.nextToken());
				ans = Integer.parseInt(stdin.nextToken());
				int ret = usersolution.getHeight(mLoc);
				if (ret != ans) {
					ok = false;
				}
			}
		}
		return ok;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;

//		System.setIn(new java.io.FileInputStream(""));
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