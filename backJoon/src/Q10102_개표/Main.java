package Q10102_개표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[128];
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            cnt[str.charAt(i)]++;
        }

        String answer;

        if (cnt['A'] > cnt['B']) {
            answer = "A";
        } else if (cnt['A'] < cnt['B']) {
            answer = "B";
        } else {
            answer = "Tie";
        }
        System.out.print(answer);
    }
}
