package Q1218_괄호짝짓기_다시풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static int ans;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1218.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	for (int TC = 1; TC <= 10; TC++) {
	    int len = Integer.parseInt(br.readLine());

	    char[] arr = br.readLine().toCharArray();

	    Stack<Character> stack = new Stack<>();

	    boolean flag = true;

	    int ans = 1;
	    for (int i = 0; i < len; i++) {
		if (arr[i] == '<' || arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
		    stack.push(arr[i]);
		} else if (arr[i] == '>' && stack.peek() == '<') {
		    stack.pop();
		    continue;
		} else if (arr[i] == ')' && stack.peek() == '(') {
		    stack.pop();
		    continue;
		} else if (arr[i] == ']' && stack.peek() == '[') {
		    stack.pop();
		    continue;
		} else if (arr[i] == '}' && stack.peek() == '{') {
		    stack.pop();
		    continue;
		} else {
		    flag = false;
		    break;
		}
	    }

	    ans = flag ? 1 : 0;

	    System.out.printf("#%d %d\n", TC, ans);
	}
    }

}
