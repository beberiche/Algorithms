package Q1647_도시분할계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int maxC = 0;
		List<Integer> list = new ArrayList<>();
		map = new int[M + 1][3];
		p = new int[N + 1];
		for (int i = 1; i <= N; i++)
			p[i] = i;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // 시작값
			map[i][1] = Integer.parseInt(st.nextToken()); // 끝값
			map[i][2] = Integer.parseInt(st.nextToken()); // 길의 유지비
		}

		// 정렬
		Arrays.sort(map, (o1, o2) -> o1[2] - o2[2]);

		// 해당 열의 대표값을 찾는다
		// 대표가 같다면 다음 단계로 넘긴다.
		// 대표가 다르다면 첫번째 매개변수가 두번째 매개변수의 대표자가 된다.
		for (int i = 1; i <= M; i++) {
			int px = findSet(map[i][0]);
			int py = findSet(map[i][1]);

			if (px == py)
				continue;
			// Union
			p[py] = px;
			list.add(map[i][2]);
			maxC = Math.max(maxC, map[i][2]);
		}

		// 두개의 마을은 분리되어 있기 때문에
		// 총 N-2개의 간선이 필요하다.
		// 그렇다면 N-1개의 신장트리에서 가운데 가장 큰 유지비를 뺴면
		// 그게 N-2의 신장트리일거다.
		int ans = 0;
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++) {
			ans += list.get(i);
		}
		System.out.println(ans);

	}

	private static int findSet(int i) {
		if (p[i] == i)
			return i;
		return p[i] = findSet(p[i]);
	}

}
