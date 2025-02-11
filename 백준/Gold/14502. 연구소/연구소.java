import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<int[]> cb = new ArrayList<>();

    static void combination(boolean[] check, int start, int l, int r) {
        if(r == 0) {
            int[] tmp = new int[3];
            int idx = 0;

            for(int i = 0; i < check.length; i++) {
                if(check[i])
                    tmp[idx++] = i;
            }
            cb.add(new int[]{tmp[0], tmp[1], tmp[2]});

            return;
        }

        for(int i = start; i < l; i++) {
            check[i] = true;
            combination(check, i + 1, l, r - 1);
            check[i] = false;
        }
    }

    static void bfs(int[][] board, int[] c, int[] v) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        boolean[][] visited = new boolean[n][m];

        q.add(v);
        visited[v[0]][v[1]] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 1 || visited[ny][nx])
                    continue;

                q.add(new int[]{ny, nx});
                visited[ny][nx] = true;
                board[ny][nx] = 2;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][]board = new int[n][m];
        List<int[]> et = new ArrayList<>();
        List<int[]> virus = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) {
                    et.add(new int[]{i, j});
                } else if(board[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        int max = 0;

        combination(new boolean[et.size()], 0, et.size(), 3);

        for(int[] c: cb) {
            int[][] chBoard = new int[n][m];
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                chBoard[i] = board[i].clone();
            }
            for(int w: c) {
                chBoard[et.get(w)[0]][et.get(w)[1]] = 1;
            }

            for(int[] v: virus) {
               bfs(chBoard, c, v);
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(chBoard[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
