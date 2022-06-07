package Q1836_연속부분합찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int max = -9999999;
		int sum = 0;
		for (int i = 0; i < N; i++) {

			sum += arr[i];
			max = Math.max(sum, max);
			if (sum < 0)
				sum = 0;

		}
		System.out.println(max);
	}
}
