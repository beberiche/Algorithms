package Q17478_재귀함수가뭔가요;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		solve(n, 0);
	}

	private static void solve(int n, int cnt) {
		StringBuilder sb1 = new StringBuilder("\"재귀함수가 뭔가요?\"");
		StringBuilder sb2 = new StringBuilder("라고 답변하였지.");
		StringBuilder sb3 = new StringBuilder("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		StringBuilder sb4 = new StringBuilder("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		StringBuilder sb5 = new StringBuilder("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		StringBuilder sb6 = new StringBuilder("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		for (int i = 0; i < cnt; i++) {
			sb1.insert(0, "____");
			sb2.insert(0, "____");
			sb3.insert(0, "____");
			sb4.insert(0, "____");
			sb5.insert(0, "____");
			sb6.insert(0, "____");
		}

		System.out.println(sb1);
		if (cnt == n) {
			System.out.println(sb3);
			System.out.println(sb2);
			return;
		}

		System.out.println(sb4);
		System.out.println(sb5);
		System.out.println(sb6);

		solve(n, ++cnt);
		System.out.println(sb2);
	}
}
