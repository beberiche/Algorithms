package Q10797_10부제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < 5; i++) {
            int car = Integer.parseInt(stk.nextToken());
            if (car == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}
