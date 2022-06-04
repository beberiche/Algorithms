package Q13300_방배정;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int students = sc.nextInt();
	int capacity = sc.nextInt();
	int rooms = 0;
	int[] grade = new int[students]; // 학년 값을 넣어 놓는 배열
	int[] gender = new int[students]; // 성별 값을 넣어 놓는 배열

	for (int i = 0; i < students; i++) {
	    gender[i] = sc.nextInt();
	    grade[i] = sc.nextInt();
	}

	// 1학년 부터 6학년 까지 반복
	// 각 학년별 남학생 여학생의 수 카운트
	for (int i = 1; i <= 6; i++) {
	    for (int j = 0; j < 2; j++) { // 0 : 여학생, 1: 남학생
		int cnt = 0;
		for (int k = 0; k < students; k++) {
		    if (grade[k] == i && gender[k] == j) { // i학년의 j 성별을 가진 학생이라면 카운트
			cnt++;
		    }
		}
		if (cnt == 0) // 한명도 없다면 다음 단계로
		    continue;
		// 누군가 있다면 필요한 방은
		// 사람 수 / 수용인원
		// 나누어 떨어지면, 몫 만큼의 방이
		// 나머지가 존재한다면, 몫 +1 만큼의 방이 필요하다.
		rooms += cnt % capacity == 0 ? cnt / capacity : cnt / capacity + 1;
	    }
	}

	System.out.println(rooms);
    }

}
