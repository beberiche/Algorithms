package Q1865_동철이의일분배;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static double[] sel;
	static double[][] work;
	static boolean[] visited;
	static int N;
	static double max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			work = new double[N+1][N+1];
			StringTokenizer st;
			for(int i=1;i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					work[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}
			
			max = 0;
			visited = new boolean[N+1];
			sel = new double[N+1];
			perm(1, 1.0);
			System.out.printf("#%d %.6f", t,max);
			System.out.println();
		}
	}
	
	public static void perm(int idx, double per) {
		if(idx== N+1) {
			max = Math.max(max, per * 100);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				continue;
			}
			
			sel[idx] = work[i][idx];
			
			if(per * sel[idx] < max/100 || per * sel[idx] == 0) 
				continue;
			
			visited[i] = true;
			perm(idx+1, per * work[i][idx]);
			visited[i] = false;
		}
	}
}
