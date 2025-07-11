package Q1384_메시지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int step = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            String[][] arr = new String[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = st.nextToken();
                }
            }

            sb.append("Group ").append(step++).append("\n");

            boolean check = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j].equals("N")) {
                        sb.append(arr[(i < j) ? n - (j - i) : (i - j)][0]).append(" was nasty about ").append(arr[i][0]).append("\n");
                        check = true;
                    }
                }
            }

            if (!check) {
                sb.append("Nobody was nasty").append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
