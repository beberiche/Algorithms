package Q8974_희주의_수학시험;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int st = Integer.parseInt(stk.nextToken());
        int ed = Integer.parseInt(stk.nextToken());
        int sum = 0;
        for (int i = st; i <= ed; i++) {
            sum += list.get(i - 1);
        }
        System.out.print(sum);
    }
}
