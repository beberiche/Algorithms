package Q25556_포스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        Stack<Integer> s4 = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        boolean check = true;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (s1.isEmpty() || s1.peek() < num) s1.add(num);
            else if (s2.isEmpty() || s2.peek() < num) s2.add(num);
            else if (s3.isEmpty() || s3.peek() < num) s3.add(num);
            else if (s4.isEmpty() || s4.peek() < num) s4.add(num);
            else {
                check = false;
                break;
            }
        }

        System.out.println(check ? "YES" : "NO");

    }
}
