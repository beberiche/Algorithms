package Q23284_모든_스택_수열;


// 재귀를 pop(), push() 순으로
// 조건 충족시킬것
// 1. 현재 스택이 비어있다면 pop() 불가능
// 2. 현재 N개 만큼 push를 했다면, 더이상 push 불가 -> pop만 진행
// 3. 2*N만큼 깊이가 도달해야함.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer> s;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int N;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        s = new Stack<>();
    }


    private static void solve(int d1, int d2, int num) {
        if (d1 >= N && d2 >= N) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (!s.isEmpty() && d1 < N) {
            int next = s.pop();
            list.add(next);
            solve(d1 + 1, d2, num);
            list.remove(list.size() - 1);
            s.push(next);
        }


        if (d2 < N) {
            s.push(num);
            solve(d1, d2 + 1, num + 1);
            s.pop();
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        input();
        solve(0, 0, 1);
        output();
    }
}
