package Q8741_이진수_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("1");
        }

        for (int i = 0; i < N - 1; i++) {
            sb.append("0");
        }

        System.out.print(sb);
    }
}
