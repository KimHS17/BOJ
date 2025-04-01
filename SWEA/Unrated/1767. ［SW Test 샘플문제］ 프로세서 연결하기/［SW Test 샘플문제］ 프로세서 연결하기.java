import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[][] board;
    static List<int[]> core;
    static int[] max;
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void dfs(int idx, int cnt, int sum) {
        if(idx == core.size()) {
            if(cnt > max[0]) {
                max[0] = cnt;
                max[1] = sum;
            } else if(cnt == max[0]) {
                max[1] = Math.min(max[1], sum);
            }
            return;
        }

        int y = core.get(idx)[0];
        int x = core.get(idx)[1];

        for(int i = 0; i < 4; i++) {
            int ny = core.get(idx)[0];
            int nx = core.get(idx)[1];
            int line = 0;

            while(ny < n - 1 && nx < n - 1 && ny > 0 && nx > 0) {
                ny += dy[i];
                nx += dx[i];

                if(board[ny][nx] == 1) {
                    ny -= dy[i];
                    nx -= dx[i];
                    line = 0;
                    break;
                }
                line++;
                board[ny][nx] = 1;
            }

            if(line != 0)
                dfs(idx + 1, cnt + 1, sum + line);

            while(ny != y || nx != x) {
                board[ny][nx] = 0;
                ny -= dy[i];
                nx -= dx[i];
            }
        }

        dfs(idx + 1, cnt, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            core = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    if(st.nextToken().equals("1")) {
                        board[i][j] = 1;
                        if(i != 0 && i != n - 1 && j != 0 && j != n - 1)
                            core.add(new int[]{i, j});
                    }
                }
            }

            max = new int[2];
            dfs(0, 0, 0);

            System.out.println("#" + t + " " + max[1]);
        }
    }
}
