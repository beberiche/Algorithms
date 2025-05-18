package Q3448_문자_인식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String ans = "Efficiency ratio is ";
        for (int i = 0; i < n; i++) {
            int r = 0;
            int a = 0;
            while (true) {
                String str;
                str = br.readLine();
                if (str.equals("")) {
                    break;
                }

                r += str.replaceAll("#", "").length();
                a += str.length();
            }
            double recognitionRate = (double) r / a * 100;
            recognitionRate = Math.round(recognitionRate * 10) / 10.0;

            if (recognitionRate == (int) recognitionRate) {
                sb.append(ans).append((int) recognitionRate).append("%.\n");
            } else {
                sb.append(ans).append(recognitionRate).append("%.\n");
            }
        }
        System.out.print(sb);
    }
}