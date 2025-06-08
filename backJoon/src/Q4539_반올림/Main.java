package Q4539_반올림;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String n = br.readLine();
            int[] arr = new int[n.length()];

            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < n.length(); j++) {
                arr[j] = 0;
                arr[j] = n.charAt(j) - 48;
            }

            for (int k = n.length() - 1; k >= 1; k--) {
                if (arr[k] > 4) {
                    arr[k - 1] += 1;
                }
                arr[k] = 0;
            }

            for (int p = 0; p < n.length(); p++) {
                sb2.append(arr[p]);
            }
            sb.append(sb2).append("\n");
        }
        System.out.print(sb);
    }
}
