package Q2776_암기왕_이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int TC = Integer.parseInt(br.readLine());

	for (int t = 0; t < TC; t++) {
	    int n1 = Integer.parseInt(br.readLine());
	    HashMap<Integer, Boolean> note1 = new HashMap<>();

	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < n1; i++) {
		note1.put(Integer.parseInt(st.nextToken()), true);
	    }

	    int n2 = Integer.parseInt(br.readLine());

	    st = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < n2; i++) {
		if (note1.containsKey(Integer.parseInt(st.nextToken()))) {
		    sb.append(1 + "\n");
		} else {
		    sb.append(0 + "\n");
		}
	    }
	    System.out.print(sb);
	}
    }
}
