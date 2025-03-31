package Q2896_무알콜_칵테일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(stk.nextToken());
        double B = Double.parseDouble(stk.nextToken());
        double C = Double.parseDouble(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        double I = Double.parseDouble(stk.nextToken());
        double J = Double.parseDouble(stk.nextToken());
        double K = Double.parseDouble(stk.nextToken());

        double a = A / I;
        double b = B / J;
        double c = C / K;

        double min = Math.min(a, Math.min(b, c));
        System.out.print((A - I * min) + " " + (B - J * min) + " " + (C - K * min));
    }
}
