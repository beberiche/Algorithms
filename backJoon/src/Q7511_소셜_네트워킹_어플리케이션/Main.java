package Q7511_소셜_네트워킹_어플리케이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,K,M;
    static int[] p;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int t=1; t<=TC; t++) {
            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());
            p = new int[N];
            Arrays.fill(p, -1);
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                union(n1,n2);
            }

            M = Integer.parseInt(br.readLine());
            sb.append(String.format("Scenario %d:%n", t));
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                if(find(n1) == find(n2)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public static void union(int n1, int n2) {
        int f1 = find(n1);
        int f2 = find(n2);
        if(f1 == f2) return;
        if(p[f1] < p[f2]) p[f2] = f1;
        else p[f1] = f2;
    }

    public static int find(int n) {
        if(p[n] < 0) return n;
        return p[n] = find(p[n]);
    }
}
