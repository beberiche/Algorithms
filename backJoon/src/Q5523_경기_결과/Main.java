package Q5523_경기_결과;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int Awin = 0;
        int Bwin = 0;

        for (int i = 0; i < T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            if (A > B) {
                Awin++;
            } else if (B > A) {
                Bwin++;
            }
        }
        System.out.print(Awin + " " + Bwin);
    }
}
