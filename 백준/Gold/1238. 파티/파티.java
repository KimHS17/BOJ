import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
    }

    static void dijkstra(int start, List<Node>[] graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        boolean[] visited = new boolean[graph.length];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.next])
                continue;

            visited[now.next] = true;
            for(Node next: graph[now.next]) {
                if(dist[next.next] > dist[now.next] + next.weight) {
                    dist[next.next] = dist[now.next] + next.weight;
                    pq.add(new Node(next.next, dist[next.next]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        List<Node>[] graph = new ArrayList[n + 1];
        List<Node>[] graphR = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        int[] distR = new int[n + 1];
        int max = 0;

        for(int i = 0 ; i <= n; i++) {
            graph[i] = new ArrayList();
            graphR[i] = new ArrayList();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(distR, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            graph[s].add(new Node(e, w));
            graphR[e].add(new Node(s, w));
        }

        dijkstra(x, graph, dist);
        dijkstra(x, graphR, distR);

        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i] + distR[i]);
        }

        System.out.println(max);
    }
}