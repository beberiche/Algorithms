package Q2440_별_찍기_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append("*");
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<N; i++) {
            ans.append(sb).append("\n");
            sb.delete(0, 1);
        }
        System.out.print(ans);
    }
}
