package Q1331_문자마름모;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		char[][] arr = new char[N + N - 1][N + N - 1];

		char ch = 'A';
		int ep = N - 1;
		int r = 0;
		int c = (N + N - 1) / 2;
		int vect = 0;
		arr[r][c] = ch;
		while (ep > 0) {
			if (vect == 0) {
				for (int a = 0; a < ep; a++) {
					if (ch - '0' > 41)
						ch = 'A'-1;
					arr[++r][--c] = ++ch;
				}
				vect = 1;
			} else if (vect == 1) {
				for (int a = 0; a < ep; a++) {
					if (ch - '0' > 41)
						ch = 'A'-1;
					arr[++r][++c] = ++ch;
				}
				vect=2;
			}  else if(vect == 2) {
				for (int a = 0; a < ep; a++) {
					if (ch - '0' > 41)
						ch = 'A'-1;
					arr[--r][++c] = ++ch;
				}
				vect=3;
			} else if(vect== 3) {
				ep--;
				for(int a=0; a<ep; a++) {
					if (ch - '0' > 41)
						ch = 'A'-1;
					arr[--r][--c] = ++ch;
				}
				if (ch - '0' > 41)
					ch = 'A'-1;
				arr[r][--c] = ++ch;
				vect=0;
			}
		}
		
		for(int i=0; i<N+N-1; i++) {
			for(int j=0; j<N+N-1; j++) {
				if(arr[i][j] >'0') {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
