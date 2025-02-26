import java.io.*;
import java.util.*;

public class Solution {
    static int n, b;
    static int[] h;
    static int min;

    static void permutation(boolean[] visited, int c, int idx) {
        if(idx == n) {
            check(visited);
            return;
        }

        visited[idx] = true;
        permutation(visited, n, idx + 1);

        visited[idx] = false;
        permutation(visited, n, idx + 1);
    }

    static void check(boolean[] visited) {
        int sum = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                sum += h[i];
            }
        }

        if(sum >= b) {
            min = Math.min(min, sum - b);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            h = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n];
            min = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++) {
                permutation(visited, i, 0);
            }

            System.out.println("#" + t + " " + min);
        }
    }
}
