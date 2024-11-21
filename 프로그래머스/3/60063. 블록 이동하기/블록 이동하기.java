import java.util.*;

class Solution {
    static boolean[][][] visited;
    static int[][][] cnt;
    static int n, answer = Integer.MAX_VALUE;
    
    static void bfs(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, 1, 0, -1 };
        int[][] ds = { {0, 1}, {1, 0} };
        int[] ry = { 1, 1, 1, 0 };
        int[] rx = { 0, 1, 1, 1 };
        int[] rsy = { 1, 1, 0, 1 };
        int[] rsx = { 1, 0, 1, 1 };
        int[] ry2 = { -1, -1, 1, 0 };
        int[] rx2 = { 0, 1, -1, -1 };
        int[] rsy2 = { -1, -1, 0, 1 };
        int[] rsx2 = { 1, 0, -1, -1 };
        
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                int sy = ny + ds[now[2]][0];
                int sx = nx + ds[now[2]][1];
                int ncnt = cnt[now[0]][now[1]][now[2]] + 1;
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1 || (visited[ny][nx][now[2]] && cnt[ny][nx][now[2]] <= ncnt))
                    continue;
                
                if(sy >= n || sx >= n || board[sy][sx] == 1)
                    continue;
                
                q.add(new int[]{ny, nx, now[2]});
                visited[ny][nx][now[2]] = true;
                cnt[ny][nx][now[2]] = ncnt;
                
                if(sy == n - 1 && sx == n - 1)
                    answer = Math.min(answer, ncnt);
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0];
                int nx = now[1];
                int sy = ny + ry[i];
                int sx = nx + rx[i];
                int oy = ny + rsy[i];
                int ox = nx + rsx[i];
                int dir = now[2] == 0 ? 1 : 0;
                int ncnt = cnt[ny][nx][now[2]] + 1;
                
                if(i == 1)
                    nx++;
                if(i == 2)
                    ny++;
                
                if(now[2] == 0 && i > 1 || now[2] == 1 && i < 2)
                    continue;
                
                if(sy >= n || sx >= n || board[oy][ox] == 1 || board[sy][sx] == 1 || (visited[ny][nx][dir] && cnt[ny][nx][dir] <= ncnt))
                    continue;
                
                q.add(new int[]{ny, nx, dir});
                visited[ny][nx][dir] = true;
                cnt[ny][nx][dir] = ncnt;
                
                if(sy == n - 1 && sx == n - 1)
                    answer = Math.min(answer, ncnt);
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0];
                int nx = now[1];
                int sy = ny + ry2[i];
                int sx = nx + rx2[i];
                int oy = ny + rsy2[i];
                int ox = nx + rsx2[i];
                int dir = now[2] == 0 ? 1 : 0;
                int ncnt = cnt[ny][nx][now[2]] + 1;
                
                if(i == 1)
                    nx++;
                if(i == 2)
                    ny++;

                if(now[2] == 0 && i > 1 || now[2] == 1 && i < 2)
                    continue;
                
                if(sy < 0 || sx < 0 || board[oy][ox] == 1 || board[sy][sx] == 1 || (visited[sy][sx][dir] && cnt[sy][sx][dir] <= ncnt))
                    continue;
                
                q.add(new int[]{sy, sx, dir});
                visited[sy][sx][dir] = true;
                cnt[sy][sx][dir] = ncnt;
                
                if(ny == n - 1 && nx == n - 1)
                    answer = Math.min(answer, ncnt);
            }
        }
    }
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][2];
        cnt = new int[n][n][2];
        
        bfs(board);
        
        return answer;
    }
}