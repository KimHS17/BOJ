import java.util.*;

class Solution {
    static int r, c;

    public static int bfs(String[] maps, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        char[][] v = new char[r][c];
        int[][] cnt = new int[r][c];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        char vs = 'l';

        q.add(new int[]{y, x});
        v[y][x] = 'l';

        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || v[ny][nx] == vs || maps[ny].charAt(nx) == 'X')
                    continue;
                
                q.add(new int[]{ny, nx});
                cnt[ny][nx] = cnt[now[0]][now[1]] + 1;
                v[ny][nx] = vs;
                
                if(maps[ny].charAt(nx) == 'L') {
                    q.clear();
                    q.add(new int[]{ny, nx});
                    vs = 'e';
                    v[ny][nx] = 'e';
                    break;
                }
                
                if(vs == 'e' && maps[ny].charAt(nx) == 'E') {
                    return cnt[ny][nx];
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        r = maps.length;
        c = maps[0].length();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(maps[i].charAt(j) == 'S') {
                    answer = bfs(maps, i, j);
                    break;
                }
            }
        }
        
        return answer;
    }
}