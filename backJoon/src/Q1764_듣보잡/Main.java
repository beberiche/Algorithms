package Q1764_듣보잡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map.put(sc.next(), 1);
		}

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			if (map.containsKey(str)) {
				list.add(str);
			}
			continue;
		}

		System.out.println(list.size());

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
