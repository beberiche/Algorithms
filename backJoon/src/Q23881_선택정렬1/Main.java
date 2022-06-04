package Q23881_선택정렬1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	int len = Integer.parseInt(st.nextToken());
	int changeNum = Integer.parseInt(st.nextToken());

	int[] arr = new int[len];

	int cnt = 0;
	st = new StringTokenizer(br.readLine());
	for (int i = 0; i < len; i++) {
	    arr[i] = Integer.parseInt(st.nextToken());
	}

	for (int i = 0; i < len; i++) {
	    int minIdx = i;
	    for (int j = i; j < len; j++) {
		if (arr[minIdx] >= arr[j]) {
		    minIdx = j;
		}
	    }
	    int temp = arr[i];
	    arr[i] = arr[minIdx];
	    arr[minIdx] = temp;
	    if (temp != arr[i]) {
		cnt++;
		if (cnt == changeNum) {
		    if (arr[i] > arr[minIdx]) {
			System.out.printf("%d %d", arr[minIdx], arr[i]);
			continue;
		    }
		    System.out.printf("%d %d", arr[i], arr[minIdx]);
		}
	    }
	    if (cnt < changeNum) {
		System.out.println(-1);
		break;
	    }
	}
    }
}
