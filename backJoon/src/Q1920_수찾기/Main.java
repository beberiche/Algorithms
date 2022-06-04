package Q1920_수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] arr2;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		N = Integer.parseInt(br.readLine());

		arr2 = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		int idx = N;
		int mid = arr2.length / 2 + 1;
		for (int i = 0; i < N; i++) {
			ans = 0;
			binarySearch(arr2[i]);
			System.out.println(ans);
		}

	}

	public static void binarySearch(int k) {
		int st = 0;
		int ed = arr.length - 1;

		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (k < arr[mid]) {
				ed = mid - 1;
			} else if (k > arr[mid]) {
				st = mid + 1;
			} else {
				ans = 1;
				break;
			}
		}
	}
}
