package Q2960_에라토스테네스의체;

import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[N - 1];

		// 입력
		for (int i = 0; i < N - 1; i++) {
			arr[i] = i + 2;
		}

		System.out.println(solve(arr[0], 0));
	}

	// 배열을 데이터를 제거하는게 불가능하니 지워지는 수는 1001로 바꿔주자.
	// 주어지는 N의 최댓값이 1000 이어서 1001로 잡았다. (그래야 지우지 않은 수 중 가장 작은 수 찾기가 편할테니...)
	public static int solve(int minNum, int cnt) {
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] % minNum == 0) { // 소수의 배수에 해당되는 경우
				if (arr[i] == 1001) { // 선택된 수가 이미 바뀐 수라면 해당 인덱스를 넘어간다.
					continue;
				}
				cnt++; // 지웠다는 카운트를 남기고,
				if (cnt == K) { // 지우기 전 만약 K번째 수라면
					return arr[i]; // 수정 하지 않은 체 그대로 리턴한다.
				}
				arr[i] = 1001; // K번째 수가 아니라면 1001로 수정한다. (지우기)
			}
		}
		if (cnt < K) { // 반복문이 끝났다면, 지금의 소수로는 K번째까지 도달 못했다는 것!
			return solve(findMin(), cnt); // 최소 소수를 찾는 함수와 함께 재귀 실행
		}
		return 0;
	}

	public static int findMin() {
		int min = 1001; // 최솟값도 1001;
		for (int i = 0; i < N - 1; i++) {
			min = Math.min(min, arr[i]); // 주어진 배열을 쭉 돌면서 최솟값을 찾는다.
		}
		return min;// 찾은 소수 최솟값 리턴
	}
}
