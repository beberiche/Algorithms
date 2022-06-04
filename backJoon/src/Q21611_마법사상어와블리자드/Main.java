package Q21611_마법사상어와블리자드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 1. 상어는 마법을 쓴다.
// 1-1. 상어의 마법은 방향과 범위가 주어진다.
// 1-2. 상어의 마법을 맞은 구슬은 파괴된다.
// 2. 구슬은 이동과 폭발을 반복한다.
// 2-1. 구슬은 달팽이 처럼 반시계 방향으로 이동한다.
// 2-2. 구슬은 인접한 구슬이 4개 이상 일 때만 연쇄폭발을 일으킨다.
// 2-3. 구슬은 연쇄폭발을 일으킬때만 점수를 획득합니다.
// 3. 파괴후 남은 구슬이 변화한다.
// 3-1 동일한 구슬끼리 구슬 그룹으로 나눈다.
// 3-2 구슬 그룹은 구슬 A 구슬 B의 형태로 변화한다.
// 3-3 구슬 A = 구슬 그룹의 개수, 구슬 B = 구슬의 번호

public class Main {
	static int[][] map;
	static int[][] blizard;
	static List<Integer> biz;
	static int[] score;
	static int shark;
	// 마법 방향
	static final int[] dr = { 0, -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, 0, -1, 1 };

	// 달팽이 방향
	static final int[] acwR = { 0, 1, 0, -1 };
	static final int[] acwC = { -1, 0, 1, 0 };
	static int N, M;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 맵의 사이즈
		M = sc.nextInt(); // 마법 횟수
		map = new int[N][N];
		score = new int[4]; // biz 스코어용 배열
		shark = N / 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		blizard = new int[M][];
		for (int i = 0; i < M; i++) {
			biz = new ArrayList<>();
			blizard[i] = new int[] { sc.nextInt(), sc.nextInt() };
			bizMagic(blizard[i][0], blizard[i][1]);
			bizMove();
			bizBomb();
			bizChange();
		}

		totalScore();
	}

	// 마법!
	private static void bizMagic(int d, int s) {
		int idx = 1;
		while (true) {
			if (idx > s)
				break;

			int nr = shark + dr[d] * idx;
			int nc = shark + dc[d] * idx;

			map[nr][nc] = 0;
			idx++;
		}

	}

	// 마법 후 구슬 이동
	private static void bizMove() {
		Queue<Integer> q = new LinkedList<>();
		int dir = 0;
		int dist = 1;

		int r = shark;
		int c = shark;

		outer: while (true) {
			for (int d = 0; d < 2; d++) {
				for (int m = 0; m < dist; m++) {
					r += acwR[dir];
					c += acwC[dir];
					q.add(map[r][c]);
					if (r == 0 && c == 0) {
						break outer;
					}
				}
				dir = (dir + 1) % 4;
			}
			dist++;
		}

		while (!q.isEmpty()) {

			if (q.peek() != 0) {
				biz.add(q.poll());
			} else {
				q.poll();
			}
		}

	}

	// 연쇄 폭발
	private static void bizBomb() {
		// TODO Auto-generated method stub
		while (true) {
			int size = biz.size();
			int cnt = 1;
			boolean flag = false;
			for (int i = 1; i < size; i++) {
				if (biz.get(i) != 0) {
					if (biz.get(i - 1) == biz.get(i)) {
						cnt++;
					} else {
						if (cnt >= 4) {
							flag = true;
							// 폭발 시킨 비즈 점수 넣기
							for (int r = i - 1; r >= i - cnt; r--) {
								score[biz.get(r)] += biz.get(r);
								biz.set(r, 0);
							}
						}
						cnt = 1;
					}
				}
			}
			if (cnt >= 4) {
				for (int r = size - 1; r >= size - cnt; r--) {
					score[biz.get(r)] += biz.get(r);
					biz.set(r, 0);
				}
			}

			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int n = biz.get(i);
				if (n != 0) {
					temp.add(n);
				}
			}

			biz = temp;

			if (!flag)
				break;
		}

		// 예외*
		// 더이상 구슬이 없는 경우하기
		// 구슬이 없다면 비즈 리스트가 텅 비어있을 것이다.
		// 그동안 점수 모아서 그냥 끝
		if (biz.isEmpty()) {
			totalScore();
			System.exit(0);
		}
		// 3 1
		// 1 0 1
		// 1 0 1
		// 1 1 1
		// 2 1
//		System.out.println(biz);
//		System.out.println(Arrays.toString(score));
	}

	// 비즈 그룹나누기
	private static void bizChange() {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 1;
		for (int i = 1; i < biz.size(); i++) {
			if (biz.get(i - 1) == biz.get(i)) {
				cnt++;
			} else {
				q.add(cnt);
				q.add(biz.get(i - 1));
				cnt = 1;
			}
		}
		q.add(cnt);
		q.add(biz.get(biz.size() - 1));

//		System.out.println(q);

		// map으로 다시 바꾸기.
		int[][] tempMap = new int[N][N];

		int dir = 0;
		int dist = 1;

		int r = shark;
		int c = shark;

		outer: while (true) {
			for (int d = 0; d < 2; d++) {
				for (int m = 0; m < dist; m++) {
					r += acwR[dir];
					c += acwC[dir];
					// 더이상 가져올 구슬이 없으면 남은 곳으로 0으로 놔두고 끝
					// 가져올 구슬이 map보다 더 큰 경우에 map 사이즈 만큼만 가져오고 끝
					if (q.isEmpty() || c < 0) {
						break outer;
					}
					tempMap[r][c] = q.poll();
				}
				dir = (dir + 1) % 4;
			}
			dist++;
		}
		map = tempMap;
	}

	public static void totalScore() {
		for (int i = 0; i < 4; i++) {
			ans += score[i];
		}
		System.out.println(ans);
	}
}