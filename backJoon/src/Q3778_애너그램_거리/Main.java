package Q3778_애너그램_거리;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] a = new int[26];
            int[] b = new int[26];

            String line1 = br.readLine();
            for (char ch : line1.toCharArray()) {
                int cur = ch - 'a';
                if (cur >= 0 && cur < 26) {
                    a[cur]++;
                }
            }

            String line2 = br.readLine();
            for (char ch : line2.toCharArray()) {
                int cur = ch - 'a';
                if (cur >= 0 && cur < 26) {
                    b[cur]++;
                }
            }

            int result = 0;
            for (int j = 0; j < 26; j++) {
                if (a[j] != b[j]) {
                    result += Math.abs(a[j] - b[j]);
                }
            }

            bw.write("Case #" + (i + 1) + ": " + result);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
