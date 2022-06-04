package Q13023_ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new ArrayList<>());
			list.get(i).add(Integer.parseInt(st.nextToken()));
			list.get(i).add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (i == j)
					continue;
				int a = list.get(i).get(0);
				int b = list.get(i).get(1);
				int c = list.get(j).get(0);
				int d = list.get(j).get(1);
				if (a == b || a == c || a == d || b == c || b == d || c == d) {
					continue;
				}

				for (int l = 0; l < M; l++) {
					for (int k = 0; k < 2; k++) {
						int e = list.get(l).get(k);
						if (a == e || b == e || c == e || d == e) {
							continue;
						}
					}
					System.out.println(1);
					return;
				}

			}

		}
		System.out.println(0);
	}
}