package Q2446_별_찍기_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 5
        // 공백, 별, 공백
        // 공백 : 0,1,2,3,4
        // 별 : 4,3,2,1,0
        // *

        StringBuilder sb = new StringBuilder();

        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<N-i-1; j++) {
                sb.append(" ");
            }

            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            sb.append("*");

            for(int j=0; j<i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<N-i-1; j++) {
                sb.append(" ");
            }

            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            sb.append("*");

            for(int j=0; j<i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
