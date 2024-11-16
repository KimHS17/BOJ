import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            String[] map = new String[8];
            int cnt = 0;
            
            for(int i = 0; i < 8; i++) {
            	map[i] = sc.next();
            }
            
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(j + n <= 8) {
                        boolean flag = true;
                    	
                        for(int k = 0; k < n / 2; k++) {
                        	if(map[i].charAt(j + k) != map[i].charAt(j + n - k - 1)) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                                cnt++;
                    }
                    if(i + n <= 8) {
                        boolean flag = true;
                    	
                        for(int k = 0; k < n / 2; k++) {
                        	if(map[i + k].charAt(j) != map[i + n - k - 1].charAt(j)) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                                cnt++;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}