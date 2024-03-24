package Q17148_출근길_라디오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	private static UserSolution usersolution = new UserSolution();
	static final int CMD_INIT = 100;
	static final int CMD_DESTROY = 200;
	static final int CMD_UPDATE = 300;
	static final int CMD_UPDATE_TYPE = 400;
	static final int CMD_CALC = 500;
	static final int MAX_N = 100000;
	static int[] mType = new int [MAX_N];
	static int[] mTime = new int [MAX_N];

	private static boolean run(BufferedReader br) throws IOException  {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boolean isOK = false;
		int C = new Scanner(st.nextToken()).nextInt();
		int cmd, result, check;
		int N, M;
		int mID, mTypeID, mNewTime, mRatio256;
		int mA, mB;
		for (int c = 0; c < C; ++c) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			switch (cmd)
			{
				case CMD_INIT:
					N = new Scanner(st.nextToken()).nextInt();
					M = new Scanner(st.nextToken()).nextInt();
					for (int i = 0; i < N - 1; i++) mType[i] = Integer.parseInt(st.nextToken());
					for (int i = 0; i < N - 1; i++) mTime[i] = Integer.parseInt(st.nextToken());
					usersolution.init(N, M, mType, mTime);
					isOK = true;
					break;
				case CMD_UPDATE:
					mID = Integer.parseInt(st.nextToken());
					mNewTime = Integer.parseInt(st.nextToken());
					usersolution.update(mID, mNewTime);
					break;
				case CMD_UPDATE_TYPE:
					mTypeID = new Scanner(st.nextToken()).nextInt();
					mRatio256 = new Scanner(st.nextToken()).nextInt();
					result = usersolution.updateByType(mTypeID, mRatio256);
					check = new Scanner(st.nextToken()).nextInt();
					if (result != check)
						isOK = false;
					break;
				case CMD_CALC:
					mA = Integer.parseInt(st.nextToken());
					mB = Integer.parseInt(st.nextToken());
					result = usersolution.calculate(mA, mB);
					check = Integer.parseInt(st.nextToken());
					if (result != check)
						isOK = false;
					break;
				default:
					isOK = false;
					break;
			}
		}
		usersolution.destroy();
		return isOK;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("src/Q17148_출근길_라디오/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int TC = Integer.parseInt(line.nextToken());
		int MARK = Integer.parseInt(line.nextToken());
		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}
		br.close();
	}
}