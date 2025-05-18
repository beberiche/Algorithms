package Q3460_이진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int index = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    sb.append(index).append(" ");
                }
                num = num >> 1;
                index++;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
