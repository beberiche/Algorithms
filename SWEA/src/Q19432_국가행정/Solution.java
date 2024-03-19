package Q19432_국가행정;

import java.util.Scanner;

class Solution
{
	private static final int CMD_INIT				= 100;
	private static final int CMD_EXPAND				= 200;
	private static final int CMD_CALCULATE			= 300;
	private static final int CMD_DIVIDE				= 400;
	private static final int MAX_N					= 10000;

	private static int[] population = new int[MAX_N];
	private static UserSolution usersolution = new UserSolution();
	private static Scanner sc;

	private static boolean run() throws Exception
	{
		boolean okay = false;
		int Q = sc.nextInt();

		for (int q = 0; q < Q; ++q)
		{
			int ret, ans, N, from, to, num;
			int cmd = sc.nextInt();

			switch(cmd)
			{
				case CMD_INIT:
					N = sc.nextInt();
					for (int i = 0; i < N; i++)
					{
						int in = sc.nextInt();
						population[i] = in;
					}
					usersolution.init(N, population);
					okay = true;
					break;
				case CMD_EXPAND:
					num = sc.nextInt();
					ret = usersolution.expand(num);
					ans = sc.nextInt();
					if (ret != ans)
						okay = false;
					break;
				case CMD_CALCULATE:
					from = sc.nextInt();
					to = sc.nextInt();
					ret = usersolution.calculate(from, to);
					ans = sc.nextInt();
					if (ret != ans)
						okay = false;
					break;
				case CMD_DIVIDE:
					from = sc.nextInt();
					to = sc.nextInt();
					num = sc.nextInt();
					ret = usersolution.divide(from, to, num);
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
		 System.setIn(new java.io.FileInputStream("src/Q19432_국가행정/sample_input.txt"));

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