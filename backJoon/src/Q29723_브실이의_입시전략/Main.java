package Q29723_브실이의_입시전략;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int diff = M - K;

        TreeMap<String, Integer> m = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            String name = stk.nextToken();
            int score = Integer.parseInt(stk.nextToken());

            m.put(name, score);
        }
        int sum = 0;
        for (int i = 0; i < K; i++) {
            String name = br.readLine();
            sum += m.get(name);
            m.remove(name);
        }

        List<Integer> scores = new ArrayList<>(m.values());
        Collections.sort(scores);
        int min = sum;
        for (int i = 0; i < diff; i++) {
            min += scores.get(i);
        }
        Collections.sort(scores, Collections.reverseOrder());
        int max = sum;
        for (int i = 0; i < diff; i++) {
            max += scores.get(i);
        }
        System.out.println(min + " " + max);
    }
}
