package Q9661_돌_게임_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long mod = N % 5;
		System.out.println(mod == 2 || mod == 0 ? "CY" : "SK");
	}
}
