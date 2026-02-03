import java.util.*;
import java.io.*;

public class Main {
    static class Coin {
        int value;
        int count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[n];
            int amount = 0;
            

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                coins[j] = new Coin(value, count);
                amount += value * count;
            }

            if(amount % 2 == 1) {
                System.out.println("0");
                continue;
            }

            int target = amount / 2;
            int[] dp = new int[target + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            for(int j = 0; j < n; j++) {
                int value = coins[j].value;
                int count = coins[j].count;

                for(int k = 0; k <= target; k++) {
                    if(dp[k] >= 0) {
                        dp[k] = count;
                    } else if(k >= value && dp[k - value] >= 1) {
                        dp[k] = dp[k - value] - 1;
                    }
                }
            }

            if(dp[target] >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
