package Q2063_중간값_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int N = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine());

	int[] arr = new int[N];
	for (int i = 0; i < N; i++) {
	    arr[i] = Integer.parseInt(st.nextToken());
	}

	for (int i = 0; i < N / 2 + 1; i++) {
	    int minIdx = i;
	    for (int j = i + 1; j < N; j++) {
		if (arr[minIdx] < arr[j]) {
		    minIdx = j;
		}
	    }
	    int tmp = arr[i];
	    arr[i] = arr[minIdx];
	    arr[minIdx] = tmp;
	}

	System.out.println(arr[N / 2]);

    }
}
