import java.io.*;
import java.util.*;

public class Solution {
    static int[][] room;
    static int visited[];
    static int[] max = new int[2];

    static void check(int n, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        int num = room[y][x];

        q.add(new int[]{y, x, num});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                    continue;

                if(room[ny][nx] == now[2] + 1) {
                    if(visited[now[2] + 1] != 1) {
                        visited[num] += visited[now[2] + 1];
                        break;
                    } else {
                        visited[num]++;
                    }
                    q.add(new int[]{ny, nx, now[2] + 1});
                    break;
                }
            }
        }

        if(max[1] < visited[num]) {
            max[0] = num;
            max[1] = Math.max(max[1], visited[num]);
        } else if(max[1] == visited[num]) {
            max[0] = Math.min(max[0], num);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            room = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new int[n * n + 1];
            Arrays.fill(visited, 1);
            max[0] = Integer.MAX_VALUE;
            max[1] = -1;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[room[i][j]] == 1) {
                        check(n, i, j);
                    }
                }
            }

            System.out.println("#" + t + " " + max[0] + " " + max[1]);
        }
    }
}
