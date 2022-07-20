package Q16928_뱀과사디리게임;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[101][1];

		
		int N = sc.nextInt(); // 사다리
		int M = sc.nextInt(); // 뱀

		for (int i = 0; i < N; i++) {
			map[sc.nextInt()][0] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			map[sc.nextInt()][0] = sc.nextInt();
		}

		boolean[] visited = new boolean[101];
		Queue<int[]> q = new LinkedList<>();
		// 사다리 인덱스, 주사위 굴린 횟수
		q.add(new int[] { 1, 0 });
		visited[1] = true;
		int ans = 100;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == 100) {
				ans = curr[1];
				break;
			}
			for (int d = 1; d <= 6; d++) {
				int nd = curr[0] + d;
				
				if(nd > 100) 
					break;
				
				if(visited[nd])
					continue;
				
				if(map[nd][0] > 0) {
					q.add(new int[] {map[nd][0], curr[1]+1});
					visited[map[nd][0]] = true;
				} else {
					q.add(new int[] {nd, curr[1]+1});
					visited[nd] = true;
				}
			}
		}
		System.out.println(ans);

	}
}