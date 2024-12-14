package Q1551_수열의_변화;

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
        int K = Integer.parseInt(stk.nextToken());

        List<Integer> ret = new ArrayList<>();
        stk = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < N; i++) {
            ret.add(Integer.parseInt(stk.nextToken()));
        }
        for (int i = 1; i <= K; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N - i; j++) {
                list.add(ret.get(j + 1)-ret.get(j));
            }
            ret = list;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : ret) {
            sb.append(num).append(",");
        }
        System.out.print(sb.deleteCharAt(sb.length()-1));
    }
}
