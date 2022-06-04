package Q4789_성공적인공연기획;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input4789.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			char[] audience = sc.next().toCharArray();

			int person = audience[0] - '0'; // 처음에 박수치는 사람
			int need = 0; // 필요한 사람
			for (int i = 1; i < audience.length; i++) {
				// 청중 가운데 누군가 일어나면 박수를 칠 사람이 존재하는데
				// 사람이 부족하다면...
				if (audience[i] != 0 && person < i) {
					need += (i - person); // 필요한 사람 넣어주고
					person += (i - person); // 그만큼 총인원에도 넣어주고
				}
				// 그리고 영향을 받아 박수를 치게 되는 사람도 카운트
				person += (audience[i] - '0');
			}

			System.out.printf("#%d %d\n", TC, need);
		}
	}
}
