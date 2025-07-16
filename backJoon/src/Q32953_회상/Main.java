package Q32953_회상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            while (k-- > 0) {
                int i = Integer.parseInt(stk.nextToken());
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        int cnt = 0;
        for (int v : map.values()) if (v >= m) cnt++;
        System.out.println(cnt);
    }
}