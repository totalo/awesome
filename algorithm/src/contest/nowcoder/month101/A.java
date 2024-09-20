package contest.nowcoder.month101;

import java.io.*;
import java.util.*;


/**
 * <a href="https://ac.nowcoder.com/acm/contest/90072/A">...</a>
 *
 */

public class A {
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] s = reader.readLine().split(" ");
        
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        
        int[] arr = new int[n];
        String[] s1 = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i <= k; i++) {
            int sum = 0;
            for (int j = i; j < n - k + i; j++) {
                sum += arr[j];
            }
            ans = Math.max(ans, sum);
        }
        
        writer.write(ans + "\n");
        
        
        reader.close();
        writer.close();
    }
}