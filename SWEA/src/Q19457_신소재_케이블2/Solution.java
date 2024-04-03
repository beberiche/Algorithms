package Q19457_신소재_케이블2;

import java.util.Scanner;

class Solution
{
	private static final int CMD_INIT				= 100;
	private static final int CMD_CONNECT			= 200;
	private static final int CMD_MEASURE			= 300;
	private static final int CMD_TEST				= 400;

	private static UserSolution usersolution = new UserSolution();

	private static boolean run(Scanner sc) throws Exception
	{
		int Q;
		int mDevice, mOldDevice, mNewDevice, mDevice1, mDevice2;
		int mLatency;

		int ret = -1, ans;

		Q = sc.nextInt();

		boolean okay = false;

		for (int q = 0; q < Q; ++q)
		{
			int cmd = sc.nextInt();

			switch(cmd)
			{
				case CMD_INIT:
					mDevice = sc.nextInt();
					usersolution.init(mDevice);
					okay = true;
					break;
				case CMD_CONNECT:
					mOldDevice = sc.nextInt();
					mNewDevice = sc.nextInt();
					mLatency = sc.nextInt();
					usersolution.connect(mOldDevice, mNewDevice, mLatency);
					break;
				case CMD_MEASURE:
					mDevice1 = sc.nextInt();
					mDevice2 = sc.nextInt();
					ret = usersolution.measure(mDevice1, mDevice2);
					ans = sc.nextInt();
					if (ret != ans)
						okay = false;
					break;
				case CMD_TEST:
					mDevice = sc.nextInt();
					ret = usersolution.test(mDevice);
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
		System.setIn(new java.io.FileInputStream("src/Q19457_신소재_케이블2/sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int MARK = sc.nextInt();

		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(sc) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		sc.close();
	}
}