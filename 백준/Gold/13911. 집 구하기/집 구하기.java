import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static void dijkstra(ArrayList<Integer> startNodes, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int start : startNodes) {
            dist[start] = 0;
            pq.add(new Node(start, 0));
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.end])
                continue;

            for(Node next: graph[cur.end]) {
                if(dist[next.end] > dist[cur.end] + next.cost) {
                    dist[next.end] = dist[cur.end] + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }

    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        boolean[] isStore = new boolean[V + 1];

        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Integer> macdonald = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int node = Integer.parseInt(st.nextToken());
            macdonald.add(node);
            isStore[node] = true;
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        ArrayList<Integer> starbucks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++) {
            int node = Integer.parseInt(st.nextToken());
            starbucks.add(node);
            isStore[node] = true;
        }

        int[] distM = new int[V + 1];
        int[] distS = new int[V + 1];

        dijkstra(macdonald, distM);
        dijkstra(starbucks, distS);

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= V; i++) {
            if(isStore[i])
                continue;

            if(distM[i] <= x && distS[i] <= y) {
                min = Math.min(min, distM[i] + distS[i]);
            }
        }

        bw.write(min == Integer.MAX_VALUE ? "-1" : String.valueOf(min));
        bw.flush();
    }
}
