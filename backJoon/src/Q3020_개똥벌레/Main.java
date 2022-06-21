package Q3020_개똥벌레;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
//
//		int[] cave = new int[N];
//
//		for (int i = 0; i < N; i++)
//			cave[i] = Integer.parseInt(br.readLine());
//
//		int depth = 0;
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		while (depth < H) {
//			int cnt = 0;
//			for (int i = 0; i < N; i++) {
//				if (i % 2 == 0 && cave[i] > H - depth - 1) 
//					cnt++;
//				if (i % 2 == 1 && cave[i] >= depth + 1) 
//					cnt++;
//			}
//
//			if (map.containsKey(cnt)) 
//				map.put(cnt, map.get(cnt) + 1);
//			else 
//				map.put(cnt, 1);
//			depth++;
//		}
//
//		for (Integer key : map.keySet()) {
//			System.out.println(key + " " + map.get(key));
//			break;
//		}

		int[] 석순 = new int[H + 1];
		int[] 종유석 = new int[H + 1];

		for (int i = 1; i <= N; i++) {
			if (i % 2 == 1)
				석순[Integer.parseInt(br.readLine())]++;
			else
				종유석[Integer.parseInt(br.readLine())]++;
		}

		for (int i = H - 1; i >= 1; i--) {
			석순[i] += 석순[i + 1];
			종유석[i] += 종유석[i + 1];
		}

		int min = 987654321;
		int[] sum = new int[H + 1];
		for (int i = 1; i <= H; i++) {
			min = Math.min(min, 석순[i] + 종유석[H - i + 1]);
			sum[i] = 석순[i] + 종유석[H - i + 1];
		}

		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			if (sum[i] == min)
				cnt++;
		}

		System.out.println(min + " " + cnt);
	}
}
