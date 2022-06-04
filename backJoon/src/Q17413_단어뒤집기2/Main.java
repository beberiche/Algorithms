package Q17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String str = br.readLine();

	StringBuilder result = new StringBuilder();
	for (int i = 0; i < str.length(); i++) {
	    char ch = str.charAt(i);

	    if (ch == '<') {
		int idx = i;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
		    if (idx == str.length() || str.charAt(idx) == '>') {
			sb.append(str.charAt(idx));
			break;
		    }
		    sb.append(str.charAt(idx));
		    idx++;
		    cnt++;
		}
		result.append(sb);
		i += cnt;
		continue;
	    } else {
		int idx = i;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
		    if (idx == str.length() || str.charAt(idx) == ' ' || str.charAt(idx) == '<') {
			break;
		    }
		    sb.append(str.charAt(idx));
		    idx++;
		    cnt++;
		}
		if (idx == str.length()) {
		    result.append(sb.reverse());
		    break;
		}
		if (str.charAt(idx) == '<') {
		    result.append(sb.reverse());
		    i += cnt - 1;
		    continue;
		}
		i += cnt;
		result.append(sb.reverse()).append(' ');
	    }
	}
	System.out.println(result.toString().trim());
    }
}
