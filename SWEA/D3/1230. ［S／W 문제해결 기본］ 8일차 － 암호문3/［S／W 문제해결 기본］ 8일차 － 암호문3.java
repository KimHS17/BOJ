import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                list.add(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            StringTokenizer cmd = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < m; i++) {
                String tmp = cmd.nextToken();
                int x, y;

                switch (tmp) {
                    case "I":
                        x = Integer.parseInt(cmd.nextToken());
                        y = Integer.parseInt(cmd.nextToken());
                        for(int j = 0; j < y; j++) {
                            list.add(x++, cmd.nextToken());
                        }
                        break;
                    case "D":
                        x = Integer.parseInt(cmd.nextToken());
                        y = Integer.parseInt(cmd.nextToken());
                        for(int j = 0; j < y; j++) {
                            list.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(cmd.nextToken());
                        for(int j = 0; j < y; j++) {
                            list.add(cmd.nextToken());
                        }
                        break;
                    default:
                        break;
                }
            }

            System.out.print("#" + t + " ");
            for(int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
