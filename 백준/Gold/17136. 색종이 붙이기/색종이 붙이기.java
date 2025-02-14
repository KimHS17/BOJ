import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int min = Integer.MAX_VALUE;

    static int check(int y, int x) {
        int size = 4;

        while(true) {
            boolean flag = true;

            if(y + size >= 10 || x + size >= 10) {
                flag = false;
            } else {
                if(board[y + size][x + size] == 1) {
                    for(int i = y; i <= y + size; i++) {
                        for(int j = x; j <= x + size; j++) {
                            if(board[i][j] == 0) {
                                flag = false;
                            }
                        }
                    }
                } else {
                    flag = false;
                }
            }

            if(flag) {
                break;
            }
            size--;
        }

        return size;
    }

    static void stick(int y, int x, int p, int num) {
        for(int i = y; i <= y + p; i++) {
            for(int j = x; j <= x + p; j++) {
                board[i][j] = num;
            }
        }
    }

    static void dfs(int[] paper, int y, int x, int cnt) {
        if(min <= cnt) {
            return;
        }

        if(y >= 9 && x > 9) {
            min = Math.min(min, cnt);
            return;
        }

        if(x > 9) {
            dfs(paper, y + 1, 0, cnt);
            return;
        }
        
        if(board[y][x] == 1) {
            int size = check(y, x);
            for(int p = size; p >= 0; p--) {
                if(paper[p] > 0) {
                    paper[p]--;
                    stick(y, x, p, 0);
                    dfs(paper, y, x + 1, cnt + 1);
                    paper[p]++;
                    stick(y, x, p, 1);
                }
            }
        } else {
            dfs(paper, y, x + 1, cnt);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[10][10];
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] paper = new int[5];
        Arrays.fill(paper, 5);

        dfs(paper, 0, 0, 0);
        if(min == Integer.MAX_VALUE) {
            min = -1;
        }
        
        System.out.println(min);
    }
}
