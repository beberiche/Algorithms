package Q2530_인공지능_시계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        B += D / 60;
        C += D % 60;

        B += C / 60;
        C = C % 60;

        A += B / 60;
        B = B % 60;

        A = A % 24;

        StringBuilder sb = new StringBuilder();
        sb.append(A).append(" ").append(B).append(" ").append(C);
        System.out.print(sb);
    }
}
