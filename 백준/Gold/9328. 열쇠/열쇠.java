import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int bfs(Node startNode) {
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[h + 2][w + 2];
        int cnt = 0;

        q.add(startNode);
        visited[startNode.y][startNode.x] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if(ny < 0 || nx < 0 || ny >= h + 2 || nx >= w + 2)
                    continue;

                if(visited[ny][nx] || map[ny][nx] == '*')
                    continue;

                if(map[ny][nx] == '.') {
                    q.add(new Node(ny, nx));
                } else if(map[ny][nx] == '$') {
                    map[ny][nx] = '.';
                    q.add(new Node(ny, nx));
                    cnt++;
                } else if(map[ny][nx] >= 'A' && map[ny][nx] <= 'Z') {
                    int door = map[ny][nx] - 'A';

                    if(keys[door]) {
                        q.add(new Node(ny, nx));
                    } else {
                        doors[door].add(new Node(ny, nx));
                    }
                } else {
                    int key = map[ny][nx] - 'a';

                    if(!keys[key]) {
                        keys[key] = true;
                        for(Node door: doors[key]) {
                            q.add(door);

                        }
                    }

                    q.add(new Node(ny, nx));
                }
                
                visited[ny][nx] = true;
            }
        }

        return cnt;
    }

    static int h, w;
    static char[][] map;
    static boolean[] keys;
    static ArrayList<Node>[] doors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            keys = new boolean[26];
            doors = new ArrayList[26];

            for(int i = 0; i < h; i++) {
                String row = br.readLine();
                for(int j = 0; j < w; j++) {
                    map[i + 1][j + 1] = row.charAt(j);
                }
            }
            for(int i = 0; i < h + 2; i++) {
                map[i][0] = '.';
                map[i][w + 1] = '.';
            }
            for(int i = 1; i < w + 1; i++) {
                map[0][i] = '.';
                map[h + 1][i] = '.';
            }

            for(int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }

            String key = br.readLine();
            if(!key.equals("0")) {
                for(int i = 0; i < key.length(); i++) {
                    keys[key.charAt(i) - 'a'] = true;
                }
            }

            int cnt = bfs(new Node(0, 0));
            bw.write(cnt + "\n");
            bw.flush();
        }
    }
}
