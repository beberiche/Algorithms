package 부분집합;

public class PowerSet1 {
	// 비트마스킹을 이용한 powerset 작성해보기
	public static void main(String[] args) {
		int[] data = new int[] { 1, 2, 3, 4, 5 };
		int N = data.length;
		int count = 0;
		// 전체 경우의 수 판단.
		for (int i = 1; i < (1 << N); i++) {
			// 해당 i라는 부분집합에 판단.
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) > 0) {
					System.out.print(data[j] + " ");
				}
				count++;
			}
			System.out.println("지금까지 : " + count);
		}
	}

}
