package Q1864_문어_숫자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Long> m = new HashMap<>();
        m.put('-', 0L);
        m.put('\\', 1L);
        m.put('(', 2L);
        m.put('@', 3L);
        m.put('?', 4L);
        m.put('>', 5L);
        m.put('&', 6L);
        m.put('%', 7L);
        m.put('/', -1L);

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("#")) break;

            long ret = 0;
            int idx = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                ret += m.get(str.charAt(idx++)) * Math.pow(8, i);
            }
            sb.append(ret).append("\n");
        }
        System.out.print(sb);
    }
}
