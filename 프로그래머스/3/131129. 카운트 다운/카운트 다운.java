class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];
        int[] answer = new int[2];
        
        for(int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i <= target; i++) {
            for(int j = 1; j <= 20; j++) {
                int sg = i - j;
                int db = i - j * 2;
                int tp = i - j * 3;
                int b = i - 50;
                
                if(sg >= 0) {
                    if(dp[i][0] > dp[sg][0] + 1) {
                        dp[i][0] = dp[sg][0] + 1;
                        dp[i][1] = dp[sg][1] + 1;
                    } else if(dp[i][0] == dp[sg][0] + 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[sg][1] + 1);
                    }
                }
                
                if(db >= 0) {
                    if(dp[i][0] > dp[db][0] + 1) {
                        dp[i][0] = dp[db][0] + 1;
                        dp[i][1] = dp[db][1];
                    }
                }
                
                if(tp >= 0) {
                    if(dp[i][0] > dp[tp][0] + 1) {
                        dp[i][0] = dp[tp][0] + 1;
                        dp[i][1] = dp[tp][1];
                    }
                }
                
                if(b >= 0) {
                    if(dp[i][0] > dp[b][0] + 1) {
                        dp[i][0] = dp[b][0] + 1;
                        dp[i][1] = dp[b][1] + 1;
                    } else if(dp[i][0] == dp[b][0] + 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[b][1] + 1);
                    }
                }
            }
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        
        return answer;
    }
}