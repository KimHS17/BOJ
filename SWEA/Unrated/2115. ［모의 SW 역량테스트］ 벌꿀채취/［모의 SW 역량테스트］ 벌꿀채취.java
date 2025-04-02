import java.io.*;
import java.util.*;

public class Solution {
    static int n, m, c;
    static int[][] honey;
    static int res, maxB;

    public static void maxHoney(int y, int x, int cnt, int sum, int bn) {
        if(sum > c)
            return;
        
        if(cnt == m) {
            maxB = Math.max(maxB, bn);
            return;
        }

        maxHoney(y, x + 1, cnt + 1, sum + honey[y][x], bn + honey[y][x] * honey[y][x]);
        maxHoney(y, x + 1, cnt + 1, sum, bn);
    }
    
    public static void harvest() {
        int max1 = 0, max2 = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j + m <= n; j++) {
                maxB = 0;
                maxHoney(i, j, 0, 0, 0);
                max1 = maxB;

                maxB = 0;
                max2 = 0;
                for(int k = j + m; k + m <= n; k++) {
                    maxHoney(i, k, 0, 0, 0);
                    max2 = Math.max(max2, maxB);
                }

                for(int k = i + 1; k < n; k++) {
                    for(int l = 0; l + m <= n; l++) {
                        maxHoney(k, l, 0, 0, 0);
                        max2 = Math.max(max2, maxB);
                    }
                }

                res = Math.max(res, max1 + max2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            honey = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            harvest();
            
            System.out.println("#" + t + " " + res);
        }
    }
}
