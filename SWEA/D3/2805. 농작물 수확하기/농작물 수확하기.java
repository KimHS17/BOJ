import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] farm = new int[n][n];
            int cnt = 0;
            int left = n / 2, right = n / 2;
            
            for(int i = 0; i < n; i++) {
            	String num = sc.next();
                for(int j = 0; j < n; j++) {
                	farm[i][j] = num.charAt(j) - '0';
                }
            }
            
            for(int i = 0; i < n; i++) {
            	for(int j = left; j <= right; j++) {
                	cnt += farm[i][j];
                }
                if(i < n / 2) {
                    left--;
                    right++;
                } else {
                	left++;
                    right--;
                }
            }
            
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}