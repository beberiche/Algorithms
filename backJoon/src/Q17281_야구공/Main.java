package Q17281_야구공;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] score;
	static int[] sel;
	static int max, N;
	static boolean[] visited;
	static final int[] team = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		score = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[team.length];
		sel = new int[team.length];
		perm(0);
		System.out.println(max);
	}

	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if (idx == 9)
			playBall();
	
		for (int i = 0; i < team.length; i++) {
			if (visited[i])
				continue;
			sel[idx] = team[i];
			if(idx>=3 && sel[3] != 0) 
				return;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	private static void playBall() {
		int turn = 0;
		int total = 0;
		for (int i = 0; i < N; i++) {
			int outCnt = 0;
			Stack<Integer> stack = new Stack<>();
			while (outCnt < 3) {
				int result = score[i][sel[turn++%9]];
				if (result == 0) {
					outCnt++;
					continue;	
				}
				stack.add(result);
			}
			int sum = 0;
			int idx = stack.size();
			while(!stack.isEmpty())	{
				sum += stack.pop();
				if (sum >= 4) {
					total += idx;
					break;
				}
				idx--;
			}
		}
		max = Math.max(max, total);
	}
}
