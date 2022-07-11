package 단체사진찍기;

class Solution {
	static int ans;
	static final char[] data = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static char[] sel;
	static boolean[] visited;
	static int answer;

	public int solution(int n, String[] checkData) {
		answer = 0;
		sel = new char[8];
		visited = new boolean[8];
		perm(0, n, checkData);
		return answer;
	}

	private static void perm(int idx, int n, String[] checkData) {
		if (idx == 8) {
			boolean check = true;
			// 점검
			for (int i = 0; i < n; i++) {
				String temp = checkData[i];
				int comp1Idx = 0;
				int comp2Idx = 0;
				for (int j = 0; j < 8; j++) {
					if (temp.charAt(0) == sel[j]) {
						comp1Idx = j;
					} else if (temp.charAt(2) == sel[j]) {
						comp2Idx = j;
					}
				}

				char compare = temp.charAt(3);
				int num = temp.charAt(4) - '0';

				if (compare == '<' && Math.abs(comp1Idx - comp2Idx) - 1 >= num) {
					check = false;
					break;
				}

				if (compare == '>' && Math.abs(comp1Idx - comp2Idx) - 1 <= num) {
					check = false;
					break;
				}

				if (compare == '=' && Math.abs(comp1Idx - comp2Idx) - 1 != num) {
					check = false;
					break;
				}

			}
			if (check)
				answer++;
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (visited[i])
				continue;
			sel[idx] = data[i];
			visited[i] = true;
			perm(idx + 1, n, checkData);
			visited[i] = false;
		}
	}

}