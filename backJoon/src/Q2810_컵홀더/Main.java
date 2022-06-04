package Q2810_컵홀더;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int len = sc.nextInt();
	String seats = sc.next();

	// 좌석은 s석 아니면 LL석이다.
	// S석으로만 구성되어있다면
	// 컵홀더의 수는 좌석의 양 +1 수이고
	// 양옆에 모두 존재하기 때문에
	// 모두가 컵홀더를 쓰는 것이 가능하다.
	if (!seats.contains("LL")) {
	    System.out.println(seats.length());
	} else {
	    // LL석은 가운데 컵홀더가 존재하지 않는다.
	    // 그렇다면 LL석을 하나의 컵홀더를 가진 하나의 좌석으로 보자.
	    // 컵홀더의 수를 나타낼 수 있도록 먼저 문자를 대체 시킨 후 '*'
	    // '*'문자의 수가 사용가능한 사람의 수가 된다.
	    // 여기에 S나 LL 모두 끝문자에서는 오른쪽 컵홀더가 반드시 존재하므로
	    // 사용할 수 있는 사람은 1명 더 추가되게 된다.
	    seats = seats.replace('S', '*').replaceAll("LL", "*");
	    System.out.println(seats.length() + 1);
	}

    }
}
