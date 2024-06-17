package Q14676_영우는_사기꾼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());


		List<Integer> list[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int[] in = new int[N + 1];
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			list[n1].add(n2);
			in[n2]++;
		}

		int[] cnt = new int[N + 1];
		String SUCCESS = "King-God-Emperor";
		String FAIL = "Lier!";
		boolean check = true;
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			int node = Integer.parseInt(stk.nextToken());

			if (cmd == 1) {
				if (in[node] > 0) {
					check = false;
					break;
				}
				cnt[node]++;
				if (cnt[node] > 1) continue;
				for (int next : list[node]) {
					in[next]--;
				}
			} else {
				if (cnt[node] <= 0) {
					check = false;
					break;
				}
				cnt[node]--;
				if (cnt[node] > 0) continue;
				for (int next : list[node]) {
					in[next]++;
				}
			}
		}

		System.out.println((check ? SUCCESS : FAIL));
	}
}
