package Q5692_팩토리얼_진법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            int size = str.length();
            int sum = 0;

            if (str.equals("0")) break;

            for (int i = 0; i < str.length(); i++) {
                int n = str.charAt(i) - '0';
                for (int j = 2; j <= size; j++) {
                    n *= j;
                }
                sum += n;
                size--;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
