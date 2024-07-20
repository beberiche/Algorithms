package Q1789_수들의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());

		long sum = 0;
		long num = 1;
		int cnt = 0;

		while (true) {
			sum += num;
			cnt++;
			if(sum > S) break;

			num++;
		}

		System.out.println(--cnt);
	}
}
