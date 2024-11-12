import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int n;
	static int[][] board;
	static boolean[] visited;
	static int cnt;
	
	static void nQueen(int idx, int depth) {
		if(depth > 1) {
            int left = idx - 1, right = idx + 1, ld = depth - 2, rd = depth -  2;
            
			while(ld >= 0 && left >= 0) {
            	if(board[ld][left] == 1)
                    return;
                left--;
                ld--;
            }
            while(rd >= 0 && right < n) {
            	if(board[rd][right] == 1)
                    return;
                right++;
                rd--;
            }
        }
        
        if(depth == n) {
				cnt++;
				return;
        }

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				board[depth][i] = 1;
				nQueen(i, depth + 1);
				visited[i] = false;
				board[depth][i] = 0;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			board = new int[n][n];
			visited = new boolean[n];
			cnt = 0;
			
			nQueen(0, 0);
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}