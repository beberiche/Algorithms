package Q1138_한_줄로_서기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[N];
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(stk.nextToken());
            int cnt = 0;
            for(int j=0; j<N; j++) {
                if(visited[j]) continue;

                if(cnt == n) {
                    visited[j] = true;
                    a[j] = i;
                    break;
                }
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            sb.append(num).append(" ");
        }
        System.out.print(sb.toString());
    }

}
