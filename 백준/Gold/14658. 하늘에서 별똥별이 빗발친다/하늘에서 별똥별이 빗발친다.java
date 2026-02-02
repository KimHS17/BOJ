import java.util.*;
import java.io.*;

public class Main {

    static int n, m, l, k;
    static ArrayList<int[]> stars = new ArrayList<>();

    static int countStar() {
        int max = 0;

        for(int[] s1: stars) {
            for(int[] s2: stars) {
                int x = s1[0];
                int y = s2[1];
                int cnt = 0;

                for(int[] star: stars) {
                    int starX = star[0];
                    int starY = star[1];

                    if(starX >= x && starX <= x + l && starY >= y && starY <= y + l)
                        cnt++;
                }

                max = Math.max(max, cnt);
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        int total = stars.size();
        int max = countStar();
        int ans = total - max;
        System.out.println(ans);
    }
}