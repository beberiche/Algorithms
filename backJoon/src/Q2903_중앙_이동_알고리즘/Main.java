package Q2903_중앙_이동_알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print((int) Math.pow(Math.pow(2, N) + 1, 2));
    }
}
