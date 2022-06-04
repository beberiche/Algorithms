package Q22348_헬기착륙창;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int mod = ((int) Math.pow(10, 9)) + 7;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (--T >= 0) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());

			recur(red, blue, 1);
			System.out.println(ans % mod);
		}
	}

	public static void recur(int red, int blue, int d) {
		if (red < 0 && blue < 0) {
			return;
		}

		if (red - d >= 0) {
			ans++;
			recur(red - d, blue, d + 1);
		}

		if (blue - d >= 0) {
			ans++;
			recur(red, blue - d, d + 1);
		}

	}
}
