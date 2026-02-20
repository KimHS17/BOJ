import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int dijkstra(int a, int b) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(dist[now.end] < now.time)
                continue;

            for(Node next: graph[now.end]) {
                if((now.end == a && next.end == b) || (now.end == b && next.end == a))
                    continue;

                if(dist[next.end] > dist[now.end] + next.time) {
                    dist[next.end] = dist[now.end] + next.time;
                    pq.add(new Node(next.end, dist[next.end]));

                    if(a == 0) {
                        parent[next.end] = now.end;
                    }
                }
            }
        }

        return dist[n];
    }

    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, t));
            graph[b].add(new Node(a, t));
        }

        int minTime = dijkstra(0, 0);
        int maxTime = 0;
        int now = n;
        
        while(now != 1) {
            maxTime = Math.max(maxTime, dijkstra(now, parent[now]));
            now = parent[now];
        }

        if(maxTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(maxTime - minTime);
        }
    }
}
