package Q3985_롤케이크;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int[] rollCake = new int[sc.nextInt() + 1];

	int audience = sc.nextInt();

	// 많이 가져갈 거라 예상되는 방청객 -> 번호의 시작과 끝의 차이가 가장 큰 방청객
	// 많이 가져가는 방청객 -> cnt 수가 많은 방청객;
	int maxDiff = 0; // 방청객 가운데 최대로 가져가는 양
	int potentialNum = 0; // 최대로 가져갈 거라 예상되는 방청객의 번호
	for (int i = 1; i <= audience; i++) {
	    int st = sc.nextInt();
	    int ed = sc.nextInt();
	    for (int c = st; c <= ed; c++) {
		if (rollCake[c] == 0) {
		    rollCake[c] = i; // 해당 인덱스에 다른 번호가 표시되어있다면 건드리지 않는다.
		}
		int diff = ed - st; // 해당 방청객이 가져가는 분량
		if (diff >= maxDiff) { // 만약 더 큰 양을 가져가려는 분이 나타났다면
		    if (maxDiff == diff && potentialNum < i) { // 현재 표기된 최대로 가져가는 양과 동일하면서도 해당 방청객 번호가 뒤라면
			continue; // 그냥 넘어간다
		    }
		    // 아닌경우에는 값을 바꿔준다.
		    maxDiff = diff;
		    potentialNum = i;
		}
	    }
	}

	// 실제 많이 가져가는 사람 찾기
	// 롤케익에 표기한 번호만큼 카운트하기
	// 중복되는 경우 앞번호인 사람을 출력하기 위해
	// 뒤에서 부터 시작
	int maxAudi = 0;
	int maxCount = 0;
	for (int i = audience; i >= 1; i--) {
	    int cnt = 0;
	    for (int j = rollCake.length - 1; j >= 1; j--) {
		if (rollCake[j] == i) {
		    cnt++;
		}
	    }
	    if (maxCount <= cnt) {
		maxCount = cnt;
		maxAudi = i;
	    }

	}

	System.out.println(potentialNum);
	System.out.println(maxAudi);
    }
}
