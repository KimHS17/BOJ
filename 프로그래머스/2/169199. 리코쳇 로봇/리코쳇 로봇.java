import java.util.*;

class Solution {
    static int r, c;
    static int[][] v;
    
    public int find(String[] board, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { 1, 0, -1, 0 };
        int[] dx = { 0, 1, 0, -1 };
        
        q.add(new int[]{y, x});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0];
                int nx = now[1];
                
                while(true) {
                    ny += dy[i];
                    nx += dx[i];
                    if(ny < 0 || nx < 0 || ny >= r || nx >= c || board[ny].charAt(nx) == 'D') {
                        int py = ny - dy[i];
                        int px = nx - dx[i];
                        
                        if(v[py][px] != 0 || board[py].charAt(px) == 'R')
                            break;
                        
                        v[py][px] = v[now[0]][now[1]] + 1;
                        if(board[py].charAt(px) == 'G')
                            return v[py][px];
                        
                        q.add(new int[]{py, px});
                        break;
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        int answer = 0;
        r = board.length;
        c = board[0].length();
        v = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i].charAt(j) == 'R') {
                    answer = find(board, i, j);
                    break;
                }
            }
        }
        
        return answer;
    }
}