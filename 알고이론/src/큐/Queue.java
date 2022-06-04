package 큐;

import java.util.Arrays;

class ArrayQueue {
	int front = 0;
	int rear = 0;
	int[] arr;

	ArrayQueue() {
		this(10);
	}

	ArrayQueue(int size) {
		arr = new int[size + 1];
	}

	// isEmpty
	public boolean isEmpty() {
		return front == rear;
	}

	// isFull
	public boolean isFull() {
		return rear == arr.length - 1;
	}

	// enQueue
	// 뒤에 채워진다
	// rear로 제어
	public void enQueue(int n) {
		if (isFull()) {
			System.out.println("꽉찼어!");
			return;
		}
		arr[++rear] = n;
	}

	// deQueue
	// 앞에 것이 나와야 한다.
	// front로 제어
	// 모두 한칸씩 땡기고,
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("비었어!!");
			return -1;
		}
		int n = arr[++front];
		arr[front] = 0;
		return n;
	}

	// print 확인용
	public void print() {
		System.out.println(Arrays.toString(arr));
	}
}

public class Queue {
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue();
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(2);
		q.enQueue(6);

		System.out.println(q.deQueue());
		q.print();
		System.out.println(q.deQueue());
		q.print();
		System.out.println(q.deQueue());
		q.print();
		System.out.println(q.deQueue());
		q.print();
		System.out.println(q.deQueue());
		q.print();
		System.out.println(q.deQueue());
	}
}
