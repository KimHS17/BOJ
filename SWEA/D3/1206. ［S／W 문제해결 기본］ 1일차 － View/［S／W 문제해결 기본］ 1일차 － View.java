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
            int[] building = new int[n + 4];
            int cnt = 0;
            
            for(int i = 2; i < n + 2; i++) {
                building[i] = sc.nextInt();
            }
            
            for(int i = 2; i < n + 2; i++) {
            	int left = Math.max(building[i - 1], building[i - 2]);
                int right = Math.max(building[i + 1], building[i + 2]);
                int h = Math.max(left, right);
                
                cnt += Math.max(building[i] - h, 0);
            }
            
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}
