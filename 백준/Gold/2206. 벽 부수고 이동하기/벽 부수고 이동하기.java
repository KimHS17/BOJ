import java.io.*;
import java.util.*;

public class Main {
    static int[][][] count;

    public static void bfs(int n, int m, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };

        q.add(new int[]{0, 0, 0});
        count[0][0][0] = 1;
        count[0][0][1] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                int cnt = count[now[0]][now[1]][now[2]] + 1;

                if(ny < 0 || nx < 0 || ny >= n || nx >= m || (count[ny][nx][now[2]] != 0 && count[ny][nx][now[2]] <= cnt) || (now[2] == 1 && board[ny][nx] == 1))
                    continue;

                if(now[2] == 0 && board[ny][nx] == 1) {
                    if(count[ny][nx][1] == 0 || count[ny][nx][1] > cnt) {
                        q.add(new int[]{ny, nx, 1});
                        count[ny][nx][1] = cnt;
                    }
                } else {
                    q.add(new int[]{ny, nx, now[2]});
                    count[ny][nx][now[2]] = cnt;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        count = new int[n][m][2];
        int res;

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs(n, m, board);
        if(count[n - 1][m - 1][0] == 0) {
            res = count[n - 1][m - 1][1];
        } else if(count[n - 1][m - 1][1] == 0) {
            res = count[n - 1][m - 1][0];
        } else {
            res = Math.min(count[n - 1][m - 1][0], count[n - 1][m - 1][1]);
        }
        res = res == 0 ? -1 : res;
        System.out.println(res);
    }
}
