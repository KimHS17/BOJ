import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
 
        for(int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dal = new int[n][n];
            int[] dy = { 0, 1, 0, -1 };
            int[] dx = { 1, 0, -1, 0 };
            int y = 0, x = -1, d = 0, num = 1;
 
            while(num <= n * n) {
                y += dy[d];
                x += dx[d];
 
                if(y < 0 || x < 0 || y >= n || x >= n || dal[y][x] != 0) {
                    y -= dy[d];
                    x -= dx[d];
                    d = (d + 1) % 4;
                } else {
                    dal[y][x] = num++;
                }
            }
 
            System.out.println("#" + t);
            for(int[] da: dal) {
                for(int a: da) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }
    }
}