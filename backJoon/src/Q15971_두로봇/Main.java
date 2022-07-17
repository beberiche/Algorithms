package Q15971_두로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int to;
	int dist;
	
	public Node(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stn.nextToken());
		int RobotALoc = Integer.parseInt(stn.nextToken());
		int RobotBLoc = Integer.parseInt(stn.nextToken());
		ArrayList<Node>[] adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			stn = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stn.nextToken());
			int ed = Integer.parseInt(stn.nextToken());
			int dist = Integer.parseInt(stn.nextToken());
			
			adjList[st].add(new Node(ed, dist));
			adjList[ed].add(new Node(st, dist));
		}
		
		PriorityQueue<int []> pq = new PriorityQueue<>((n1,n2)-> n1[1]-n2[1]);
		boolean[] visited = new boolean[N+1];
		visited[RobotALoc] = true;
		pq.add(new int[] {RobotALoc, 0,0});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			if(curr[0] == RobotBLoc) {
				System.out.println(curr[1]-curr[2]);
				return;
			}
			
			for(Node next : adjList[curr[0]]) {
				if(visited[next.to])
					continue;
				
				visited[next.to] = true;
				pq.add(new int [] {next.to, curr[1]+next.dist,  curr[2] >= next.dist ? curr[2] : next.dist});
			}
		}
	}
}
