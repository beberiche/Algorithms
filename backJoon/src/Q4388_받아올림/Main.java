package Q4388_받아올림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String a = stk.nextToken();
            String b = stk.nextToken();

            if (a.equals("0") && b.equals("0")) break;

//            int max = 13; // 숫자 최대 10자리
            int carry = 0; // 받아올림
            boolean isCarry = false; // 받아올림이 발생했는지 여부
            int max = Math.max(a.length(), b.length());

            for (int i = 0; i < max; i++) {
                int aIdx = a.length() - i - 1;
                int bIdx = b.length() - i - 1;
                int sum = 0;
                if (aIdx >= 0) sum += a.charAt(aIdx) - '0';
                if (bIdx >= 0) sum += b.charAt(bIdx) - '0';
                sum += isCarry ? 1 : 0;

                if (sum >= 10) {
                    carry++;
                    isCarry = true;
                } else {
                    isCarry = false;
                }
            }
            sb.append(carry).append("\n");
        }
        System.out.print(sb);
    }
}
