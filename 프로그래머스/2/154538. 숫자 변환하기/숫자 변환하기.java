import java.util.*;

class Solution {
    public int bfs(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        q.add(new int[]{x, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int[] cal = {now[0] + n, now[0] * 2, now[0] * 3};
            
            for(int c: cal) {
                if(c > y || set.contains(c))
                    continue;
                else if(c == y)
                    return now[1] + 1;
                
                q.add(new int[]{c, now[1] + 1});
                set.add(c);
            }
        }
        
        return -1;
    }
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        if(x == y)
            return 0;
        answer = bfs(x, y, n);
        
        return answer;
    }
}