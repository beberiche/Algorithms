package Q10814_나이순_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int TC = Integer.parseInt(br.readLine());

	String[][] strArr = new String[TC][2];
	for (int t = 0; t < TC; t++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    strArr[t][0] = st.nextToken();
	    strArr[t][1] = st.nextToken();
	}

	Arrays.sort(strArr, new Comparator<String[]>() {

	    public int compare(String[] str1, String[] str2) {
		return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
	    }
	});

	for (int i = 0; i < TC; i++) {
	    System.out.println(strArr[i][0] + " " + strArr[i][1]);
	}

    }
}
