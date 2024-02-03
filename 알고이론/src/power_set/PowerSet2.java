package power_set;

public class PowerSet2 {

	static boolean[] visited;
	static int[] data;
	static int N;

	public static void main(String[] args) {
		// 재귀호출을을 이용한 powerset 작성해보기
		data = new int[] { 1, 2, 3, 4, 5, 6 };
		N = data.length;
		visited = new boolean[data.length];
		powerSet(0);
	}

	private static void powerSet(int cnt) {
		if (cnt == N - 1) {
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					System.out.print(data[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		visited[cnt] = true;
		powerSet(cnt + 1);
		visited[cnt] = false;
		powerSet(cnt + 1);

	}

}
