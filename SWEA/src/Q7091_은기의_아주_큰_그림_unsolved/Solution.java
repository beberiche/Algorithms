package Q7091_은기의_아주_큰_그림_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static HashMap<String, Integer> hashMap;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(stk.nextToken());
			int W = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());

			String cmp = "";
			for (int i = 0; i < H; i++) {
				cmp += br.readLine();
			}

			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			hashMap = new HashMap<>();
			for (int i = 0; i <= N - H; i++) {
				for (int j = 0; j <= M - W; j++) {
//                    String str = "";
					StringBuilder sb = new StringBuilder();
					for (int k = i; k < H + i; k++) {
						for (int l = j; l < W + j; l++) {
							sb.append(map[k][l]);
//                            str+=map[k][l];
						}
					}
					String str = sb.toString();
					hashMap.put(str, hashMap.getOrDefault(str,0)+1);
				}
			}

			System.out.printf("#%d %d\n", t, hashMap.getOrDefault(cmp,0));
		}
	}
}
