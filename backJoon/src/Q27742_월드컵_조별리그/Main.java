package Q27742_월드컵_조별리그;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private class Team implements Comparable<Team> {
		long 승점;
		long 골득실;
		long 다득점;
		long 상대전적;

		@Override
		public int compareTo(Team o) {
			if (this.승점 == o.승점) {
				if (this.골득실 == o.골득실) {
					if (this.다득점 == o.다득점) return Long.compare(this.상대전적, o.상대전적);
					return Long.compare(o.다득점, this.다득점);
				}
				return Long.compare(o.골득실, this.골득실);
			}
			return Long.compare(o.승점, this.승점);
		}
	}

	private Team teams[];
	private int teamCnt = 4, team1, team2; // 팀 T, 팀 T의 상대팀;
	private long K, table[][], ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans > K ? -1 : ans);
	}

	private void solve() {
		long l = 0;
		long r = K;

		ans = Long.MAX_VALUE;
		while (l <= r) {
			long mid = (l + r) / 2;

			if (go(mid)) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
	}

	private boolean go(long mid) {
		Team tmp[] = copy(teams, teamCnt);

		Team t1 = tmp[team1];
		Team t2 = tmp[team2];

		if (mid > table[team2][team1]) {
			t1.승점 += 3;
		} else if (mid < table[team2][team1]) {
			t2.승점 += 3;
		} else {
			t1.승점++;
			t2.승점++;
		}

		t1.골득실 += mid;
		t2.골득실 -= mid;

		t1.다득점 += mid;

		Arrays.sort(tmp);
		if (tmp[0].상대전적 == t1.상대전적 || tmp[1].상대전적 == t1.상대전적)
			return true;
		return false;
	}

	private Team[] copy(Team[] teams, int teamCnt) {
		Team ret[] = new Team[teamCnt];
		for (int i = 0; i < teamCnt; i++) {
			ret[i] = new Team();
			ret[i].승점 = teams[i].승점;
			ret[i].골득실 = teams[i].골득실;
			ret[i].다득점 = teams[i].다득점;
			ret[i].상대전적 = teams[i].상대전적;
		}

		return ret;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(stk.nextToken()) - 1;

		K = Long.parseLong(stk.nextToken());

		teams = new Team[teamCnt];

		table = new long[teamCnt][teamCnt];
		team1 = T;
		for (int i = 0; i < teamCnt; i++) {
			stk = new StringTokenizer(br.readLine());
			teams[i] = new Team();
			for (int j = 0; j < teamCnt; j++) {
				table[i][j] = Long.parseLong(stk.nextToken());
				if (table[i][j] == -1) {
					team2 = j;
				}
			}
			teams[i].상대전적 = i;
		}


		for (int i = 0; i < teamCnt; i++) {
			for (int j = 0; j < teamCnt; j++) {
				if (i == j) continue;

				long score1 = table[i][j];

				if (score1 == -1) continue;

				teams[i].골득실 += score1;
				teams[j].골득실 -= score1;

				teams[i].다득점 += score1;


				long score2 = table[j][i];

				if (score2 == -1) continue;


				if (score1 > score2) {
					teams[i].승점 += 3;
				} else if (score1 == score2) {
					teams[i].승점++;
				}
			}
		}
	}
}
