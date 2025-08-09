class Solution {
    static class Coor {
        int y, x;
        
        public Coor(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    int r, c;
    boolean[][][] visited;
    int min = Integer.MAX_VALUE;
    boolean fRed = false;
    boolean fBlue = false;
    int[] dy = { 0, 1, 0, -1 };
    int[] dx = { 1, 0, -1, 0 };
    
    public boolean canMove(int[][] maze, Coor curRed, Coor curBlue, Coor nRed, Coor nBlue) {
        if(nRed.y < 0 || nRed.y >= r || nRed.x < 0 || nRed.x >= c)
            return false;
        if(nBlue.y < 0 || nBlue.y >= r || nBlue.x < 0 || nBlue.x >= c)
            return false;
        
        if(!fRed && visited[nRed.y][nRed.x][0])
            return false;
        if(!fBlue && visited[nBlue.y][nBlue.x][1])
            return false;
        
        if(maze[nRed.y][nRed.x] == 5 || maze[nBlue.y][nBlue.x] == 5)
            return false;
        
        if(nRed.y == nBlue.y && nRed.x == nBlue.x)
            return false;
        
        if(nRed.y == curBlue.y && nRed.x == curBlue.x && nBlue.y == curRed.y && nBlue.x == curRed.x)
            return false;
        
        return true;
    }
    
    public void bt(int[][] maze, int cnt, Coor curRed, Coor curBlue) {        
        if(fRed && fBlue) {
            min = Math.min(cnt, min);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            for(int j =0 ; j < 4; j++) {
                Coor nRed = fRed ? curRed : new Coor(curRed.y + dy[i], curRed.x + dx[i]);
                Coor nBlue = fBlue ? curBlue : new Coor(curBlue.y + dy[j], curBlue.x + dx[j]);
                
                if(canMove(maze, curRed, curBlue, nRed, nBlue)) {
                    boolean wasRedFinished = fRed;
                    boolean wasBlueFinished = fBlue;
                    
                    if(maze[nRed.y][nRed.x] == 3)
                        fRed = true;
                    if(maze[nBlue.y][nBlue.x] == 4)
                        fBlue = true;
                    
                    visited[nRed.y][nRed.x][0] = true;
                    visited[nBlue.y][nBlue.x][1] = true;
                    
                    bt(maze, cnt + 1, nRed, nBlue);
                    
                    fRed = wasRedFinished;
                    fBlue = wasBlueFinished;
                    visited[nRed.y][nRed.x][0] = false;
                    visited[nBlue.y][nBlue.x][1] = false;
                }
            }
        }
    }
    
    public int solution(int[][] maze) {
        r = maze.length;
        c = maze[0].length;
        visited = new boolean[r][c][2];
        Coor curRed = null;
        Coor curBlue = null;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(maze[i][j] == 1)
                    curRed = new Coor(i, j);
                if(maze[i][j] == 2)
                    curBlue = new Coor(i, j);
            }
        }
        
        visited[curRed.y][curRed.x][0] = true;
        visited[curBlue.y][curBlue.x][1] = true;
        bt(maze, 0, curRed, curBlue);
        
        if(min == Integer.MAX_VALUE)
            min = 0;
        
        return min;
    }
}