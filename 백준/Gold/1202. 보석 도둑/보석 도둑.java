import java.util.*;
import java.io.*;

public class Main {
    static class Jewel {
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Jewel> jewels = new ArrayList<>();
        int[] bags = new int[k];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(m, v));
        }
        for(int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(jewels, (o1, o2) -> {
            if (o1.m == o2.m) {
                return o2.v - o1.v;
            }
            return o1.m - o2.m;
        });

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int idx = 0;

        for(int i = 0; i < k; i++) {
            while(idx < n && jewels.get(idx).m <= bags[i]) {
                pq.add(jewels.get(idx).v);
                idx++;
            }

            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
