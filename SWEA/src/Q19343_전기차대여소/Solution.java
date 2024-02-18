package Q19343_전기차대여소;

import java.util.Scanner;

class Solution
{
	private static final int CMD_INIT				= 0;
	private static final int CMD_ADD				= 1;
	private static final int CMD_DISTANCE			= 2;
	private static final int MAX_N					= 350;

	private static int[][] region = new int[MAX_N][MAX_N];
	private static UserSolution usersolution = new UserSolution();
	private static Scanner sc;

	private static boolean run() throws Exception
	{
		int Q = sc.nextInt();

		boolean okay = false;

		for (int q = 0; q < Q; ++q)
		{
			int cmd = sc.nextInt();
			int ret, ans, N, range, id, r, c, id2;

			switch(cmd)
			{
				case CMD_INIT:
					N = sc.nextInt();
					range = sc.nextInt();
					for (int i = 0; i < N; i++)
					{
						for (int j = 0; j < N; j++)
						{
							int in = sc.nextInt();
							region[i][j] = in;
						}
					}
					usersolution.init(N, range, region);
					okay = true;
					break;
				case CMD_ADD:
					id = sc.nextInt();
					r = sc.nextInt();
					c = sc.nextInt();

					usersolution.add(id, r, c);
					break;
				case CMD_DISTANCE:
					id = sc.nextInt();
					id2 = sc.nextInt();
					ret = usersolution.distance(id, id2);
					ans = sc.nextInt();
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

	public static void main(String[] args) throws Exception
	{
		 System.setIn(new java.io.FileInputStream("src/Q19343_전기차대여소/sample_input.txt"));

		sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int MARK = sc.nextInt();

		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run() ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		sc.close();
	}
}