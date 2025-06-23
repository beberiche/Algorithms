package Q4796_캠핑;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = 1;
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(stringTokenizer.nextToken());
            int P = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int totalDays = (V / P) * L + Math.min(V % P, L);
            sb.append("Case ").append(T++).append(": ").append(totalDays).append("\n");
        }
        System.out.print(sb.toString());
    }
}
