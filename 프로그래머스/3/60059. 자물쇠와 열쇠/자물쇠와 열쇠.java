class Solution {
    static int n, m, o;
    static int[][] exKey;
    
    public void rotateKey(int[][] key) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                exKey[i + n - 1][j + n - 1] = key[j][m - 1 - i];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                key[i][j] = exKey[i + n - 1][j + n - 1];
            }
        }
    }
    
    public boolean check(int[][] lock) {
        for(int i = 0; i <= o - n; i++) {
            for(int j = 0; j <= o - n; j++) {
                int cnt = 0;
                
                for(int k = 0; k < n; k++) {
                    for(int l = 0; l < n; l++) {
                        if(lock[k][l] != exKey[i + k][j + l]) {
                            cnt++;
                        }
                    }
                }
                
                if(cnt == n * n) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        n = lock.length;
        m = key.length;
        o = m + (n - 1) * 2;
        exKey = new int[o][o];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                exKey[i + n - 1][j + n - 1] = key[i][j];
            }
        }
        
        for(int i = 0; i < 4; i++) {
            if(i != 0) {
                rotateKey(key);
            }
            if(check(lock)) {
                answer = true;
                break;
            }
        }
        
        return answer;
    }
}