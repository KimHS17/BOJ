import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int[] dp = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        int answer = 0;
        
        if(sticker.length == 1) {
            return sticker[0];
        }

        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for(int i = 2; i < sticker.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        
        dp2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        
        answer = Math.max(dp[sticker.length - 2], dp2[sticker.length - 1]);

        return answer;
    }
}