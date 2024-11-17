import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[][] table = new int[n][n];
			int cnt = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n; i++) {
				int last = 2;
				
				for(int j = 0; j < n; j++) {
					if(table[j][i] == 1) {
						last = 1;
					} else if(table[j][i] == 2) {
						if(last == 1)
							cnt++;
						last = 2;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}