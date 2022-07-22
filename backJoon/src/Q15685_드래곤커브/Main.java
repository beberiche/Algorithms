package Q15685_드래곤커브;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] map = new int[101][101];

		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };

		while (--N >= 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();

			List<Integer> list = new ArrayList<>();
			list.add(d);
			// 총 방향 집어넣기
			for (int i = 0; i < g; i++) {
				int size = list.size();
				for(int j=size-1; j>=0; j--) {
					int currD = list.get(j);
					if(currD == 3) {
						list.add(0);
					} else {
						list.add(currD+1);
					}
				}
			}
			
			map[y][x] = 1;
			for(int i=0; i<list.size(); i++) {
				int nr = y + dr[list.get(i)];
				int nc = x + dc[list.get(i)];
				
				map[nr][nc] = 1;
				y=nr;
				x=nc;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1) 
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
