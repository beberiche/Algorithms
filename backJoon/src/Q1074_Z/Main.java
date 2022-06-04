package Q1074_Z;

import java.util.Scanner;

public class Main {
	static int map[][];
	static int r;
	static int c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = (int) Math.pow(2, sc.nextInt());
		r = sc.nextInt();
		c = sc.nextInt();

		if (size == 1) {
			System.out.println(0);
			System.exit(0);
		}

		System.out.println(recur(0, 0, size, 0));
	}

	public static int recur(int currR, int currC, int size, int cnt) {
		if (currR == r && currC == c) {
			return cnt;
		}

		size /= 2;

		if (r < currR + size && c < currC + size) {
			return recur(currR, currC, size, cnt);
		} else if (r < currR + size) {
			return recur(currR, currC + size, size, cnt + size * size);
		} else if (c < currC + size) {
			return recur(currR + size, currC, size, cnt + size * size * 2);
		} else {
			return recur(currR + size, currC + size, size, cnt + size * size * 3);
		}
	}

}
