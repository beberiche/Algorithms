package Q34052_체육은_수학과목_입니다_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println((sum + 300) <= 1800 ? "Yes" : "No");
    }
}
