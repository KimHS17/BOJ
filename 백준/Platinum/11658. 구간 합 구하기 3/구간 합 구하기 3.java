import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[][] tree;

    public static void update(int x, int y, long diff) {
        for (int i = x; i <= n; i += (i & -i)) {
            for (int j = y; j <= n; j += (j & -j)) {
                tree[i][j] += diff;
            }
        }
    }

    public static long query(int x, int y) {
        long sum = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            for (int j = y; j > 0; j -= (j & -j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    public static long rangeSum(int x1, int y1, int x2, int y2) {
        return query(x2,y2) - query(x1-1,y2) - query(x2,y1-1) + query(x1-1,y1-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tree = new long[n + 1][n + 1];
        long[][] arr = new long[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
                update(i, j, arr[i][j]);
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(w == 0) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[x][y];
                arr[x][y] = c;
                update(x, y, diff);
            } else if(w == 1) {
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                System.out.println(rangeSum(x, y, x2, y2));
            }
        }
    }
}
