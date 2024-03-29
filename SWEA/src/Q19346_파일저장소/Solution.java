package Q19346_파일저장소;

import java.util.Scanner;

class Solution {
	private final static int CMD_INIT = 1;
	private final static int CMD_ADD = 2;
	private final static int CMD_REMOVE = 3;
	private final static int CMD_COUNT = 4;

	private final static UserSolution usersolution = new UserSolution();

	private static boolean run(Scanner sc) {
		int q = sc.nextInt();

		int mid, msize, mstart, mend, n;
		int cmd, ans, ret = 0;
		boolean okay = false;

		for (int i = 0; i < q; ++i) {
			cmd = sc.nextInt();
			switch (cmd) {
				case CMD_INIT:
					n = sc.nextInt();
					usersolution.init(n);
					okay = true;
					break;
				case CMD_ADD:
					mid = sc.nextInt();
					msize = sc.nextInt();
					ans = sc.nextInt();
					ret = usersolution.add(mid, msize);
					if (ret != ans)
						okay = false;
					break;
				case CMD_REMOVE:
					mid = sc.nextInt();
					ans = sc.nextInt();
					ret = usersolution.remove(mid);
					if (ret != ans)
						okay = false;
					break;
				case CMD_COUNT:
					mstart = sc.nextInt();
					mend = sc.nextInt();
					ans = sc.nextInt();
					ret = usersolution.count(mstart, mend);
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

		System.setIn(new java.io.FileInputStream("src/Q19346_파일저장소/sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		TC = sc.nextInt();
		MARK = sc.nextInt();

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(sc) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		sc.close();
	}
}
