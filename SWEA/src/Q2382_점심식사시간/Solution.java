package Q2382_점심식사시간;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Person implements Comparable<Person> {
	int r, c;
	int stair;
	int stairTime;

	public Person(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(Person o) {
		return this.stairTime - o.stairTime;
	}

}

class Stair {
	int r, c; // 좌표
	int len; // 계단의 길이

	public Stair(int r, int c, int len) {
		this.r = r;
		this.c = c;
		this.len = len;
	}
}

public class Solution {
	static int N;
	static List<Person> pList;
	static List<Stair> sList;
	static boolean[] visited;
	static int[] sel;
	static int ans;

	public static void main(String[] args) {
		// 1. 계단으로 향하는 모든 경우의 수를 구하자
		// 1-1. 계단이 가까운 곳만 지정해서 간다고 하드라도 그게 전체 시간에서 빠른 것은 아닐 거다.
		// 1-2. 계단 경우의 수 최대 2개 / 사람 수 최대 10명이면 그냥 다 돌려보는게 맞다고 생각했다.
		// 2. 계단으로 향할 때 걸리는 시간을 구한다. (|PR-SR| + |PC-SC|)
		// 3. 계단을 내려갈 때 걸리는 시간을 구한다. (3명 이상 x, 큐로 제한을 주면 될까?)
		// 4. 최소가 되는 값을 찾는다.

		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();

//		for(int t=1; t<=T; t++) {
		N = sc.nextInt();
		ans = 987654321;
		pList = new ArrayList<>();
		sList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = sc.nextInt();
				if (n == 1) {
					pList.add(new Person(i, j));
				} else if (n > 1) {
					sList.add(new Stair(i, j, n));
				}
			}
		}
		sel = new int[pList.size()];
		perm(0);
		System.out.println(ans);
//		}
	}

	public static void perm(int cnt) {
		if (cnt == pList.size()) {
			goToStair();
			int[][] timeTable = new int[2][200];

			PriorityQueue<Person>[] pq = new PriorityQueue[2];
			pq[0] = new PriorityQueue<>();
			pq[1] = new PriorityQueue<>();

			for (int i = 0; i < pList.size(); i++) {
				pq[pList.get(i).stair].add(pList.get(i));
			}
			int tmp = 0;
			// 계단 순서대로 수행해보자.
			for (int i = 0; i < sList.size(); i++) {
				int to = 0; // 해당 사람이 타임테이블에서 끝나는 시간.
				// 각 계단의 큐를 비울때까지 사람들을 내려보내보자.
				while (!pq[i].isEmpty()) {
					Person p = pq[i].poll();
					int from = p.stairTime; // 선택한 계단까지의 거리붙 계단을 내려 가야한다.
					to = from + sList.get(p.stair).len;

					// 타임테이블에 표시
					for (int j = from; j < to; j++) {
						if (timeTable[p.stair][j] == 3) {
							to++;
							continue;
						}
						timeTable[p.stair][j]++;
					}

				}
				if (tmp < to) {
					tmp = to;
				}

			}
			ans = Math.min(ans, tmp);

			return;
		}

		for (int i = 0; i < 2; i++) {
			sel[cnt] = i;
			perm(cnt + 1);
		}
	}

	private static void goToStair() {
		for (int i = 0; i < sel.length; i++) {
			pList.get(i).stair = sel[i];
			pList.get(i).stairTime = arriveStair(pList.get(i));
		}

	}

	private static int arriveStair(Person person) {
		return Math.abs(person.r - sList.get(person.stair).r) + Math.abs(person.c - sList.get(person.stair).c) + 1;
	}

}
