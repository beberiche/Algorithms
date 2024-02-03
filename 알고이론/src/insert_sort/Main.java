package insert_sort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };

		// 0번 인덱스는 정렬이 되어있어~~
		for (int i = 1; i < data.length; i++) {
			int key = data[i]; // 이번에 정렬할 값
			int j; // 정렬할 위치

			// 뒤로 밀면서 위치 확보
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j + 1] = data[j];
			}

			// j라는 위치에 넣어야 할 거 같은데...
			// 마지막에 한번 깎여버림
			data[j + 1] = key;

			System.out.println(Arrays.toString(data));
		}
	}
}

//[10, 69, 30, 2, 16, 8, 31, 22]
//[10, 30, 69, 2, 16, 8, 31, 22]
//[2, 10, 30, 69, 16, 8, 31, 22]
//[2, 10, 16, 30, 69, 8, 31, 22]
//[2, 8, 10, 16, 30, 69, 31, 22]
//[2, 8, 10, 16, 30, 31, 69, 22]
//[2, 8, 10, 16, 22, 30, 31, 69]