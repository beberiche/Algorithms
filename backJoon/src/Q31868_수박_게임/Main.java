package Q31868_수박_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int waterCount = 1;
        int answer = 0;

        for (int i = 1; i < N; i++) {
            waterCount *= 2;
        }

        while (K >= waterCount) {
            K -= waterCount;
            answer++;
        }

        System.out.println(answer);
    }
}
