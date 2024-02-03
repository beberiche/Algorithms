package selection_sort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// 오름차순
		int[] arr = {5, 4, 3, 2, 1};

		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
						minIdx = j;
				 }
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
			System.out.println(Arrays.toString(arr));
		}
		// [1, 4, 3, 2, 5]
		// [1, 2, 3, 4, 5]
		// [1, 2, 3, 4, 5]
		// [1, 2, 3, 4, 5]
		// [1, 2, 3, 4, 5]

		// 내림차순
		int[] arr2 = {1,2,3,4,5};
		for(int i=0; i < arr2.length; i++) {
			int minIdx = i;
			for(int j= i+1; j<arr2.length; j++) {
				if(arr2[j] > arr2[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr2[minIdx];
			arr2[minIdx] = arr2[i];
			arr2[i] = temp;
			System.out.println(Arrays.toString(arr2));
		}
		// [5, 2, 3, 4, 1]
		// [5, 4, 3, 2, 1]
		// [5, 4, 3, 2, 1]
		// [5, 4, 3, 2, 1]
		// [5, 4, 3, 2, 1]
	}
}
