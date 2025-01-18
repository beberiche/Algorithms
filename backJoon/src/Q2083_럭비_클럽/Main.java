package Q2083_럭비_클럽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final String JUNIOR = "Junior";
    private static final String SENIOR = "Senior";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String name = stk.nextToken();
            int age = Integer.parseInt(stk.nextToken());
            int height = Integer.parseInt(stk.nextToken());

            if(name.equals("#")) {
                break;
            }

            sb.append(name).append(" ");
            sb.append((age > 17 || height >= 80) ? SENIOR : JUNIOR).append("\n");
        }
        System.out.print(sb);
    }
}
