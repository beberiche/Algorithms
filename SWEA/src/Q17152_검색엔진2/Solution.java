package Q17152_검색엔진2;

import java.util.Scanner;

class Solution
{
	private static final int MAX_LENGTH				= 8;
	private static final int CMD_INIT				= 100;
	private static final int CMD_SEARCH				= 200;
	private static final int CMD_RECOMMEND			= 300;
	private static final int CMD_RELATE				= 400;
	private static final int CMD_RANK				= 500;

	public static final class Result
	{
		int mOrder;
		int mRank;

		Result()
		{
			mOrder = 0;
			mRank = 0;
		}
	}

	private static void String2Char(String s, char[] b, int maxlen)
	{
		int n = s.length();
		for (int i = 0; i < n; ++i)
			b[i] = s.charAt(i);
		for (int i = n; i < maxlen; ++i)
			b[i] = '\0';
	}
	private static int strcmp(char a[], char b[], int n)
	{
		int i = 0;
		while(i < n - 1 && a[i] != 0 && a[i] == b[i]) i++;
		return a[i] - b[i];
	}

	private static UserSolution usersolution = new UserSolution();

	private static boolean run(Scanner sc) throws Exception
	{
		int Q;

		Q = sc.nextInt();

		boolean okay = false;

		for (int q = 0; q < Q; ++q)
		{
			int cmd = sc.nextInt();
			int ret, ans, ans2, mCount, mRank;
			char mStr[] = new char[MAX_LENGTH], mStr2[] = new char[MAX_LENGTH], mReturnStr[] = new char[MAX_LENGTH];
			Result res;

			switch(cmd)
			{
				case CMD_INIT:
					usersolution.init();
					okay = true;
					break;
				case CMD_SEARCH:
					String2Char(sc.next(), mStr, MAX_LENGTH);
					mCount = sc.nextInt();
					usersolution.search(mStr, mCount);
					break;
				case CMD_RECOMMEND:
					String2Char(sc.next(), mStr, MAX_LENGTH);
					res = usersolution.recommend(mStr);
					ans = sc.nextInt();
					ans2 = sc.nextInt();
					if (res.mOrder != ans || res.mRank != ans2)
						okay = false;
					break;
				case CMD_RELATE:
					String2Char(sc.next(), mStr, MAX_LENGTH);
					String2Char(sc.next(), mStr2, MAX_LENGTH);
					ret = usersolution.relate(mStr, mStr2);
					ans = sc.nextInt();
					if (ans != ret)
						okay = false;
					break;
				case CMD_RANK:
					String2Char(sc.next(), mStr, MAX_LENGTH);
					mRank = sc.nextInt();
					usersolution.rank(mStr, mRank, mReturnStr);
					String2Char(sc.next(), mStr2, MAX_LENGTH);
					if (strcmp(mStr2, mReturnStr, MAX_LENGTH) != 0)
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
		 System.setIn(new java.io.FileInputStream("src/Q17152_검색엔진2/sample_input.txt"));

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
