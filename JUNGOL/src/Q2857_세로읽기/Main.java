package Q2857_세로읽기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][15];

		for (int i = 0; i < 5; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				arr[i][j] = temp[j];
			}
		}

		String str = "";
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[j][i] >= '0')
				str += arr[j][i];
			}
		}
		System.out.println(str);

	}
}
