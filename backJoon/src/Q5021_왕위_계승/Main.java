package Q5021_왕위_계승;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {

	// 자식 -> 부모
	private static HashMap<String, ArrayList<String>> family;
	private static HashMap<String, Double> blood;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int M = rd.nextInt();

		family = new HashMap<>();
		blood = new HashMap<>();

		String king = rd.next();

		for (int i = 0; i < N; i++) {
			String child = rd.next();
			String p1 = rd.next();
			String p2 = rd.next();

			if (!family.containsKey(child)) family.put(child, new ArrayList<>());

			family.get(child).add(p1);
			family.get(child).add(p2);

			blood.put(child, -1D);
			blood.put(p1, -1D);
			blood.put(p2, -1D);
		}
		blood.put(king, 1D);

		List<String> next_k = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			next_k.add(rd.next());
		}

		for (String key : family.keySet()) {
			dfs(key);
		}


		String ans = null;
		Double score = 0D;
		for (String name : next_k) {
			if (score < blood.getOrDefault(name, 0D)) {
				ans = name;
				score = blood.get(name);
			}
		}

		System.out.println(ans);
	}

	private static double dfs(String name) {
		if (blood.get(name) != -1D) {
			return blood.get(name);
		}

		if (family.get(name) == null) {
			blood.put(name, 0D);
			return blood.get(name);
		}


		double p1 = dfs(family.get(name).get(0));
		double p2 = dfs(family.get(name).get(1));

		double ret = (p1 + p2) / 2;
		blood.put(name, ret);
		return ret;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

/* Solution Description



 */