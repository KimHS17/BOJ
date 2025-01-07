import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int cal(int n, int m, int[] a, int[] b) {
    	int max = 0;
        
        for(int i = 0; i <= m - n; i++) {
            int sum = 0;
            
            for(int j = 0; j < n; j++) {
                sum += a[j] * b[i + j];
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int ans;
            
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            for(int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            
            if(n < m) {
                ans = cal(n, m, a, b);
            } else {
                ans = cal(m, n, b, a);
            }
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
}