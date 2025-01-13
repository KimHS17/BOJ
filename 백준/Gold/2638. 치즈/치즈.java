import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static List<int[]> cheese;

    static void check(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };

        q.add(new int[]{y, x});
        board[y][x] = 2;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] != 0)
                    continue;
                
                q.add(new int[]{ny, nx});
                board[ny][nx] = 2;
            }
        }
    }

    static int erase() {
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        int time = 0;

        while(!cheese.isEmpty()) {
            List<int[]> tmp = new ArrayList<>();

            for(int i = 0; i < cheese.size(); i++) {
                int cnt = 0;

                for(int j = 0; j < 4; j++) {
                    int ny = cheese.get(i)[0] + dy[j];
                    int nx = cheese.get(i)[1] + dx[j];
    
                    if(ny <= 0 || nx <= 0 || ny >= n || nx >= m || board[ny][nx] == 2)
                        cnt++;
                }
                
                if(cnt >= 2) {
                    tmp.add(new int[]{cheese.get(i)[0], cheese.get(i)[1]});
                    cheese.remove(i--);
                }
            }

            for(int i = 0; i < tmp.size(); i++) {
                if(board[tmp.get(i)[0]][tmp.get(i)[1]] == 1)
                    check(tmp.get(i)[0], tmp.get(i)[1]);
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        cheese = new ArrayList<>();
        int ans;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    cheese.add(new int[]{i, j});
                }
            }
        }

        check(0, 0);
        ans = erase();
        System.out.println(ans);
    }
}