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
        int[] len = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int idx = bs(arr[i]);
            dp[idx + 1] = Math.min(dp[idx + 1], arr[i]);
            max = Math.max(max, idx + 1);
            len[i] = idx + 1;
        }

        int maxLen = max;
        for(int i = n - 1; i >= 0; i--) {
            if(len[i] == maxLen) {
                stack.add(arr[i]);
                maxLen--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(max);
        System.out.println(sb.toString());
    }
}
