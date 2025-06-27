package Q5026_박사_과정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int questionSize = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < questionSize; i++) {
            String curStr = br.readLine();

            if (curStr.equals("P=NP")) {
                sb.append("skipped\n");
            } else {
                StringTokenizer stk = new StringTokenizer(curStr, "+");
                int lNum = Integer.parseInt(stk.nextToken());
                int rNum = Integer.parseInt(stk.nextToken());
                sb.append(lNum + rNum).append("\n");
            }
        }
        System.out.print(sb);
    }
}
