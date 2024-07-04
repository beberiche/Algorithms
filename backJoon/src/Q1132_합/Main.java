package Q1132_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class Alphabet implements Comparable<Alphabet> {
	long num = 0;
	boolean first = false;

	@Override
	public int compareTo(Alphabet o) {
		if (this.num > o.num) return 1;
		else if (this.num == o.num) return 0;
		else return -1;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Alphabet[] a = new Alphabet['J' - 'A' + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Alphabet();
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			a[str.charAt(0) - 'A'].num += Math.pow(10, str.length() - 1);
			a[str.charAt(0) - 'A'].first = true;
			for (int j = 1; j < str.length(); j++) {
				a[str.charAt(j) - 'A'].num += Math.pow(10, str.length() - j - 1);
			}
		}

		Arrays.sort(a);

		boolean[] visited = new boolean[10];
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			int st = a[i].first ? 1 : 0;
			for (int j = st; j <= 9; j++) {
				if (!visited[j]) {
					visited[j] = true;
					sum += a[i].num * 1L * j;
					break;
				}
			}
		}
		System.out.println(sum);
	}
}


