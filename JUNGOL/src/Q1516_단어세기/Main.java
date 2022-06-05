package Q1516_단어세기;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.nextLine();
			if (str.equals("END"))
				break;

			String[] arr = str.split(" ");
			Map<String, Integer> map = new TreeMap<>();
			for (int i = 0; i < arr.length; i++) {
				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
				} else {
					map.put(arr[i], 1);
				}
			}
		
			for(String key : map.keySet()) {
				System.out.println(key +" : " + map.get(key) );
			}
		}
	}
}
