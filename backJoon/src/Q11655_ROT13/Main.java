package Q11655_ROT13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	char[] arr = br.readLine().toCharArray();

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < arr.length; i++) {

	    // 공백 그대로 내보내기
	    if (arr[i] == ' ') {
		sb.append(" ");
		continue;
	    }

	    // 숫자인 경우 그대로 내보내기
	    if ('0' <= arr[i] && arr[i] <= '9') {
		sb.append(arr[i]);
		continue;
	    }

	    // 대문자인 경우
	    if (('A' <= arr[i] && arr[i] <= 'Z')) {
		int ch = 0;
		// 문자 26개
		// N: 13번째
		if (arr[i] < 'N') {
		    ch = arr[i] + 13;
		} else {
		    ch = arr[i] - 13;
		}
		sb.append((char) ch);
		continue;

	    }

	    // 소문자인 경우
	    if (('a' <= arr[i] && arr[i] <= 'z')) {
		int ch = 0;
		if (arr[i] < 'n') {
		    ch = arr[i] + 13;
		} else {
		    ch = arr[i] - 13;
		}
		sb.append((char) ch);
		continue;
	    }

	}
	System.out.print(sb.toString());
    }
}