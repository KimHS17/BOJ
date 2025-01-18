import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;

    static int bs(int a) {
        int l = 0, r = n - 1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(a > dp[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        dp = new int[n + 1];
        int max = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int idx = bs(arr[i]);
            dp[idx + 1] = Math.min(dp[idx + 1], arr[i]);
            max = Math.max(max, idx + 1);
        }

        System.out.println(max);
    }
}
