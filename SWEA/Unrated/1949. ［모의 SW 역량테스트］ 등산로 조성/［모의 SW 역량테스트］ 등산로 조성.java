import java.io.*;
import java.util.*;

public class Solution {
    static int n, k;
    static int[][] map;
    static List<int[]> peaks;
    static int maxLength;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void dfs(boolean[][] visited, int y, int x, int length, boolean cs) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx])
                continue;

            visited[ny][nx] = true;
            if(map[ny][nx] < map[y][x]) {
                dfs(visited, ny, nx, length + 1, cs);
            } else if(!cs) {
                int height = map[ny][nx] - map[y][x] + 1;
                if(height <= k) {
                    map[ny][nx] -= height;
                    dfs(visited, ny, nx, length + 1, true);
                    map[ny][nx] += height;
                }
            }
            visited[ny][nx] = false;
        }
        
        maxLength = Math.max(maxLength, length);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            int maxHight = 0;
            peaks = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > maxHight) {
                        maxHight = map[i][j];
                        peaks.clear();
                        peaks.add(new int[]{i, j});
                    } else if(map[i][j] == maxHight) {
                        peaks.add(new int[]{i, j});
                    }
                }
            }
            
            maxLength = 1;
            for(int[] p: peaks) {
                boolean[][] visited = new boolean[n][n];
                visited[p[0]][p[1]] = true;
                dfs(visited, p[0], p[1], 1, false);
            }

            System.out.println("#" + t + " " + maxLength);
        }
    }
}
