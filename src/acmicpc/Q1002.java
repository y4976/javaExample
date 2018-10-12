//같은 원 예외처리 안해서 두번 실패.

package acmicpc;

import java.util.Scanner;

public class Q1002 {
	public static void main(String args[]) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] result = new int[n];
				
		for (int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();			
						
			if (x1==x2&&y1==y2&&r1==r2) {
				result[i] = -1;
				continue;
			}	
			
			double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			
			if (r1 + r2 < d) {
				result[i] = 0;
			} else if (r1 + r2 == d) {
				result[i] = 1;
			} else if (Math.abs(r1 - r2) < d && d < r1 + r2) {
				result[i] = 2;
			} else if (Math.abs(r1 - r2) == d) {
				result[i] = 1;
			} else if (Math.abs(r1 - r2) > d) {
				result[i] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(result[i]);	
		}		
		
		sc.close();
	}
}
