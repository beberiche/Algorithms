package Q5430_AC_unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		outer: while (--T >= 0) {
			String func = br.readLine();
			int N = Integer.parseInt(br.readLine());
			arr = br.readLine().replaceAll("[\\[\\]]", "").split(",");

			func = func.replace("RR", "");

			char[] funcArr = func.toCharArray();

			for (int i = 0; i < funcArr.length; i++) {
				if (funcArr[i] == 'R') {
					arr = reverse(arr);
				} else {
					try {
						arr = delete(arr);
					} catch (NullPointerException e) {
						bw.append("error").append("\n");
						continue outer;
					}
				}
			}
	
				bw.append("[");
				for(int i=0; i<arr.length-1; i++) {
					bw.append(arr[i]).append(",");
				}
				bw.append(arr[arr.length-1]).append("]").append("\n");
		}
		bw.flush();

	}

	private static String[] delete(String[] arr) {
		// TODO Auto-generated method stub
		if (arr.length <= 1 || arr[0].equals("")) {
			throw new NullPointerException();
		}
		String[] temp = new String[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			temp[i - 1] = arr[i];
		}
		return temp;

	}

	private static String[] reverse(String[] arr) {
		// TODO Auto-generated method stub
		String[] temp = new String[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			temp[arr.length - 1 - i] = arr[i];
		}
		return temp;
	}
}