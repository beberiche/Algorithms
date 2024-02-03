package heap;

import java.util.Arrays;

class 맥스힙 {
	int[] arr;
	int pos;

	맥스힙() {
		this(10);
	}

	맥스힙(int size) {
		arr = new int[size + 1];
	}

	private boolean isFull() {
		return pos == arr.length - 1;
	}

	public void offer(int data) {
		if (isFull()) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}

		arr[++pos] = data;

		int idx = pos;
		while (idx > 1) {
			if (arr[idx] > arr[idx / 2]) {
				swap(idx, idx / 2);
			}
			idx /= 2;
		}
	}

	public void print() {
		System.out.println(Arrays.toString(arr));
	}

	public int poll() {
		if (pos == 0)
			return -1;
		int temp = arr[1];
		arr[1] = arr[pos];
		arr[pos--] = 0;

		heapify();
		return temp;
	}

	private void heapify() {
		int idx = 1;
		while (idx * 2 <= pos) {
			if (arr[idx] >= arr[idx * 2] && arr[idx] >= arr[idx * 2 + 1]) {
				break;
			}

			if (arr[idx * 2] > arr[idx * 2 + 1]) {
				swap(idx, idx * 2);
				idx *= 2;
			} else {
				swap(idx, idx * 2 + 1);
				idx = idx * 2 + 1;
			}
		}
	}

	private void swap(int n1, int n2) {
		int tmp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = tmp;
	}

}

public class MaxHeap {
	public static void main(String[] args) {
		맥스힙 heap = new 맥스힙();
		heap.offer(3);
		heap.offer(6);
		heap.offer(4);
		heap.offer(2);
		heap.offer(7);
		heap.offer(5);
		heap.print();

		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());

	}
}
