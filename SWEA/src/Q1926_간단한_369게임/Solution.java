package Q1926_간단한_369게임;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
//	System.setIn(new FileInputStream("./data/input1926.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int T = Integer.parseInt(br.readLine());

	String[] arr = new String[T];
	for (int i = 0; i < T; i++) {
	    arr[i] = (i + 1) + "";
	}

	for (int i = 0; i < T; i++) {
	    String n = arr[i];
	    int cnt = clap(n);

	    if (cnt == 3) {
		arr[i] = "---";
	    } else if (cnt == 2) {
		arr[i] = "--";
	    } else if (cnt == 1) {
		arr[i] = "-";
	    } else {
		continue;
	    }
	}

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < T; i++) {
	    sb.append(arr[i]).append(" ");
	}

	System.out.println(sb);
    }

    private static int clap(String n) {
	int clap = 0;

	if (n.length() >= 2) {
	    char[] temp = n.toCharArray();
	    for (int j = 0; j < n.length(); j++) {
		if (temp[j] == '3' || temp[j] == '6' || temp[j] == '9') {
		    clap++;
		}
	    }
	} else {
	    if (n.equals("3") || n.equals("6") || n.equals("9")) {
		clap++;
	    }
	}

	return clap;
    }
}
