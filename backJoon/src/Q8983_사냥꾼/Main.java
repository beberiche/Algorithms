package Q8983_사냥꾼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		List<Integer> hunterPoint = new ArrayList<>();

		String[] tempH = br.readLine().split(" ");
		for (String h : tempH)
			hunterPoint.add(Integer.parseInt(h));

		Collections.sort(hunterPoint);

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int animalR = Integer.parseInt(st.nextToken());
			int animalC = Integer.parseInt(st.nextToken());

			if (animalC > L)
				continue;

			int left = 0;
			int right = N - 1;
			while (left <= right) {
				int mid = (left + right) / 2;

				if (Math.abs(hunterPoint.get(mid) - animalR) + animalC <= L) {
					cnt++;
					break;
				}

				if (hunterPoint.get(mid) > animalR)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		System.out.println(cnt);
	}
}
