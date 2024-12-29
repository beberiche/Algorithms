package Q1855_암호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < str.length() / K; j++) {
                sb.append(str.charAt(j % 2 == 0 ? j * K + i : j * K + K - 1 - i));
            }
        }

        System.out.print(sb);
    }
}
