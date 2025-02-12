import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt = 0;
    static int[][] board;
    static int[] dy = { 1, 0, 1 };
    static int[] dx = { 0, 1, 1 };

    static void dfs(int y, int x, int d) {
        for(int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(d != 2 && d == i)
                continue;
            
            if(ny >= n || nx >= n || board[ny][nx] == 1)
                continue;

            if(i == 2 && (board[ny - 1][nx] == 1 || board[ny][nx - 1] == 1))
                continue;

            if(ny == n - 1 && nx == n - 1) {
                cnt++;
            } else {
                int dr = 2;
                if(i <= 1) {
                    dr = (i + 1) % 2;
                }
                dfs(ny, nx, dr);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(cnt);
    }
}
