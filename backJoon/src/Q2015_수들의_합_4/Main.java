package Q2015_수들의_합_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N + 1];
        stk = new StringTokenizer(br.readLine());

        Map<Integer, Integer> m = new HashMap<>();
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            arr[i] = arr[i - 1] + num;
            if (arr[i] == K) ans++;
        }

        for (int i=1; i<=N; i++) {
            if (m.containsKey(arr[i] - K)) {
                ans += m.get(arr[i] - K);
            }

            m.put(arr[i], m.getOrDefault(arr[i], 0)+1);

        }

        System.out.println(ans);
    }
}
