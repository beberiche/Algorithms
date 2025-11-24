package Q28295_체육은_코딩과목_입니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        for (int i = 0; i < 10; i++) {
            result += Integer.parseInt(br.readLine());
        }

        if (result % 4 == 0) {
            System.out.println("N");
        } else if (result % 4 == 1) {
            System.out.println("E");
        } else if (result % 4 == 2) {
            System.out.println("S");
        } else if (result % 4 == 3) {
            System.out.println("W");
        }
    }
}
