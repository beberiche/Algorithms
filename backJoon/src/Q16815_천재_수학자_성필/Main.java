package Q16815_천재_수학자_성필;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Long> stack = new Stack<>();

        String str = br.readLine();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((long)(c - '0'));
            } else {
                // 연산자인 경우
                long operand2 = stack.pop();
                long operand1 = stack.pop();
                long tempResult;
                switch (c) {
                    case '+':
                        tempResult = operand1 + operand2;
                        break;
                    case '-':
                        tempResult = operand1 - operand2;
                        break;
                    case '*':
                        tempResult = operand1 * operand2;
                        break;
                    case '/':
                        tempResult = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + c);
                }
                stack.push(tempResult);
            }
        }

        System.out.println(stack.pop());
    }
}