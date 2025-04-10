import java.io.*;
import java.util.*;

public class Solution {
    static int n, w, h;
    static int[][] initBrick;
    static int[][] bricks;
    static int[] per;
    static int cntBrick;
    static int min;

    public static void permutation(int cnt) {
        if(cnt == n) {
            breakB(per);
            return;
        }

        for(int i = 0; i < w; i++) {
            per[cnt] = i;
            permutation(cnt + 1);
        }
    }

    public static void breakB(int[] p) {
        int y = 0;
        int cntBreak = 0;
        
        for(int i = 0; i < n; i++) {
            boolean canBreak = false;

            for(int j = 0; j < h; j++) {
                if(bricks[j][p[i]] != 0) {
                    y = j;
                    canBreak = true;
                    break;
                }
            }

            if(!canBreak)
                break;

            cntBreak += bfs(y, p[i]);
            downB();
        }

        min = Math.min(min, cntBrick - cntBreak);
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                bricks[i][j] = initBrick[i][j];
            }
        }
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { 1, 0, -1, 0 };
        int[] dx = { 0, 1, 0, -1 };
        int cntBreak = 1;

        q.add(new int[]{y, x, bricks[y][x]});
        bricks[y][x] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 1; i < now[2]; i++) {
                for(int j = 0; j < 4; j++) {
                    int ny = now[0] + i * dy[j];
                    int nx = now[1] + i * dx[j];

                    if(ny < 0 || nx < 0 || ny >= h || nx >= w || bricks[ny][nx] == 0)
                        continue;
                    
                    q.add(new int[]{ny, nx, bricks[ny][nx]});
                    bricks[ny][nx] = 0;
                    cntBreak++;
                }
            }
        }

        return cntBreak;
    }

    public static void downB() {
        for(int i = 0; i < w; i++) {
            int cnt = 0;

            for(int j = h - 1; j >= 0; j--) {
                if(bricks[j][i] == 0) {
                    cnt++;
                } else if(cnt != 0) {
                    bricks[j + cnt][i] = bricks[j][i];
                    bricks[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            initBrick = new int[h][w];
            bricks = new int[h][w];
            cntBrick = 0;
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    initBrick[i][j] = Integer.parseInt(st.nextToken());
                    bricks[i][j] = initBrick[i][j];
                    if(initBrick[i][j] > 0)
                        cntBrick++;
                }
            }

            per = new int[n];
            min = Integer.MAX_VALUE;
            permutation(0);

            System.out.println("#" + t + " " + min);
        }
    }
}
