package Q16139_인간_컴퓨터_상호작용;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[26][str.length() + 1];

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (i == str.charAt(j - 1) - 'a') {
                    arr[i][j] = arr[i][j - 1] + 1;
                } else {
                    arr[i][j] = arr[i][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int idx = stk.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            sb.append(arr[idx][r + 1] - arr[idx][l]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
