package Q19203_문자열_관리_프로그램;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	private final static int CMD_INIT		= 1;
	private final static int CMD_APPEND		= 2;
	private final static int CMD_CUT		= 3;
	private final static int CMD_REVERSE	= 4;
	private final static int CMD_COUNT		= 5;

	private final static UserSolution usersolution = new UserSolution();

	private static void String2Char(char[] buf, String str) {
		for (int k = 0; k < str.length(); ++k)
			buf[k] = str.charAt(k);
		buf[str.length()] = '\0';
	}

	private static char[] mStr = new char[30001];
	private static char[] mWord = new char[5];

	private static boolean run(BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int queryCnt = Integer.parseInt(st.nextToken());
		boolean correct = false;

		for (int q = 0; q < queryCnt; q++)
		{
			st = new StringTokenizer(br.readLine(), " ");

			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == CMD_INIT)
			{
				String2Char(mStr, st.nextToken());
				usersolution.init(mStr);
				correct = true;
			}
			else if (cmd == CMD_APPEND)
			{
				String2Char(mWord, st.nextToken());

				if (correct)
				{
					usersolution.appendWord(mWord);
				}
			}
			else if (cmd == CMD_CUT)
			{
				int k = Integer.parseInt(st.nextToken());

				if (correct)
				{
					usersolution.cut(k);
				}
			}
			else if (cmd == CMD_REVERSE)
			{
				if (correct)
				{
					usersolution.reverse();
				}
			}
			else if (cmd == CMD_COUNT)
			{
				String2Char(mWord, st.nextToken());

				int ret = -1;
				if (correct)
				{
					ret = usersolution.countOccurrence(mWord);
				}

				int ans = Integer.parseInt(st.nextToken());
				if (ret != ans)
				{
					correct = false;
				}
			}
		}
		return correct;
	}

	public static void main(String[] args) throws Exception
	{
		int TC, MARK;

//		System.setIn(new java.io.FileInputStream("./src/Q19203_문자열_관리_프로그램/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;

			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}