package Q1302_베스트셀러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 1) + 1);
        }

        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        List<String> bestSellers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                bestSellers.add(entry.getKey());
            }
        }

        Collections.sort(bestSellers);
        System.out.println(bestSellers.get(0));
    }
}
