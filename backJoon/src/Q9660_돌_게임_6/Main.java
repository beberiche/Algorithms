package Q9660_돌_게임_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		boolean check = (N%7 == 2 || N%7 == 0) ? true : false;
		System.out.println(check ? "CY" : "SK");
	}
}
