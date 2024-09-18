package Q2374_같은_수로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Long> s = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        long max = 0;
        long ans = 0;

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            max = Math.max(max, num);

            if (s.isEmpty()) {
                s.push(num);
            } else {
                if (s.peek() < num) {
                    ans += num - s.pop();
                    s.push(num);
                } else if (s.peek() > num) {
                    s.pop();
                    s.push(num);
                }
            }
        }

        while (!s.isEmpty()) {
            long num = s.pop();
            ans += max - num;
        }
        System.out.println(ans);
    }
}
