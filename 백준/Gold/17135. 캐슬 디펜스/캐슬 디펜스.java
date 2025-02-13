import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> archer = new ArrayList<>();

    static void combination(boolean[] check, int start, int l, int r) {
        if(r == 0) {
            int[] tmp = new int[3];
            int idx = 0;

            for(int i = 0; i < check.length; i++) {
                if(check[i]) {
                    tmp[idx++] = i;
                }
            }
            archer.add(tmp);

            return;
        }

        for(int i = start; i < l; i++) {
            check[i] = true;
            combination(check, i + 1, l, r - 1);
            check[i] = false;
        }
    }

    static int defense(int[][] cBoard, int n, int m, int d, int[] ac) {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        
        for(int row = n; row > 0; row--) {
            List<int[]> visit = new ArrayList<>();

            for(int idx = 0; idx < 3; idx++) {
                int[] min = { 100, 0, 0 };

                for(int i = row - 1; i >= 0; i--) {
                    for(int j = 0; j < m; j++) {
                        int dist = Math.abs(row - i) + Math.abs(ac[idx] - j);

                        if(dist <= d && cBoard[i][j] == 1) {
                            if(min[0] > dist || (min[0] == dist && j < min[2])) {
                                min[0] = dist;
                                min[1] = i;
                                min[2] = j;
                            }
                        }
                    }
                }

                if(min[0] != 100 && !visited[min[1]][min[2]]) {
                    cnt++;
                    visited[min[1]][min[2]] = true;
                    visit.add(new int[]{min[1], min[2]});
                }
            }

            for(int[] v: visit) {
                cBoard[v[0]][v[1]] = 0;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] check = new boolean[m];
        int max = 0;

        combination(check, 0, m, 3);

        for(int[] ac: archer) {
            int[][] cBoard = board.clone();
            for(int i = 0; i < n; i++) {
                cBoard[i] = board[i].clone();
            }
            max = Math.max(max, defense(cBoard, n, m, d, ac));
        }

        System.out.println(max);
    }
}