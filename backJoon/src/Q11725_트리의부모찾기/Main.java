package Q11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 단순 반복이나 트리만으론 답이 안나와서
// 구글링하다가 BFS, DFS로 가능하다길래 DFS영상 보고 다시 만들었습니다.
// 혹시 BFS, DFS 외의 풀이법이 있으신 분은 나중에 시간되실때 알려주세요!

class Node {
	List<Integer> parent = new ArrayList<>();
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		// 노드를 담는 배열
		Node[] tree = new Node[N + 1];

		// 노드 생성
		for (int i = 1; i < tree.length; i++) {
			tree[i] = new Node();
		}

		// 추가하기
		// 해당 입력에서 어떤게 부모가 어떤 게 자식인지 정해지지 않았다.
		// 처음이 부모가 될 수도 있고 반대가 될 수도 있으니
		// 모든 경우의 수를 탐색하기 위해
		// 부모-자식 / 자식 - 부모 모두 넣어주자
		for (int i = 2; i < tree.length; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			tree[n1].parent.add(n2);
			tree[n2].parent.add(n1);
		}

		// 루트 부터 자식 노드로 순회
		// 부모노드 가운데 이전에 방문했던 곳이 아닌경우 해당 노드가 부모 노드 이다.
		// parent 배열에 자식 인덱스에 맞게 저장.
		boolean[] visited = new boolean[N + 1];
		int[] parent = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int val = q.poll();
			for (int n : tree[val].parent) {
				if (!visited[n]) {
					visited[n] = true;
					q.add(n);
					parent[n] = val;
				}
			}
		}

		// 출력
		for (int i = 2; i < parent.length; i++)
			System.out.println(parent[i]);

	}
}
