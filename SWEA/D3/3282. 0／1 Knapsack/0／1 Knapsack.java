import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] obj = new int[n + 1][2];
            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                obj[i][0] = Integer.parseInt(st.nextToken());
                obj[i][1] = Integer.parseInt(st.nextToken()); 
            }

            int[][] dp = new int[n + 1][k + 1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= k; j++) {
                    if(obj[i][0] > j)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - obj[i][0]] + obj[i][1]);
                }
            }

            System.out.println("#" + t + " " + dp[n][k]);
        }
    }
}
