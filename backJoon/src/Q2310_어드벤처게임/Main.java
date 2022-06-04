package Q2310_어드벤처게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	char font; // 해당 글자
	int money; // 지불해야하는 혹은 충전되는 돈
	List<Integer> door = new ArrayList<>(); // 나아가는 공간

	public Node(char font, int money) {
		this.font = font;
		this.money = money;
	}

	public void next(int d) {
		door.add(d);
	}
}

public class Main {
	static List<Node> list;
	static boolean visited;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new ArrayList();

		int T = N;
		while (--T >= 0) {
			char[] arr = sc.next().replace(" ", "").toCharArray();
			Node node = new Node(arr[0], arr[1] - '0');
			for (int i = 1; i < arr.length; i++)
				node.next(arr[i] - '0');
			list.add(node);
		}

		int currMoney = 0;
		dfs(0, currMoney);

		System.out.println(flag ? "Yes" : "No");
	}

	private static void dfs(int idx, int currM) {

		Node currMaze = list.get(idx);

		int money = currM;

		if (currMaze.font == 'L') {
			money = currM < currMaze.money ? currM : currMaze.money;
			for (int i = 0; i < currMaze.door.size(); i++) {
				if (currMaze.door.get(i) != -1)
					dfs(currMaze.door.get(i), money);
				currMaze.door.set(i, -1);
			}
		} else if (currMaze.font == 'E') {
			for (int i = 0; i < currMaze.door.size(); i++) {
				if (currMaze.door.get(i) != -1)
					dfs(currMaze.door.get(i), money);
				currMaze.door.set(i, -1);
			}
		} else {
			money -= currMaze.money;
			for (int i = 0; i < currMaze.door.size(); i++) {
				if (currMaze.door.get(i) != -1)
					dfs(currMaze.door.get(i), money);
				currMaze.door.set(i, -1);
			}
		}

		if (idx == list.size() - 1 && money > 0) {
			flag = true;
			return;
		}
	}
}
