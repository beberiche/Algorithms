package Q23288_주사위굴리기2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1. 주사위를 이동시킨다.
// 1-1. 해당방향으로 주사위가 이동한다. 
// 1-2. 주사위가 범위를 넘어가는 경우 반대 방향으로 한칸 굴러간다.

// 2. 방향에 맞춰 굴린 주사위를 재정렬한다.

// 3. 점수를 더한다
// 3-1. 주변에 같은 값이 존재한다면 다 더해준다.

// 4. 이동한 곳과 주사위 아래부분을 확인한다.
// 4-1 이동한 곳 > 주사위 아래 => 주사위 시계방향 회전
// 4-2 주사위 아래 > 이동한 곳 => 주사위 반시계방향 회전
// 4-3 주사위 아래 == 이동한 곳 => 회전x

class Dice {
	int front = 1; // 기준 앞면
	int rear = 6; // 기준 뒷면
	int left = 4; // 기준에서 왼쪽
	int right = 3; // 기준에서 오른쪽
	int up = 2; // 기준에서 위에
	int down = 5; // 기준에서 아래
}

public class Main {
	static int currDir, r, c;
	static int[][] map;
	static Dice dice = new Dice();
	// 동, 남, 서, 북
	static final int[] dir = { 0, 1, 2, 3 };
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { 1, 0, -1, 0 };

	static int N, M, K;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		currDir = 0;
		r = 0;
		c = 0;

		for (int i = 0; i < K; i++)
			moveDice(); // 1.주사위를 굴린다.

		System.out.println(ans);
	}

	private static void moveDice() {
		int nr = r + dr[dir[currDir]];
		int nc = c + dc[dir[currDir]]; // 1-1. 해당방향으로 주사위가 이동한다.

		if (nr < 0 || nc < 0 || nr >= N || nc >= M) { // 1-2. 주사위가 범위를 넘어가는 경우 반대 방향으로 한칸 굴러간다.
			currDir = (currDir + 2) % 4;
			nr = r + dr[dir[currDir]];
			nc = c + dc[dir[currDir]];
		}

		r = nr;
		c = nc;
		// 2. 방향에 맞춰 굴린 주사위를 재정렬한다.
		rollDice();

		ans += BFS();

		if (dice.rear > map[nr][nc]) {
			clockWise();
		} else if (dice.rear < map[nr][nc]) {
			antiClockWise();
		}
	}

	private static int BFS() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new int[] { r, c });
		visited[r][c] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (map[nr][nc] != map[r][c])
					continue;

				if (visited[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				cnt++;
			}
		}

		return cnt * map[r][c];
	}

	private static void antiClockWise() {
		currDir = (currDir + 3) % 4;
	}

	private static void clockWise() {
		currDir = (currDir + 1) % 4;
	}

	private static void rollDice() {
		int front = dice.front;
		int rear = dice.rear;
		int left = dice.left;
		int right = dice.right;
		int up = dice.up;
		int down = dice.down;

		switch (currDir) {
		// 동쪽
		case 0: {
			dice.rear = right;
			dice.right = front;
			dice.front = left;
			dice.left = rear;
			break;
		}
		// 남쪽
		case 1: {
			dice.front = up;
			dice.down = front;
			dice.rear = down;
			dice.up = rear;
			break;
		}
		// 서쪽
		case 2: {
			dice.rear = left;
			dice.left = front;
			dice.front = right;
			dice.right = rear;
			break;
		}
		// 북쪽
		case 3: {
			dice.front = down;
			dice.down = rear;
			dice.rear = up;
			dice.up = front;
			break;
		}
		}

	}

}
