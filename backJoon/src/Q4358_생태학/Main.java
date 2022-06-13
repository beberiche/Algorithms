package Q4358_생태학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> map = new TreeMap<>();
		int cnt = 0;
		while (true) {
			String input = br.readLine();

			if (input == null || input.equals(""))
				break;
			if (map.containsKey(input))
				map.put(input, map.get(input) + 1);
			else
				map.put(input, 1);
			cnt++;
		}


		for (String str : map.keySet())
			System.out.printf("%s %.4f\n", str, (double) (map.get(str) * 100) / cnt);

	}
}
