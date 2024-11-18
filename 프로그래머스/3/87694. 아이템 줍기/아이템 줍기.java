import java.util.*;

class Solution {
    static boolean isIn(int[][] rectangle, int x, int y) {
        for(int[] rect: rectangle) {
            if(x > rect[0] && x < rect[2] && y > rect[1] && y < rect[3])
                return true;
        }
        
        return false;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        int[][] map = new int[102][102];
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
            for(int j = rectangle[i][0]; j <= rectangle[i][2]; j++) {
                map[rectangle[i][1]][j] = 1;
                map[rectangle[i][3]][j] = 1;
            }
            for(int j = rectangle[i][1]; j <= rectangle[i][3]; j++) {
                map[j][rectangle[i][0]] = 1;
                map[j][rectangle[i][2]] = 1;
            }
        }
        
        q.add(new int[]{characterY * 2, characterX * 2, 0});
        map[characterY * 2][characterX * 2] = 0;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(nx == itemX * 2 && ny == itemY * 2) {
                    answer = Math.min(answer, now[2] + 1);
                    continue;
                }
                
                if(map[ny][nx] == 0 || isIn(rectangle, nx, ny))
                    continue;
                
                q.add(new int[]{ny, nx, now[2] + 1});
                map[ny][nx] = 0;
            }
        }
        
        return answer / 2;
    }
}