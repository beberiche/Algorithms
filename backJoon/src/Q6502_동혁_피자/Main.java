package Q6502_동혁_피자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            if (r == 0) {
                break;
            }
            int w = Integer.parseInt(stk.nextToken());
            double ww = Math.pow(w, 2);
            int l = Integer.parseInt(stk.nextToken());
            double ll = Math.pow(l, 2);

            sb.append("Pizza ").append(count++);
            if (r * 2 >= Math.sqrt(ww + ll)) {
                sb.append(" fits ");
            } else {
                sb.append(" does not fit ");
            }
            sb.append("on the table.\n");
        }
        System.out.print(sb.toString());
    }
}

