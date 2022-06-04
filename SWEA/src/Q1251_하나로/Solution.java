package Q1251_하나로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Land {
	public int x, y;
	public long c;

	public Land(int st, int ed, long c) {
		this.x = st;
		this.y = ed;
		this.c = c;
	}

}

public class Solution {
	static ArrayList<Land> map;
	static int[] p;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new ArrayList<>();
			p = new int[N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			String[] tempRow = br.readLine().split(" "); // 섬의 x좌표
			String[] tempColumn = br.readLine().split(" "); // 섬의 y좌표
			double E = Double.parseDouble(br.readLine()); // 환경 세율

			// 비용 설정
			map = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						long costR = Math.abs(Integer.parseInt(tempRow[i]) - Integer.parseInt(tempRow[j]));
						long costC = Math.abs(Integer.parseInt(tempColumn[i]) - Integer.parseInt(tempColumn[j]));
						long cost = costR * costR + costC * costC;
						map.add(new Land(i, j, cost));
					}
				}
			}

			Collections.sort(map, (c1, c2) -> Long.compare(c1.c, c2.c));

			for (int i = 0; i < map.size(); i++) {
				Land land = map.get(i);
				int tempX = findSet(land.x);
				int tempY = findSet(land.y);

				if (tempX == tempY)
					continue;
				p[tempY] = tempX;
				ans += land.c;
			}

			System.out.println("#" + t + " " + Math.round(ans * E));
		}
	}

	private static int findSet(int n) {
		if (n == p[n])
			return n;
		return p[n] = findSet(p[n]);
	}

}
