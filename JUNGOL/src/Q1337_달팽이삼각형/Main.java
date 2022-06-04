package Q1337_달팽이삼각형;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		for(int i=0; i<arr.length; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		
		int num = 0;
		for(int i=0, j=0; i<N; i++,j++) {
			arr[i][j] = num++;
		}
		
		int i = N-1;
		int j = N-1;
		int vect= 1;
		int ed = N-1;
		while(ed>0) {
			if(vect == 1) {
				for(int a=0; a<ed; a++) {
					arr[i][--j] = num++;
				}
				vect=2;
			} else if(vect==2) {
				for(int a=0; a<ed; a++) {
					arr[--i][j] = num++;
				}
				vect=0;
			} else if(vect==0) {
				for(int a=0; a<ed; a++) {
					arr[++i][++j] = num++;
				}
				vect=1;
			}
			ed--;
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0;c<N; c++) {
				if(arr[r][c]> -1) {
					if(arr[r][c] >=10) {
						String temp = String.valueOf(arr[r][c]);
						System.out.print(temp.charAt(temp.length()-1) + " ");
					} else {
						System.out.print(arr[r][c] + " ");
					}
				}
			}
			System.out.println();
		}
	}
}
