package Q3699_변장;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (--T >= 0) {
			int N = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				sc.next();
				String key = sc.next();
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}

			int result;
			int ans = 1;
			int size = map.size();
			if (size == 1) {
				for (String str : map.keySet()) 
					System.out.println(map.get(str));
			} else {
				for (String str : map.keySet()) {
					if (size == 1) {
						System.out.println(map.get(str));
					} else {
						result = map.get(str) + 1;
						ans *= result;
					}
				}
				System.out.println(ans - 1);
			}
		}
	}
}
