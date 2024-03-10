package Q17297_Messi_Gimossi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String MESSI = "Messi";
	private static final String MESSI_GIMMOSSI = "Messi Gimossi";
	private static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		list.add(MESSI.length());
		list.add(MESSI_GIMMOSSI.length());
		if (M <= list.get(1)) {
			char ret = MESSI_GIMMOSSI.charAt(M - 1);
			if (ret == ' ') System.out.println(MESSI + " " + MESSI_GIMMOSSI);
			else System.out.println(ret);
			return;
		}

		while (true) {
			int size = list.get(list.size() - 1) + list.get(list.size() - 2) + 1;
			list.add(size);
			if (size >= M) break;
		}

		String ans = go(list.size() - 1, M);
		System.out.println(ans);
	}

	private static String go(int idx, int cnt) {
		if (idx == 0) {
			return MESSI.charAt(cnt - 1) + "";
		}
		if (idx == 1) {
			return MESSI_GIMMOSSI.charAt(cnt - 1) + "";
		}

		// left -> list.get(N-1)
		int l_st = 1;
		int l_ed = list.get(idx - 1);

		int space = l_ed + 1;

		// right -> list.get(N-2)
		int r_st = l_ed + 2;
		int r_ed = list.get(idx);

		if (space == cnt) {
			return MESSI + " " + MESSI_GIMMOSSI;
		}

		if (l_st <= cnt && cnt <= l_ed) {
			return go(idx - 1, cnt - l_st + 1);
		} else if (r_st <= cnt && cnt <= r_ed) {
			return go(idx - 2, cnt - r_st + 1);
		}

		return "NONE";
	}
}
