package Q2875_대회_or_인턴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int team = 0;
        while (N >= 2 && M >= 1 && N + M >= K + 3) {
            N -= 2;
            M -= 1;
            team++;
        }

        System.out.println(team);
    }
}
