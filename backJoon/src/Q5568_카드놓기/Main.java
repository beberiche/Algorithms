package Q5568_카드놓기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		List<String> list = new ArrayList<>();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		if (K == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					String str1 = arr[i] + "";
					String str2 = arr[j] + "";
					list.add(str1 + str2);
					list.add(str2 + str1);
				}
			}
		} else if (K == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						String str1 = arr[i] + "";
						String str2 = arr[j] + "";
						String str3 = arr[k] + "";
						list.add(str1 + str2 + str3);
						list.add(str1 + str3 + str2);
						list.add(str2 + str1 + str3);
						list.add(str2 + str3 + str1);
						list.add(str3 + str2 + str1);
						list.add(str3 + str1 + str2);
					}
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						for (int l = k + 1; l < N; l++) {
							String str1 = arr[i] + "";
							String str2 = arr[j] + "";
							String str3 = arr[k] + "";
							String str4 = arr[l] + "";
							list.add(str1 + str2 + str3 + str4);
							list.add(str1 + str2 + str4 + str3);
							list.add(str1 + str3 + str2 + str4);
							list.add(str1 + str3 + str4 + str2);
							list.add(str1 + str4 + str2 + str3);
							list.add(str1 + str4 + str3 + str2);
							list.add(str2 + str1 + str3 + str4);
							list.add(str2 + str1 + str4 + str3);
							list.add(str2 + str4 + str1 + str3);
							list.add(str2 + str4 + str3 + str1);
							list.add(str2 + str3 + str1 + str4);
							list.add(str2 + str3 + str4 + str1);
							list.add(str3 + str1 + str2 + str4);
							list.add(str3 + str1 + str4 + str2);
							list.add(str3 + str2 + str4 + str1);
							list.add(str3 + str2 + str1 + str4);
							list.add(str3 + str4 + str1 + str2);
							list.add(str3 + str4 + str2 + str1);
							list.add(str4 + str3 + str2 + str1);
							list.add(str4 + str3 + str1 + str2);
							list.add(str4 + str1 + str3 + str2);
							list.add(str4 + str1 + str2 + str3);
							list.add(str4 + str2 + str1 + str3);
							list.add(str4 + str2 + str3 + str1);

						}
					}
				}
			}
		}
		Set<String> set = new HashSet<>(list);
		System.out.println(set.size());
	}
}
