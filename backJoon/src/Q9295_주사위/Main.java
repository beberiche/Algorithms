package Q9295_주사위;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            sb.append("Case ").append(i + 1).append(": ").append(A+B).append("\n");
        }
        System.out.print(sb);
    }
}
