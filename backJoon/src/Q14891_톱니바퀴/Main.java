package Q14891_톱니바퀴;

import java.util.Scanner;

public class Main {
	static char[][] gears;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		gears = new char[4][8];

		for (int i = 0; i < 4; i++) {
			gears[i] = sc.next().toCharArray();
		}

		int N = sc.nextInt();

		while (--N >= 0) {
			int gearIdx = sc.nextInt() - 1;
			int dir = sc.nextInt();
			visited = new boolean[5];
			recur(gearIdx, dir);
		}

		int ans = 0;
		for (int i = 0; i < 4; i++) 
			if (gears[i][0] == '1') 
				ans += (int) Math.pow(2, i);
		
		System.out.println(ans);
	}

	private static void recur(int idx, int dir) {
		// TODO Auto-generated method stub
		if (idx < 0 || idx > 3)
			return;

		if (visited[idx])
			return;

		// [0] = 이전 톱니바퀴의 2 
		// [1] = 현재 톱나바퀴의 6
		// [2] = 현재 톱니바퀴의 2
		// [3] = 이전 톱니바퀴의 6
		char[] comp = storeGearIdx(idx);
		
		if (dir == 1) {
			visited[idx] = true;
			
			char last = gears[idx][7];
			for (int i = 7; i >= 1; i--) 
				gears[idx][i] = gears[idx][i - 1];
	
			gears[idx][0] = last;

			if (idx - 1 >= 0) 
				checkGear(comp[0], comp[1], idx-1, -1);
			
			if (idx + 1 <= 3) 
				checkGear(comp[2], comp[3], idx+1, -1);
			
		} else {
			visited[idx] = true;

			char first = gears[idx][0];
			for (int i = 0; i < 7; i++) 
				gears[idx][i] = gears[idx][i + 1];
			
			gears[idx][7] = first;

			if (idx - 1 >= 0) 
				checkGear(comp[0], comp[1], idx-1, 1);
			
			if (idx + 1 <= 3) 
				checkGear(comp[2], comp[3], idx+1, 1);
	
		}
	}

	public static void checkGear(int g1, int g2, int idx, int dir) {
		if (g1 != g2)
			recur(idx, dir);
		else
			visited[idx] = true;
	}
	
	public static char[] storeGearIdx(int idx) {
		char[] temp = new char[4];
		if (idx - 1 >= 0) {
			temp[0] = gears[idx - 1][2];
			temp[1] = gears[idx][6];
		}

		if (idx + 1 <= 3) {
			temp[2] = gears[idx][2];
			temp[3] = gears[idx + 1][6];
		}
		
		return temp;
	}
}
