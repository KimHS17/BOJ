import java.util.*;

class Solution {
    static Queue<int[]> e = new LinkedList<>();
    static boolean[][] ck;
    static int answer = 0;
    
    public boolean check(int i, int j, String[] board) {
        char t = board[i].charAt(j);
        int[] dy = { 0, 0, 1, 1 };
        int[] dx = { 0, 1, 0, 1 };
        
        if(board[i].charAt(j + 1) == t && board[i + 1].charAt(j) == t && board[i + 1].charAt(j + 1) == t) {
            for(int k = 0; k < 4; k++) {
                if(!ck[i + dy[k]][j + dx[k]]) {
                    answer++;
                    e.add(new int[]{i + dy[k], j + dx[k]});
                    ck[i + dy[k]][j + dx[k]] = true;
                }
            }
            return true;
        }
        
        return false;
    }
    
    public void drop(String[] board) {
        while(!e.isEmpty()) {
            int[] b = e.poll();
            
            for(int i = b[0] - 1; i >= 0; i--) {
                if(board[i].charAt(b[1]) != 'x') {
                    char[] tmp = board[b[0]].toCharArray();
                    tmp[b[1]] = board[i].charAt(b[1]);
                    board[b[0]] = String.valueOf(tmp);
                    
                    char[] tmp2 = board[i].toCharArray();
                    tmp2[b[1]] = 'x';
                    board[i] = String.valueOf(tmp2);
                    
                    e.add(new int[]{i, b[1]});
                    ck[i][b[1]] = true;
                    ck[b[0]][b[1]] = false;
                    break;
                } else if(i == 0) {
                    char[] tmp = board[b[0]].toCharArray();
                    tmp[b[1]] = 'x';
                    board[b[0]] = String.valueOf(tmp);
                }
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        ck = new boolean[m][n];
        
        while(true) {
            boolean game = false;
            
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(board[i].charAt(j) != 'x' && check(i, j, board)) {
                        game = true;
                    }
                }
            }
            
            if(game) {
                drop(board);
            } else {
                break;
            }
        }
        
        return answer;
    }
}