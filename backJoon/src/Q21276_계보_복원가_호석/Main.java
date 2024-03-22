package Q21276_계보_복원가_호석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N;
	private HashMap<String, Integer> name_idx;
	private int[] child_cnt;
	private List<String> child_list[];
	private String[] names;
	private StringBuilder sb = new StringBuilder();
	private TreeMap<String, TreeSet<String>> child_ret;
	private TreeSet<String> parent_s;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		for (String s : child_ret.keySet()) {
			TreeSet<String> curr = child_ret.get(s);
			sb.append(s).append(" ").append(curr.size()).append(" ");
			for (String ss : curr) {
				sb.append(ss).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		Queue<String> q = new LinkedList<>();

		sb.append(parent_s.size()).append("\n");
		while (!parent_s.isEmpty()) {
			String p = parent_s.pollFirst();
			sb.append(p).append(" ");
			q.add(p);
		}
		sb.append("\n");

		while (!q.isEmpty()) {
			String curr = q.poll();
			int idx = name_idx.get(curr);
			for (String child : child_list[idx]) {
				int child_idx = name_idx.get(child);
				child_cnt[child_idx]--;

				if (child_cnt[child_idx] == 0) {
					child_ret.get(curr).add(child);
					q.add(child);
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine());
		name_idx = new HashMap<>();
		child_list = new ArrayList[N];
		names = new String[N];
		child_ret = new TreeMap<>();
		parent_s = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			String name = stk.nextToken();
			name_idx.put(name, i);
			child_ret.put(name, new TreeSet<>());
			child_list[i] = new ArrayList<>();
			names[i] = name;
			parent_s.add(name);
		}

		child_cnt = new int[N];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			String child = stk.nextToken();
			String parent = stk.nextToken();

			int p_idx = name_idx.get(parent);
			int c_idx = name_idx.get(child);
			child_list[p_idx].add(child);
			child_cnt[c_idx]++;

			if (parent_s.contains(child)) parent_s.remove(child);
		}
	}
}
