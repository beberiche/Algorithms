package Q12904_A와_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String strS;
    static String strT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strS = br.readLine();
        strT = br.readLine();

        solution(strT);

        System.out.println(0);
    }

    private static void solution(String st) {
        Queue<String> q = new LinkedList<>();
        q.add(st);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals("")) continue;

            if (curr.equals(strS)) {
                System.out.println(1);
                System.exit(0);
            }

            if (curr.charAt(curr.length() - 1) == 'A') {
                q.add(curr.substring(0, curr.length() - 1));
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = curr.length()-2; i >= 0; i--) {
                    sb.append(curr.charAt(i));
                }
                q.add(sb.toString());
            }
        }
    }
}
