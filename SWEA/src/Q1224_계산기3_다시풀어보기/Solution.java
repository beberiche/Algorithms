package Q1224_계산기3_다시풀어보기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static int ans;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1224.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	for (int TC = 1; TC <= 10; TC++) {
	    int len = Integer.parseInt(br.readLine()); // 길이가져오기
	    char[] T = br.readLine().toCharArray();

	    // 후위용 스택
	    Stack<Character> stack1 = new Stack<>();
	    // 중위용 스택

	    StringBuilder post = new StringBuilder();

	    // 후위 만들기
	    for (int idx = 0; idx < len; idx++) {
		switch (T[idx]) {
		case '(': { // 여는 괄호면 그냥 들어가자.
		    stack1.push(T[idx]);
		    break;
		}
		case ')': { // 닫는 괄호의 경우
		    while (stack1.peek() != '(') { // 여는 괄호가 나올때 까지 모두 pop!
			post.append(stack1.pop()); // 출력용 sb에 넣기
		    }
		    stack1.pop();
		    break; // 끝나면 다음으로
		}
		case '+': { // +의 경우
		    while (stack1.peek() != '(') { // * + 모두 뺀다.
			post.append(stack1.pop());
			if (stack1.isEmpty()) { // 괄호가 없다면 전부 뺀다음 break;
			    break;
			}
		    }
		    stack1.push(T[idx]); // 그리고 지금 나온거를 집어넣어준다.
		    break;
		}
		case '*': {
		    if (stack1.peek() == '*') { // 곱셈이라면 같은 곱셈이 아닌 이상 무조건 넣는다.
			post.append(stack1.pop());
		    }
		    stack1.push(T[idx]);
		    break;
		}
		default:
		    post.append(T[idx]); // 여기까지 왔다면 숫자이니 그냥 출력해준다.
		}
	    }

	    // 후위 중위 스택 만들기
	    char[] T2 = post.toString().toCharArray();
	    int len2 = T2.length;
	    Stack<Integer> stack2 = new Stack<>();

	    for (int idx = 0; idx < len2; idx++) {
		int temp1 = 0;
		int temp2 = 0;
		switch (T2[idx]) {
		case '+': {
		    temp2 = stack2.pop();
		    temp1 = stack2.pop();
		    stack2.push(temp1 + temp2);
		    break;
		}
		case '*': {
		    temp2 = stack2.pop();
		    temp1 = stack2.pop();
		    stack2.push(temp1 * temp2);
		    break;
		}
		default:
		    stack2.push((int) T2[idx] - '0');
		}
	    }
	    System.out.printf("#%d %d\n", TC, stack2.pop());
	}
    }
}

// 952*1++33*7*6*9*1*7*1+86*+61*1*5*2*+4*7*+43*8*2*6*+78*4*5*+3+7+26+5+1+7+6+73*62+*+6+6+2*+4+22*+49*3*+