package Q9205_맥주마시면서걸어가기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int T = sc.nextInt();
//
//		while (--T >= 0) {
//			int N = sc.nextInt(); // 편의점 갯수
//			int[][] map = new int[N + 2][2];
//
//			for (int i = 0; i < N + 2; i++) {
//				int x = sc.nextInt();
//				int y = sc.nextInt();
//				map[i] = new int[] { x, y };
//			}
//			
//			BFS(map, N);
//		}
//	}
//
//	private static void BFS(int[][] map, int N) {
//		// TODO Auto-generated method stub
//		Queue<int[]> q = new LinkedList<>();
//		boolean[] visited = new boolean[N];
//		q.add(new int[] {map[0][0], map[0][1]});
//		while(!q.isEmpty()) {
//			int[] pos = q.poll();
//			if(Math.abs(map[N+1][0] -pos[0]) + Math.abs(map[N+1][1] -pos[1]) <= 1000) {
//				System.out.println("happy");
//				return;
//			}
//			
//			for(int i=1; i<=N; i++) {
//				if(visited[i-1]) 
//					continue;
//				if(Math.abs(pos[0] - map[i][0]) + Math.abs(pos[1]-map[i][1]) <= 1000) {
//					visited[i-1] = true;
//					q.add(new int[] {map[i][0], map[i][1]});
//				}
//			}
//		}
//		System.out.println("sad");	
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (--T >= 0) {
			int N = sc.nextInt(); // 편의점 갯수
			int[][] map = new int[N + 2][2];

			for (int i = 0; i < N + 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[i] = new int[] { x, y };
			}

			Arrays.sort(map, (o1, o2) -> {
				if (Math.abs(o1[0]) == Math.abs(o2[0]))
					return Math.abs(o1[1]) - Math.abs(o2[1]);
				return Math.abs(o1[0]) - Math.abs(o2[0]);
			});
			
			for(int i=0; i<N+2; i++) {
				int dist1 = Math.abs(map[N+1][0] - map[i][0]) + Math.abs(map[N+1][1] - map[i][1]);
				if(dist1 <= 1000) {
					System.out.println("happy");
					break;
				} else {
					boolean check = false;
					for(int j=i+1; j<N+2; j++) {
						int dist2 = Math.abs(map[j][0] - map[i][0]) + Math.abs(map[j][1] - map[i][1]);
						if(dist2 <= 1000) {
							check = true;
							break;
						}
					}
					if(!check) {
						System.out.println("sad");
						break;
					}
				}
			}
		}
	}
}
