package Q2550_전구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int a[] = new int[N + 1];
		int b[][] = new int[N + 1][2];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int idx = Integer.parseInt(stk.nextToken());
			b[idx][0] = i;
			b[idx][1] = idx;
		}

		List<int[]> list = new ArrayList<>();
		list.add(b[a[1]]);
		List<int[]> t = new ArrayList<>();
		t.add(new int[]{list.size(), b[a[1]][1]});
		for (int i = 2; i <= N; i++) {
			int[] curr = b[a[i]];
			if (list.get(list.size() - 1)[0] < curr[0]) {
				list.add(curr);
				t.add(new int[]{list.size(), curr[1]});
				continue;
			}

			int idx = search(list, b[a[i]][0]);
			list.set(idx, curr);
			t.add(new int[]{idx + 1, curr[1]});
		}

		List<Integer> ans = new ArrayList<>();
		int len = list.size();
		for (int i = t.size() - 1; i >= 0; i--) {
			if (t.get(i)[0] != len) continue;
			ans.add(t.get(i)[1]);
			len--;
		}
		Collections.sort(ans);

		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		for (int n : ans) {
			sb.append(n).append(" ");
		}
		System.out.print(sb.toString());
	}

	private static int search(List<int[]> list, int num) {
		int l = 0;
		int r = list.size();

		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid)[0] > num) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}
}
