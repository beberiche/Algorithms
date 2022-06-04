package Q14267_회사문화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	List<Integer> child = new ArrayList<>(); // 직속 부하들의 리스트
	int total; // 쌓이는 칭찬의 게이지
}

public class Main {
	static Node nodeArr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드의 수
		int m = Integer.parseInt(st.nextToken()); // 이벤트의 수

		nodeArr = new Node[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			nodeArr[i] = new Node();
			if (tmp != -1)
				nodeArr[tmp].child.add(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			nodeArr[Integer.parseInt(st.nextToken())].total += Integer.parseInt(st.nextToken());
		}

		DFS(1);

		for (int i = 1; i <= n; i++)
			System.out.print(nodeArr[i].total + " ");

	}

	public static void DFS(int n) {
		for (int c : nodeArr[n].child) {
			nodeArr[c].total += nodeArr[n].total;
			DFS(c);
		}
	}
}
