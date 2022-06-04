package 이진검색;

public class lower_upper {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 7, 9, 9, 9, 9, 9 };

		System.out.println(lowerBound(arr, 9, arr.length));
		System.out.println(upperBound(arr, 9, arr.length));
	}

	private static int lowerBound(int[] arr, int target, int length) {
		int mid, st, ed;
		st = 0;
		ed = length;

		while (ed > st) {
			mid = (st + ed) / 2;
			if (arr[mid] >= target) {
				ed = mid;
			} else {
				st = mid + 1;
			}
		}
		return ed;
	}

	private static int upperBound(int[] arr, int target, int length) {
		int mid, st, ed;
		st = 0;
		ed = length - 1;
		while (ed > st) {
			mid = (st + ed) / 2;
			if (arr[mid] <= target) {
				st = mid + 1;
			} else {
				ed = mid;
			}
		}
		return ed;
	}

}
