package 스택;

class ArrayStack {
	private int top;
	private int size;
	private char stackArr[];

	// 스택 생성자
	public ArrayStack(int size) {
		top = -1;
		this.size = size;
		stackArr = new char[size];
	}

	// isEmpty
	public boolean isEmpty() {
		return top == -1;
	}

	// isFull
	public boolean isFull() {
		return top == this.size - 1;
	}

	// push
	public void push(char ch) {
		if (isFull()) {
			System.out.println("stack is FULL!!");
		} else {
			stackArr[++top] = ch;
			System.out.println("inserted Item : " + ch);
		}
	}

	// pop
	public char pop() {
		if (isEmpty()) {
			System.out.println("stack is already EMPTY!!");
			return 0;
		} else {
			System.out.println("deleted Item : " + stackArr[top]);
			return stackArr[top--];
		}
	}

	public void peek() {
		if (isEmpty()) {
			System.out.println("stack is already EMPTY!!");
		} else {
			System.out.println("top Item : " + stackArr[top]);
		}
	}

	public void clear() {
		this.top = -1;
		this.stackArr = new char[size];
		System.out.println("stack is clear");
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("stack is already EMPTY!!");
		} else {
			System.out.print("stack print : ");
			for (int i = 0; i <= top; i++) {
				System.out.print(stackArr[i] + " ");
			}
			System.out.println();
		}
	}
}

public class Main {
	public static void main(String args[]) {
		int stackSize = 5;
		ArrayStack arrStack = new ArrayStack(stackSize);

		arrStack.push('A');
		arrStack.printStack();

		arrStack.push('B');
		arrStack.printStack();

		arrStack.push('C');
		arrStack.printStack();

		arrStack.pop();
		arrStack.printStack();

		arrStack.pop();
		arrStack.printStack();

		arrStack.peek();
		arrStack.printStack();

		arrStack.clear();
		arrStack.printStack();
	}

}
