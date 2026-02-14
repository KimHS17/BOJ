import java.util.*;
import java.io.*;

public class Main {
    static class Request implements Comparable<Request> {
        int a;
        int b;

        public Request(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Request o) {
            if(this.b == o.b) {
                return this.a - o.a;
            }
            return this.b - o.b;
        }        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] book = new boolean[n + 1];
            PriorityQueue<Request> requests = new PriorityQueue<>();
            int cnt = 0;

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                requests.add(new Request(a, b));
            }

            while(!requests.isEmpty()) {
                Request request = requests.poll();

                for(int j = request.a; j <= request.b; j++) {
                    if(!book[j]) {
                        book[j] = true;
                        cnt++;
                        break;
                    }
                }
            }

            bw.write(cnt + "\n");
            bw.flush();
        }
    }
}
