import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n + 1][n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            isPalindrome[i][i] = true;

            if(i < n) {
                if (str.charAt(i - 1) == str.charAt(i)) {
                    isPalindrome[i][i + 1] = true;
                }
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                if (str.charAt(start - 1) == str.charAt(end - 1) && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
