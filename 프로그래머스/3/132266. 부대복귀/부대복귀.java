import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] g = new ArrayList[n + 1];
        int[] d = new int[n + 1];
        int[] answer = new int[sources.length];
        
        for(int i = 0 ; i <= n; i++) {
            g[i] = new ArrayList();
        }
        for(int[] road: roads) {
            g[road[0]].add(road[1]);
            g[road[1]].add(road[0]);
        }
        
        q.add(destination);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next: g[now]) {
                if(d[next] == 0 && next != destination) {
                    q.add(next);
                    d[next] = d[now] + 1;
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++) {
            if(sources[i] != destination && d[sources[i]] == 0) {
                answer[i] = -1;
            } else {
                answer[i] = d[sources[i]];
            }
        }
        
        return answer;
    }
}