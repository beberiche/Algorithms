package Q10845_큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ArrayQueue {
	int size;
	int front;
	int rear;
	int[] arr;

	ArrayQueue(int n) {
		arr = new int[n + 1];
	}

	// push 집어넣는 곳
	public void push(int n) {
		arr[++rear] = n;
		size++;
	}

	// pop 뽑는 곳 비어있다면 -1
	public int pop() {
		if (empty() == 1) {
			return -1;
		}
		int n = arr[++front];
		arr[front] = 0;
		size--;
		return n;
	}

	// size 큐의 정수의 개수
	public int size() {
		return size;
	}

	// empty 비어있다면 1 아니면 0
	public int empty() {
		if (rear == front) {
			return 1;
		} else {
			return 0;
		}
	}

	// front 가장 앞에 있는 정수 출력 없다면 -1
	public int front() {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 0) {
				return arr[i];
			}
		}
		return -1;
	}

	// back 가장 뒤에있는 정수를 출력 없다면 -1
	public int back() {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				return arr[i];
			}
		}
		return -1;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayQueue q = new ArrayQueue(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				q.push(Integer.parseInt(st.nextToken()));
				break;
			case "front":
				System.out.println(q.front());
				break;
			case "back":
				System.out.println(q.back());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				System.out.println(q.empty());
				break;
			case "pop":
				System.out.println(q.pop());
				break;
			}
		}

	}
}
