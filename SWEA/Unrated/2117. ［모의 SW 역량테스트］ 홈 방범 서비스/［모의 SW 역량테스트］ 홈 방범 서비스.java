import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static List<int[]> city;
    static int max;

    public static void security(int y, int x) {
        int nowHouse = 0, nowCost = 1;

        for(int k = 0; k <= n; k++) {
            nowCost += k * 4;
            for(int[] house: city) {
                if(Math.abs(house[0] - y) + Math.abs(house[1] - x) == k)
                    nowHouse++;
                
                if(nowHouse * m >= nowCost) {
                    max = Math.max(max, nowHouse);
                    if(max == city.size())
                        return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            city = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    if(st.nextToken().equals("1"))
                        city.add(new int[]{i, j});
                }
            }

            max = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    security(i, j);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
