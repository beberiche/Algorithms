package Q1427_소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = 10;
        int[] cnt = new int[N];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            while (cnt[i]-- != 0) sb.append(i);
        }
        System.out.print(sb);
    }
}
