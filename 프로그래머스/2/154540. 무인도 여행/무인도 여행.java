import java.util.*;

class Solution {
    static int r, c;
    
    public int bfs(String[] maps, boolean[][] v, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int cnt = 0;
        
        q.add(new int[]{y, x});
        v[y][x] = true;
        cnt += maps[y].charAt(x) - '0';
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || v[ny][nx] || maps[ny].charAt(nx) == 'X')
                    continue;
                
                q.add(new int[]{ny, nx});
                v[ny][nx] = true;
                cnt += maps[ny].charAt(nx) - '0';
            }
        }
        
        return cnt;
    }
    
    public List solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        r = maps.length;
        c = maps[0].length();
        boolean[][] v = new boolean[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(maps[i].charAt(j) != 'X' && !v[i][j]) {
                    answer.add(bfs(maps, v, i, j));
                }
            }
        }
        
        answer.sort(Comparator.naturalOrder());
        
        if(answer.size() == 0)
            answer.add(-1);
        
        return answer;
    }
}