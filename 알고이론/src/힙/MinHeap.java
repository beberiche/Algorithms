package 힙;

import java.util.Arrays;

class 민힙 {
	int pos;
	int[] arr;

	// 생성자 만들기
	민힙() {
		this(10);
	}

	민힙(int size) {
		arr = new int[size + 1];
		init();
	}

	// isEmpty
	public boolean isEmpty() {
		return pos == 0;
	}

	// 배열 초기화
	public void init() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = 1000;
			}
		}
	}

	// isFull
	public boolean isFull() {
		return pos == arr.length - 1;
	}

	// offer
	public void offer(int n) {
		// 칸 없다면 채워주기
		if (isFull()) {
			arr = Arrays.copyOf(arr, arr.length * 2);
			init();
		}

		// 넣어주기
		arr[++pos] = n;

		// 이후 정렬하기
		int idx = pos;
		while (idx > 1) {
			// 부모보다 자식값이 더 크다면 그냥 가만히 있자!
			if (arr[idx] < arr[idx / 2]) {
				// swap 해야지
				swap(idx, idx / 2);
			}
			// 루트에 도달할 때 까지 계속 /2
			idx /= 2;
		}
	}

	// swap
	private void swap(int idx1, int idx2) {
		// 부모의 자식을 바꾼다.
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// poll
	public int poll() {
		// 일단 더이상 없는지 확인
		if (isEmpty()) {
			return -1;
//			System.out.println("더이상 없어!! 텅 비었어!!");
		}
		// idx와 맞추려 1을 더했다
		// 따라서 root 인덱스는 1이지
		int temp = arr[1];
		arr[1] = arr[pos];
		arr[pos--] = 1000;

		heapify();
		return temp;
	}

	// print
	public void print() {
		System.out.println(Arrays.toString(arr));
	}

	// heapify
	public void heapify() {
		int idx = 1;
		while (idx * 2 <= pos) {
			if (arr[idx] <= arr[idx * 2] && arr[idx] <= arr[idx * 2 + 1]) {
				break;
			}

			if (arr[idx * 2] < arr[idx * 2 + 1]) {
				swap(idx, idx * 2);
				idx *= 2;
			} else {
				swap(idx, idx * 2 + 1);
				idx = idx * 2 + 1;
			}
		}
	}

}

public class MinHeap {
	public static void main(String[] args) {
		민힙 heap = new 민힙();
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
