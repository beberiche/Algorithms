package Q5096_STL_String2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr1 = sc.nextLine().split(" ");
		String[] arr2 = sc.nextLine().split(" ");

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		String ans1 = "";
		String ans2 = "";

		for (String s : arr1) {
			ans1 += s + " ";
		}
		for (String s : arr2) {
			ans2 += s + " ";
		}
		
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
