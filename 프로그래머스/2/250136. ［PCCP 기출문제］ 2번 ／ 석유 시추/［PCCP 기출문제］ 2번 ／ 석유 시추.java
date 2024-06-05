import java.util.*;

class Solution {
    int[] cnt;
    
    public void bfs(int[][] land, boolean[][] v, int y, int x, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        q.add(new int[]{y, x});
        v[y][x] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            set.add(now[1]);
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || v[ny][nx] || land[ny][nx] == 0)
                    continue;
                
                q.add(new int[]{ny, nx});
                v[ny][nx] = true;
                count++;
                
            }
        }
        for (int id : set) {
            cnt[id] += count;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        cnt = new int[land[0].length];
        boolean[][] v = new boolean[land.length][land[0].length];
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1 && !v[i][j])
                    bfs(land, v, i, j, land.length, land[0].length);
            }
        }
        answer = Arrays.stream(cnt).max().getAsInt();
        return answer;
    }
}