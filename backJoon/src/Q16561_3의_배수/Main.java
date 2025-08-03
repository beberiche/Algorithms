package Q16561_3의_배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int cnt = 2;
        for (int i = 9; i < n; i += 3) {
            sum += cnt;
            cnt++;
        }
        System.out.println(sum);
    }
}
