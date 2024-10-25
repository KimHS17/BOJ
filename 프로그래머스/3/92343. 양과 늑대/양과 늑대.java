class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public void dfs(int[] info, int[][] edges, int id, int sheep, int wolf) {
        if(info[id] == 0) {
            sheep++;
            answer = Math.max(answer, sheep);
        } else {
            wolf++;
        }
        
        if(sheep <= wolf) {
            return;
        }
        
        for(int[] edge: edges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                visited[edge[1]] = true;
                dfs(info, edges, edge[1], sheep, wolf);
                visited[edge[1]] = false;
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        
        visited[0] = true;
        dfs(info, edges, 0, 0, 0);
        
        return answer;
    }
}