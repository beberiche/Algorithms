package Q10262_주사위_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Gunnar = 0, Emma = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            Gunnar += Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            Emma += Integer.parseInt(stk.nextToken());
        }

        String ans = "Tie";

        if (Gunnar > Emma) {
            ans = "Gunnar";
        } else if (Gunnar < Emma) {
            ans = "Emma";
        }
        System.out.print(ans);
    }
}
