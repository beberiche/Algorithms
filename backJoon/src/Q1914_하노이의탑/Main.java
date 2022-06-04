package Q1914_하노이의탑;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	static BigInteger cnt2 = new BigInteger("1");

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();

		if (N == 1) {
			System.out.println(1);
			System.out.println(1 + " " + 3);
		}
		if (N <= 20) {
			hanoi(N, 1, 3, 2);
			System.out.println(cnt);
			bw.write(sb.toString());
			bw.flush();
		} else {
			while (--N >= 0)
				cnt2 = cnt2.multiply(new BigInteger("2"));
			cnt2 = cnt2.subtract(new BigInteger("1"));
			bw.write(cnt2.toString());
			bw.flush();
		}

	}

	private static void hanoi(int N, int from, int to, int temp) {
		if (N == 0) {
			return;
		}
		cnt++;
		hanoi(N - 1, from, temp, to);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(N - 1, temp, to, from);
	}
}
