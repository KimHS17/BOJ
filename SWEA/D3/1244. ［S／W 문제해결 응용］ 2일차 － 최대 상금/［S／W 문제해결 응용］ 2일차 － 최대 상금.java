import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int cnt, max;
    static int[] num;
    
    static void swap(int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    static void dfs(int depth) {
    	if(depth == cnt) {
            int bonus = 0;
            
            for(int i = 0; i < num.length; i++) {
                bonus += (num[num.length - i - 1] * Math.pow(10, i));
            }
            max = Math.max(max, bonus);
            
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
        	for(int j = i + 1; j < num.length; j++) {
            	swap(i, j);
                dfs(depth + 1);
                swap(i, j);
            }
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String n = sc.next();
            cnt = sc.nextInt();
            num = new int[n.length()];
            max = 0;
            
            for(int i = 0; i < n.length(); i++) {
            	num[i] = n.charAt(i) - '0';
            }
            
            if(cnt > num.length) {
            	cnt = num.length;
            }
            
            dfs(0);
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}