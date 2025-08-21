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

    static int n, m, s, d;
    static List<Node>[] graph;
    static List<Node>[] rGraph;
    static int[] distance;
    static int[] rDistance;
    static boolean[][] deleted;

    static void dikjstra(int start, int[] dist, List<Node>[] grp) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int u = now.end;

            if(now.cost > dist[u])
                continue;
            
            for(Node next : grp[u]) {
                int v = next.end;

                if(deleted[u][v]) {
                    continue;
                }
                
                if(dist[v] > dist[u] + next.cost) {
                    dist[v] = dist[u] + next.cost;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
            String input = br.readLine();
            if(input.equals("0 0"))
                break;
            
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n];
            rGraph = new ArrayList[n];
            for(int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                rGraph[i] = new ArrayList<>();
            }
            distance = new int[n];
            rDistance = new int[n];
            deleted = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[start].add(new Node(end, cost));
                rGraph[end].add(new Node(start, cost));
            }

            dikjstra(s, distance, graph);
            dikjstra(d, rDistance, rGraph);
            int min = distance[d];

            for(int u = 0; u < n; u++) {
                for(Node next : graph[u]) {
                    int v = next.end;
                    if (distance[u] != Integer.MAX_VALUE && rDistance[v] != Integer.MAX_VALUE) {
                        if(distance[u] + next.cost + rDistance[v] == min) {
                            deleted[u][v] = true;
                        }
                    }
                }
            }

            dikjstra(s, distance, graph);
            if(distance[d] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(distance[d]);
            }
        }
    }
}
