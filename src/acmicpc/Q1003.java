package acmicpc;

import java.util.Scanner;

public class Q1003 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] dp0 = new int[41];
		int[] dp1 = new int[41];
		
		dp0[0] = 1;
		dp0[1] = 0;
		dp1[0] = 0;
		dp1[1] = 1;		
											
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();

			for (int j = 2; j < n + 1; j++) {
				dp0[j] = dp0[j - 2] + dp0[j - 1];
				dp1[j] = dp1[j - 2] + dp1[j - 1];
			}						
			System.out.println(String.valueOf(dp0[n]) + ' ' + String.valueOf(dp1[n]));			
		}
		
		sc.close();		
	}
}