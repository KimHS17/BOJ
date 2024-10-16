class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length, m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];
        int answer = 0;
        
        for(int[] s: skill) {
            int degree = s[0] == 1 ? s[5] * -1 : s[5];
            
            sum[s[1]][s[2]] += degree;
            sum[s[3] + 1][s[4] + 1] += degree;
            sum[s[1]][s[4] + 1] += degree * -1;
            sum[s[3] + 1][s[2]] += degree * -1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}