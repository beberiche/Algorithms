package Q2693_N번째_큰_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }
        System.out.print(sb);
    }
}
