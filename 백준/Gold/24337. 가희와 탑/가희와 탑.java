import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> building = new ArrayList<>();

        if (a + b > n + 1) {
            bw.write("-1");
            bw.flush();
            return;
        }

        for(int i = 1; i < a; i++) {
            building.add(i);
        }
        building.add(Math.max(a, b));
        for (int i = b - 1; i >= 1; i--) {
            building.add(i);
        }

        int cnt = n - (a + b - 1);
        if(a == 1) {
            for(int i = 0; i < cnt; i++) {
                building.add(a, 1);
            }
        } else {
            for(int i = 0; i < cnt; i++) {
                building.add(1, 1);
            }
        }

        for(int bd: building) {
            bw.write(bd + " ");
        }
        bw.flush();
    }
}
