import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] dist;
    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

    private static void dijkstra(int node) {
        pq.add(new Pair(0, node));
        while(!pq.isEmpty()) {
            int w = pq.peek().first;
            int n = pq.peek().second;
            pq.remove();

            for(int i = 0; i <= list[n].size() - 2; i += 2) {
                if(list[n].get(i) != node && (dist[list[n].get(i)] == 0 || dist[list[n].get(i)] > list[n].get(i + 1) + w)) {
                    dist[list[n].get(i)] = list[n].get(i + 1) + w;
                    pq.add(new Pair(list[n].get(i + 1) + w, list[n].get(i)));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        for(int i = 1; i <= v; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            list[start].add(end);
            list[start].add(weight);
        }

        dijkstra(k);
        for(int i = 1; i < v + 1; i++) {
            if(i != k && dist[i] == 0)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
}

class Pair implements Comparable<Pair> {
    int first, second;
    
    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
    
    public int compareTo(Pair p) {
        if(this.first < p.first) {
            return -1; // 오름차순
        }
        else if(this.first == p.first) {
            if(this.second < p.second) {
                return -1;
            }
        }
        return 1; // 이미 this.first가 더 큰 것이 됐으므로, 1로 해준다. -1로 하면 결과가 이상하게 출력됨.
    }
}