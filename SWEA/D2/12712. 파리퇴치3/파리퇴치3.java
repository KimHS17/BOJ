import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static int n, m;
    static int[][] board;
    static int ans;
     
    static void cal(int y, int x) {
        int[] dy = { -1, 0, 1, 0, -1, -1, 1, 1 };
        int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1 };
        int sumP = board[y][x], sumM = board[y][x];
         
        for(int i = 0; i < 8; i++) {
            int ny = y, nx = x;
 
            for(int j = 0; j < m - 1; j++) {
                ny += dy[i];
                nx += dx[i];
                 
                if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                    break;
                 
                if(i < 4) {
                    sumP += board[ny][nx];
                } else {
                    sumM += board[ny][nx];
                }
            }
        }
         
        ans = Math.max(ans, Math.max(sumP, sumM));
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            board = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            ans = 0;
             
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    cal(i, j);
                }
            }
             
            System.out.println("#" + test_case + " " + ans);
        }
    }
}