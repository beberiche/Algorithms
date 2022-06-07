package Q1761_숫자야구;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int N;
	static List<Integer> ans = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}

		for (int n = 123; n <= 999; n++) {
			if ((n + "").contains("0"))
				continue;

			char[] temp = (n + "").toCharArray();
			if (temp[0] == temp[1] || temp[1] == temp[2] || temp[2] == temp[0]) 
				continue;
			
			check(temp);
		}
		
		System.out.println(ans.size());
	}

	private static void check(char[] num) {
		// TODO Auto-generated method stub
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			char[] comp = (arr[i][0] + "").toCharArray();

			int strike = 0;
			int ball = 0;
			// 스트라이크 찾기
			if (comp[0] == num[0]) {
				strike++;
			}
			if (comp[1] == num[1]) {
				strike++;
			}
			if (comp[2] == num[2]) {
				strike++;
			}

			// 볼 찾기
			String compStr = "" + comp[0] + comp[1] + comp[2];
			if (comp[0] != num[0] && compStr.contains(num[0] + "")) {
				ball++;
			}
			if (comp[1] != num[1] && compStr.contains(num[1] + "")) {
				ball++;
			}
			if (comp[2] != num[2] && compStr.contains(num[2] + "")) {
				ball++;
			}

			if (arr[i][1] == strike && arr[i][2] == ball) {
				continue;
			} else {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			ans.add(Integer.parseInt(""+num[0]+num[1]+num[2]));
		}
	}
}
