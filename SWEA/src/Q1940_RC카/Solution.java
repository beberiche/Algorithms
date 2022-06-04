package Q1940_RC카;

//import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int ans;

    public static void main(String[] args) throws Exception {
	// System.setIn(new FileInputStream("./data/input1940.txt"));
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int TC = 1; TC <= T; TC++) {
	    int N = sc.nextInt(); // 커맨드 개수

	    int dist = 0; // 거리
	    int speed = 0; // 속도
	    for (int i = 0; i < N; i++) {
		int com = sc.nextInt();
		if (com == 0) { // 현상 유지 시에는 그냥 지금의 스피드를 더해준다.
		    dist += speed;
		    continue;
		}

		if (com == 1) { // 가속시에는 가속한 만큼 스피드 값을 더해주고,
				// 해당 스피드 만큼 거리를 더해준다.
		    int accel = sc.nextInt();
		    speed += accel;
		    dist += speed;
		    continue;
		}

		if (com == 2) {
		    // 감속시에는 감속한 만큼 스피드 값을 빼주고,
		    // 해당 스피드 만큼 거리를 더해준다.
		    // 단 감속 만큼 뺀 스피드 값이 음수이면
		    // 스피드는 0이 되게 한다.
		    int decel = sc.nextInt();
		    speed -= decel;
		    if (speed < 0) {
			speed = 0;
		    }
		    dist += speed;
		    continue;
		}
	    }

	    System.out.printf("#%d %d\n", TC, dist);
	}

    }
}
