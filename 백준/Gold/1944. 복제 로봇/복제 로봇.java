import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        int start;
        int end;
        int cost;

        public Vertex(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this. cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static char[][] maze;
    static List<Node> list = new ArrayList<>();
    static PriorityQueue<Vertex> vertexes = new PriorityQueue<>();
    static int[] parent;

    public static void bfs(int idx) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] dy = { 1, 0, -1, 0 };
        int[] dx = { 0, 1, 0, -1 };

        q.add(list.get(idx));
        visited[list.get(idx).y][list.get(idx).x] = true;

        while(!q.isEmpty()) {
            Node curNode = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = curNode.y + dy[i];
                int nx = curNode.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || maze[ny][nx] == '1')
                    continue;
                
                if(maze[ny][nx] == 'S' || maze[ny][nx] == 'K') {
                    for(int j = 0; j < m + 1; j++) {
                        if(list.get(j).y == ny && list.get(j).x == nx)
                            vertexes.add(new Vertex(idx, j, curNode.dist + 1));
                    }
                }

                visited[ny][nx] = true;
                q.add(new Node(ny, nx, curNode.dist + 1));
            }
        }
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent < bParent)
            parent[bParent] = aParent;
        else
            parent[aParent] = bParent;
    }

    public static int find(int idx) {
        if(parent[idx] == idx)
            return idx;
        return find(parent[idx]);
    }

    public static int kruskal() {
        int totalCost = 0, cntVertex = 0;

        while(!vertexes.isEmpty()) {
            Vertex curVertex = vertexes.poll();

            if(find(curVertex.start) != find(curVertex.end)) {
                totalCost += curVertex.cost;
                cntVertex++;
                union(curVertex.start, curVertex.end);
            }
        }

        return cntVertex == m ? totalCost : -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                maze[i][j] = str.charAt(j);
                if(maze[i][j] == 'S' || maze[i][j] == 'K')
                    list.add(new Node(i, j, 0));
            }
        }
        parent = new int[m + 1];
        for(int i = 0; i < m + 1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m + 1; i++) {
            bfs(i);
        }
        
        int ans = kruskal();
        System.out.println(ans);
    }
}