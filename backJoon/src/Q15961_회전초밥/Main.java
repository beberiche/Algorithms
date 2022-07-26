package Q15961_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());

		int[] sushi = new int[N + k - 1]; // 총 스시
		int[] mine = new int[d + 1]; // 내가 이제 먹는 스시
		
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine());

		for (int i = N; i < sushi.length; i++)
			sushi[i] = sushi[i - N];

		int max = 0, eat = 0;

		for (int i = 0; i < k; i++)
			if (mine[sushi[i]]++ == 0)
				eat++;

		max = Math.max(mine[c] == 0 ? eat + 1 : eat, max);

		int st = 0;
		int ed = k;
		for (int i = 1; i < N; i++) {
			if (--mine[sushi[st++]] == 0)
				eat--;
			if (mine[sushi[ed++]]++ == 0)
				eat++;
			max = Math.max(mine[c] == 0 ? eat + 1 : eat, max);
		}
		System.out.println(max);

	}
}
