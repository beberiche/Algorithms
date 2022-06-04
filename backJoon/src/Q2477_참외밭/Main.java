package Q2477_참외밭;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt(); // 참외

	int[][] farm = new int[6][2];
	for (int i = 0; i < 6; i++) {
	    for (int j = 0; j < 2; j++) {
		farm[i][j] = sc.nextInt();
	    }
	}

	// 전체 넓이를 지정하기 위한
	// 남북 가운데 가장 높은 값 - height
	// 동서 가운데 가장 넓은 값 - width;
	int width = 0;
	int height = 0;
	int w = 0;
	int h = 0;
	for (int i = 0; i < 6; i++) {
	    if (farm[i][0] == 4 || farm[i][0] == 3) {
		if (height < farm[i][1]) {
		    height = farm[i][1];
		    h = farm[i][0];
		    continue;
		}
	    }
	    if (farm[i][0] == 1 || farm[i][0] == 2) {
		if (width < farm[i][1]) {
		    width = farm[i][1];
		    w = farm[i][0];
		    continue;
		}
	    }
	}

	int cutWidth = 0;
	int cutHeight = 0;
	for (int i = 0; i < 6; i++) {
	    if (farm[i][0] != w && farm[(i + 5) % 6][1] + farm[(i + 1) % 6][1] == width) {
		cutWidth = farm[i][1];
	    }
	    if (farm[i][0] != h && farm[(i + 5) % 6][1] + farm[(i + 1) % 6][1] == height) {
		cutHeight = farm[i][1];
	    }
	}

	System.out.println(((width * height) - (cutWidth * cutHeight)) * N);
    }
}
