package Q11005_진법_변환_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        HashMap<Integer, String> m = new HashMap<>();

        Character ch = 'A';
        for (int i = 10; i <= 35; i++) {
            m.put(i, (ch++).toString());
        }

        StringBuilder sb = new StringBuilder();
        while (N >= B) {
            int mod = N % B;
            String ret = (mod >= 10) ? m.get(mod) : String.valueOf(mod);
            sb.append(ret);
            N /= B;
        }
        sb.append(N >= 10 ? m.get(N) : String.valueOf(N));
        System.out.print(sb.reverse());
    }
}
