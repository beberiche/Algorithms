package Q9421_소수상근수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isPrime = sieveOfEratosthenes(N);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			if (isPrime[i] && checkSanggeun(i)) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static boolean checkSanggeun(int number) {
		boolean[] visited = new boolean[500];
		while (number != 1) {
			number = sumOfSquaresOfDigits(number);
			if (visited[number]) break;
			visited[number] = true;
		}
		return number == 1;
	}

	private static int sumOfSquaresOfDigits(int number) {
		int sum = 0;
		while (number > 0) {
			int digit = number % 10;
			sum += digit * digit;
			number /= 10;
		}
		return sum;
	}

	private static boolean[] sieveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		return isPrime;
	}
}
