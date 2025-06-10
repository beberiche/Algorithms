package Q4564_숫자_카드놀이;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            StringBuilder sb2 = new StringBuilder();
            sb2.append(num).append(" ");
            char[] a = String.valueOf(num).toCharArray();
            while (a.length > 1) {
                long ret = 1;
                for (int i = 0; i < a.length; i++) {
                    ret *= (a[i] - '0');
                }
                a = String.valueOf(ret).toCharArray();
                sb2.append(ret).append(" ");
            }
            sb2.append("\n");
            sb.append(sb2);
        }
        System.out.print(sb);
    }
}
