package Q1392_노래_악보;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int time = Integer.parseInt(br.readLine());
            for (int j = 0; j < time; j++) {
                list.add(i);
            }
        }

        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(list.get(num)).append("\n");
        }
        System.out.print(sb);
    }
}
