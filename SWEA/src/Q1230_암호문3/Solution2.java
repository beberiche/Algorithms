package Q1230_암호문3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	Node prev;
	int val;
	Node next;

	Node(int val) {
		this.val = val;
	}
}

public class Solution2 {
	// 헤더
	// - prev = null
	// 테일
	// - next = null

	// 삽입
	// - x번쨰 "다음" 부터 삽입
	//  - 주어진 입력 암호문끼리 미리 prev,next 연결
	//  - x번째 노드와 맨앞 입력 노드 연결
	//  - x+y번째 노드와 맨뒤 입력 노드 연결
	// - 헤더 삽입의 경우
	//  - 해당 경우 존재하지 않음
	// - 테일 삽입의 경우
	//  - 테일의 next -> 맨 앞 입력 노드
	//  - 입력의 맨뒤 노드 -> 테일로 변환

	// 삭제
	// - x번째 "다음" 부터 y개 삭제
	// - 헤더 삭제의 경우
	//  - 기존 삭제 이벤트와 동일
	// - 테일 삭제의 경우
	//  - 해당 경우 존재하지 않음

	// 추가
	// - 테일에 입력 노드 추가
	private static Node head, tail;
	private static final int SIZE = (int) 1e7 + 4;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer stk;
	private static int N, M, length;


	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		length = N;

		Node prev = new Node(Integer.parseInt(stk.nextToken()));
		Node curr = new Node(Integer.parseInt(stk.nextToken()));
		head = prev;
		Node next = null;
		for (int i = 2; i < N; i++) {
			next = new Node(Integer.parseInt(stk.nextToken()));
			connectNode(prev, curr, next);
			prev = curr;
			curr = next;
		}
		tail = next;
	}

	private static void go() throws Exception {
		M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			char cmd = stk.nextToken().charAt(0);
			if (cmd == 'I') {
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				cmdI(x, y);
			} else if (cmd == 'D') {
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				cmdD(x, y);
			} else if (cmd == 'A') {
				int y = Integer.parseInt(stk.nextToken());
				cmdA(y);
			}
		}

	}

	private static void cmdI(int x, int y) {
		Node start = x <= length / 2 ? findFromHead(x) : findFromTail(length - x - y);

		if (start == tail) {
			cmdA(y);
			return;
		}

		if (start != null) {
			Node curr = start;
			Node end = start.next;
			for (int i = 0; i < y; i++) {
				Node next = new Node(Integer.parseInt(stk.nextToken()));
				connectHead(curr, next);
				curr = next;
			}
			connectHead(curr, end);
		} else {
			Node tmp = new Node(Integer.parseInt(stk.nextToken()));
			Node curr = tmp;
			for (int i = 1; i < y; i++) {
				Node next = new Node(Integer.parseInt(stk.nextToken()));
				connectHead(curr, next);
				curr = next;
			}
			curr.next = head;
			head.prev = curr;
			head = tmp;
		}
		length += y;
	}

	private static void cmdD(int x, int y) {
		Node start = x <= length / 2 ? findFromHead(x) : findFromTail(length - x - y);
		Node end = findFromNode(start, y);

		if (end != null) connectHead(start, end);
		else {
			start.next = null;
			tail = start;
		}
		length -= y;
	}

	private static void cmdA(int y) {
		Node prev = tail;

		for (int i = 0; i < y; i++) {
			Node curr = new Node(Integer.parseInt(stk.nextToken()));
			connectHead(prev, curr);
			prev = curr;
		}
		tail = prev;
		length += y;
	}


	private static Node findFromHead(int idx) {
		if (idx == 0) {
			return null;
		}
		Node node = head;
		for (int i = 1; i < idx; i++) {
			node = node.next;
		}
		return node;
	}


	private static Node findFromTail(int idx) {
		if (idx == 0) {
			return tail;
		}
		Node node = tail;
		for (int i = 0; i < idx; i++) {
			node = node.prev;
		}
		return node;
	}

	private static Node findFromNode(Node node, int idx) {
		for (int i = 0; i < idx + 1; i++) {
			node = node.next;
		}
		return node;
	}

	private static void connectHead(Node prev, Node curr) {
		curr.prev = prev;
		prev.next = curr;
	}

	private static void connectTail(Node curr, Node next) {
		curr.next = next;
		next.prev = curr;
	}

	private static void connectNode(Node prev, Node curr, Node next) {
		connectHead(prev, curr);
		connectTail(curr, next);
	}

	private static String output() {
		Node curr = head;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(curr.val).append(" ");
			curr = curr.next;
		}
		return sb.toString();
	}


	public static void main(String[] args) throws Exception {
		int T = 10;
		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			init();
			go();
			output();
			ans.append("#").append(t).append(" ").append(output()).append("\n");
		}
		System.out.println(ans.toString());
	}
}
