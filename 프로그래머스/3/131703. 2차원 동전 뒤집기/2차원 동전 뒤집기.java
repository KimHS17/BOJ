class Solution {
    int n,m;
    int[][] graph;
    
    void move(boolean isRow,int y,int x){
        if(isRow) {
            for(int i = 0; i < m; i++) {
                graph[y][i]=graph[y][i] == 1 ? 0 : 1;
            }
        } else {
            for(int i = 0; i < n; i++) {
                graph[i][x] = graph[i][x] == 1 ? 0 : 1;
            }
        }
    }
    
    boolean isOk(int[][] target) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(graph[i][j]!=target[i][j])
                    return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[][] origins, int[][] target) {
        // n,m
        n = origins.length;
        m = origins[0].length;
        int k = 1 << (n + m);
        int answer = 21;
        graph = new int[n][m];
        
        for(int bi = 0; bi < k; bi++) {
            int moveCnt = 0;
            
            for(int y = 0; y < n; y++) {
                for(int x = 0; x < m; x++) {
                    graph[y][x] = origins[y][x];
                }
            }
            
            for(int i = 0; i < n; i++) {
                int bi_i = 1 << i;
                    
                if((bi & bi_i) != 0) {
                    moveCnt++;
                    move(true,i,0);
                }
            }
            
            for(int j = 0; j < m; j++) {
                int bi_j = 1 << j + n;
                if((bi & bi_j) != 0) {
                    moveCnt++;
                    move(false,0,j);
                }
            }
            
            if(isOk(target))
                answer = Math.min(answer,moveCnt);
        }
        
        if(answer == 21)
            answer = -1;
        
        return answer;
    }
}