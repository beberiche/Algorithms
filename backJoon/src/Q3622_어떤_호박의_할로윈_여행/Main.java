package Q3622_어떤_호박의_할로윈_여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int a = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int P = Integer.parseInt(stk.nextToken());

        if (A > P || B > P) {
            System.out.println("No");
        } else if (A + B <= P) {
            System.out.println("Yes");
        } else if (a >= B) {
            System.out.println("Yes");
        } else if (b >= A) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
