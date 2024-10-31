import java.util.*;

class Solution {
    int[] dx = { 1, 0, 0, -1 };
    int[] dy = { 0, -1, 1, 0 };
    String[] dir = { "d", "l", "r", "u" };
    String answer;
    
    public void dfs(int n, int m, int x, int y, int r, int c, int k, String route) {
        int dis = Math.abs(r - x) + Math.abs(c - y);
        
        if(answer != null || x < 1 || y < 1 || x > n || y > m || route.length() + dis > k)
            return;

        if(route.length() == k && x == r && y == c) {
            answer = route;
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            dfs(n, m, x + dx[i], y + dy[i], r, c, k, route + dir[i]);
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dis = Math.abs(r - x) + Math.abs(c - y);
        
        if((k - dis) % 2 == 1 || k < dis)
            return "impossible";
        
        dfs(n, m, x, y, r, c, k, "");
        answer = answer == null ? "impossible" : answer;
        
        return answer;
    }
}