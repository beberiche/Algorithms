package 석유_시추;

import java.util.*;
class Solution {
	// bfs로 각 구역별 석유 갯수 구하기
	// 세로 형태로 탐색하며, 해당 구역에 들어오는 경우, 합산
	private static int N,M,map[][];
	private static List<Integer> oils;
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,-1,0,1};
	public int solution(int[][] land) {
		int answer = 0;
		N = land.length;
		M = land[0].length;

		oils = new ArrayList<>();

		map = land;
		// 2번부터
		int zone = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					bfs(i,j, ++zone);
				}
			}
		}



		boolean visited[] = new boolean[oils.size()];
		for(int i=0; i<M; i++) {
			Arrays.fill(visited, false);
			int ret = 0;
			for(int j=0; j<N; j++) {
				if(map[j][i] > 1 && !visited[map[j][i]-2]) {
					visited[map[j][i]-2] = true;
					ret+=oils.get(map[j][i] - 2);
				}
			}
			answer = Math.max(answer, ret);
		}

		return answer;
	}

	private void bfs(int r, int c, int zone) {
		Queue<int[]> q = new LinkedList<>();

		int cnt = 0;
		q.add(new int[] {r,c});
		map[r][c] = zone;
		while(!q.isEmpty()) {
			int[] curr =q.poll();
			cnt++;

			for(int d=0; d<4; d++) {
				int nr = curr[0] +dr[d];
				int nc = curr[1] +dc[d];

				if(nr < 0 || nc < 0 || nr>=N || nc>=M) continue;
				if(map[nr][nc] != 1) continue;

				map[nr][nc] = zone;
				q.add(new int[] {nr,nc});
			}
		}
		oils.add(cnt);
	}
}