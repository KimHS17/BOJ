import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE, n = board.length, e;
        boolean[][][] c = new boolean[n][n][4];
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        q.add(new int[]{0, 0, -1, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if(now[0] == n - 1 && now[1] == n - 1) {
                answer = Math.min(answer, now[3]);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1)
                    continue;
                
                if(now[2] == i || now[2] == -1) {
                    e = now[3] + 100;
                } else {
                    e = now[3] + 600;
                }
                if(!c[ny][nx][i] || e <= board[ny][nx]) {
                    c[ny][nx][i] = true;
                    board[ny][nx] = e;
                    q.add(new int[]{ny, nx, i, e});
                }
            }
        }
        
        return answer;
    }
}