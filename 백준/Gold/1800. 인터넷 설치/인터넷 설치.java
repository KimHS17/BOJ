import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int com;
        int cost;

        public Node(int com, int cost) {
            this.com = com;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, p, k;
    static List<Node>[] internet;

    public static boolean dijkstra(int mid) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.com] < now.cost )
                continue;
            
            for(Node next: internet[now.com]) {
                int cnt = now.cost;

                if(mid < next.cost)
                    cnt++;

                if(dist[next.com] > cnt) {
                    dist[next.com] = cnt;
                    pq.add(new Node(next.com, cnt));
                }
            }
        }

        return dist[n] <= k;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        internet = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            internet[i] = new ArrayList<>();
        }

        int left = 0, right = 0;
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            internet[start].add(new Node(end, cost));
            internet[end].add(new Node(start, cost));
            right = Math.max(right, cost);
        }

        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}
