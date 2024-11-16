import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int n, l;
    static int[][] ingr;
    static boolean[] check;
    static int score;
    
    static void dfs(int idx, int sc, int cal) {
        if(cal > l)
        	return;
        
        if(idx == n) {
            score = Math.max(score, sc);
            return;
        }
        
		dfs(idx + 1, sc + ingr[idx][0], cal + ingr[idx][1]);
        dfs(idx + 1, sc, cal);
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            l = sc.nextInt();
            ingr = new int[n][2];
            check = new boolean[n];
            score = 0;
            
            for(int i = 0; i < n; i++) {
                ingr[i][0] = sc.nextInt();
                ingr[i][1] = sc.nextInt();
            }
            
            dfs(0, 0, 0);
            
            System.out.println("#" + test_case + " " + score);
		}
	}
}