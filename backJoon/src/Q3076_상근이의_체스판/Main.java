package Q3076_상근이의_체스판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R * A; i++) {
            for (int j = 0; j < C * B; j++) {
                if (((i / A) % 2) == ((j / B) % 2)) {
                    sb.append('X');
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

