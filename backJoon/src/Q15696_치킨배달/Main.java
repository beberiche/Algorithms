package Q15696_치킨배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
	int r;
	int c;

	Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int minDist = Integer.MAX_VALUE; // 치킨 거리
	static int T; // 현재 치킨집 수
	static int R; // 살아남아야 하는 치킨집 수
	static List<Pos> home = new ArrayList<>();
	static List<Pos> chicken = new ArrayList<>();
	static Pos[] sel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시 크기
		R = Integer.parseInt(st.nextToken());
		sel = new Pos[R];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 2) {
					chicken.add(new Pos(i, j));
					T++;
				}
				if (n == 1)
					home.add(new Pos(i, j));
			}
		}
		comb(0, 0);
		System.out.println(minDist);
	}

	public static void comb(int cnt, int idx) {
		if (cnt == R) {
			findMinDist();
			return;
		}

		if (idx == T)
			return;

		sel[cnt] = chicken.get(idx);
		comb(cnt + 1, idx + 1);
		comb(cnt, idx + 1);

	}

	public static int absDist(int r1, int r2, int c1, int c2) {
		int dist = Math.abs(r1 - r2) + Math.abs(c1 - c2);
		return dist;
	}

	public static void findMinDist() {
		int total = 0;
		for (int i = 0; i < home.size(); i++) {
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < sel.length; j++) {
				int temp = 0;
				temp += absDist(home.get(i).r, sel[j].r, home.get(i).c, sel[j].c);
				dist = Math.min(dist, temp);
			}
			total += dist;
		}
		minDist = Math.min(minDist, total);
	}

}
