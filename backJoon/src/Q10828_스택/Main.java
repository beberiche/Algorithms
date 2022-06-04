package Q10828_스택;

import java.util.Scanner;

class ArrayStack {
	private int top;
	private int size;
	private int stackArr[];

	// 스택 생성자
	public ArrayStack(int size) {
		top = -1;
		this.size = size;
		stackArr = new int[size];
	}

	// isEmpty
	public int isEmpty() {
		if (top == -1) {
			return 1;
		} else {
			return 0;
		}
	}

	// size
	public int size() {
		return top + 1;
	}

	// push
	public void push(int n) {
		stackArr[++top] = n;
	}

	// pop
	public int pop() {
		if (top == -1) {
			return -1;
		} else {
			return stackArr[top--];
		}
	}

	// top
	public int top() {
		if (top == -1) {
			return -1;
		} else {
			return stackArr[top];
		}
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayStack stack = new ArrayStack(N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			switch (sc.next()) {
			case "push":
				stack.push(sc.nextInt());
				break;
			case "top":
				sb.append(stack.top()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "pop":
				sb.append(stack.pop()).append("\n");
				break;
			case "empty":
				sb.append(stack.isEmpty()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
