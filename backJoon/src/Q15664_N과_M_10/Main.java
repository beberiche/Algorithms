package Q15664_N과_M_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int a[], b[];
	private static boolean visited[];
	private static List<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		a = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		b = new int[M];
		Arrays.sort(a);
		visited = new boolean[N];
		list = new ArrayList<>();
		perm(0);
		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int[] a : list) {
			for(int num : a) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void perm(int d) {
		if (d >= b.length) {
			if(!checkDupl()) list.add(Arrays.copyOf(b, b.length));
			return;
		}

		for (int i = 0; i < a.length; i++) {
			if (visited[i]) continue;

			if (d == 0 || (d > 0 && b[d - 1] <= a[i])) {
				visited[i] = true;
				b[d] = a[i];
				perm(d + 1);
				visited[i] = false;
			}
		}
	}

	private static boolean checkDupl() {
		for(int[] arr : list) {
			boolean flag = true;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != b[i]) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}
		return false;
	}
}
