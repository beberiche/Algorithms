package Q1244_스위치_켜고_끄기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	int[] switches = new int[N + 1];

	StringTokenizer st = new StringTokenizer(br.readLine());
	for (int i = 1; i <= N; i++) {
	    switches[i] = Integer.parseInt(st.nextToken());
	}

	int students = Integer.parseInt(br.readLine());

	for (int i = 0; i < students; i++) {
	    st = new StringTokenizer(br.readLine());
	    boyAndGirl(switches, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}

	StringBuilder sb = new StringBuilder();
	for (int i = 1; i <= N; i++) {
	    sb.append(switches[i] + " ");
	    if (i % 20 == 0) {
		sb.append("\n");
	    }
	}
	System.out.print(sb.toString());
    }

    private static void boyAndGirl(int[] switches, int sexual, int switchNum) {
	if (sexual == 1) {
	    for (int i = switchNum; i < switches.length; i += switchNum) {
		switches[i] = switches[i] == 0 ? 1 : 0;
	    }
	} else {
	    int idx = 1;
	    switches[switchNum] = switches[switchNum] == 1 ? 0 : 1;
	    while (switchNum - idx >= 1 && switchNum + idx < switches.length) {
		if (switches[switchNum - idx] == switches[switchNum + idx]) {
		    switches[switchNum - idx] = switches[switchNum - idx] == 1 ? 0 : 1;
		    switches[switchNum + idx] = switches[switchNum + idx] == 1 ? 0 : 1;
		    idx++;
		    continue;
		}
		break;
	    }
	}
    }
}
