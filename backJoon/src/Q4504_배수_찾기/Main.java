package Q4504_배수_찾기;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] a = new boolean[10001];
        for (int i = 0; i <= 10000; i += N) {
            a[i] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) break;
            if (a[x]) {
                sb.append(x).append(" is a multiple of ");
            } else {
                sb.append(x).append(" is NOT a multiple of ");
            }
            sb.append(N).append(".\n");
        }

        System.out.print(sb.toString());
    }
}
