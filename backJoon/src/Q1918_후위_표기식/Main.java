package Q1918_후위_표기식;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 현재들어가는 연산자에 대해
// 우선 순위가 높은 이전 연산자를 모두 pop;
// ( 는 그냥 푸시, ) 인 경우, ( 가 나올 때 까지 pop;
// 마지막 남은 거 모두 pop;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static String str;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    private static void solve() {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '(') {
                s.push(curr);
            } else if (curr == ')') {
                while (!s.isEmpty()) {
                    char tmp = s.pop();
                    if (tmp == '(') break;
                    else sb.append(tmp);
                }
            } else if (curr == '+' || curr == '-') {
                while (!s.isEmpty()) {
                    char tmp = s.peek();
                    if (tmp == '(') break;
                    else sb.append(s.pop());
                }
                s.push(curr);
            } else if (curr == '/' || curr == '*') {
                while (!s.isEmpty()) {
                    char tmp = s.peek();
                    if (tmp == '-' || tmp == '+' || tmp == '(') break;
                    else sb.append(s.pop());
                }
                s.push(curr);
            } else {
                sb.append(curr);
            }
        }
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
