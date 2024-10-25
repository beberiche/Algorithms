package Q1076_저항;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        Map<String, Long> map2 = new HashMap<>();
        String[] a = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        long mul = 1;
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], String.valueOf(i));
            map2.put(a[i], mul);
            mul *= 10;
        }

        String num1 = map.get(br.readLine());
        String num2 = map.get(br.readLine());
        long num3 = map2.get(br.readLine());

        System.out.println(Integer.parseInt(num1 + num2) * num3);
    }
}
