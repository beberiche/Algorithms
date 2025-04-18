package Q2966_찍기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String ans = br.readLine();

        char[] s = new char[]{'A', 'B', 'C'};
        char[] c = new char[]{'B', 'A', 'B', 'C'};
        char[] h = new char[]{'C', 'C', 'A', 'A', 'B', 'B'};

        int cnt_s = go(s, N, ans);
        int cnt_c = go(c, N, ans);
        int cnt_h = go(h, N, ans);
        int max = Math.max(cnt_s, Math.max(cnt_c, cnt_h));
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        if (max == cnt_s) {
            sb.append("Adrian").append("\n");
        }
        if (max == cnt_c) {
            sb.append("Bruno").append("\n");
        }
        if (max == cnt_h) {
            sb.append("Goran").append("\n");
        }
        System.out.print(sb);
    }

    private static int go(char[] arr, int len, String ans) {
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i % arr.length] == ans.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }
}
