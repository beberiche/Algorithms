package Q5430_AC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int T, n;
    static String p, sp;

    static Deque<String> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (--T >= 0) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            sp = br.readLine();
            try {
                if (sp.charAt(0) == '[' && sp.charAt(1) == ']' && p.contains("D")) {
                    throw new Exception();
                }
                String[] spl = sp.substring(1, sp.length() - 1).split(",");

                for (int i = 0; i < spl.length; i++) dq.add(spl[i]);

                boolean isF = true;
                for (int i = 0; i < p.length(); i++) {
                    char tsp = p.charAt(i);
                    if (tsp == 'R') isF = !isF;
                    else {
                        if (isF) dq.removeFirst();
                        else dq.removeLast();
                    }
                }

                if (isF) poll(true);
                else poll(false);

            } catch (Exception e) {
                printError();
            }
        }
        System.out.println(sb.toString());
    }

    private static void poll(boolean check) {
        sb.append("[");
        while (!dq.isEmpty())
            if (dq.size() == 1)
                if(check)
                    sb.append(dq.pollFirst());
                else
                    sb.append(dq.pollLast());
            else
                if(check)
                    sb.append(dq.poll()).append(",");
                else
                    sb.append(dq.pollLast()).append(",");
        sb.append("]\n");
    }

    private static void printError() {
        sb.append("error\n");
    }
}